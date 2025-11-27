terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = var.region
}

resource "aws_vpc" "main" {
  cidr_block = var.vpc_cidr
  tags = { Name = "main-vpc" }
}

resource "aws_subnet" "public" {
  vpc_id                  = aws_vpc.main.id
  cidr_block              = var.public_subnet_cidr
  map_public_ip_on_launch = true
  tags = { Name = "public-subnet" }
}

resource "aws_security_group" "web_sg" {
  name        = var.sg_name
  description = "Allow SSH, HTTP, PostgreSQL"
  vpc_id      = aws_vpc.main.id

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "project" {
           ami_id = var.ami_id
		   instance_type = var.instance_type
		   key_name = var.key_name
		   subnet_id = var.subnet_id
		   security_groups = [aws_security_group.web_sg.name]
		}

resource "local_file" "justFile" {
           content = var.filecontent
		   filename = var.filename
		}

resource "aws_s3" "bcuket1" {
     bucket = var.bucket1name
	 }
