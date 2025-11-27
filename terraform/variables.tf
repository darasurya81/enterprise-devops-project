variable "vpc_cidr" {
          default = "10.0.0.0/16'
		  }
variable "public_subnet_cidr" {
          default = "10.0.1.0/24'
		  }
variable "sg_name" {
          default = "web_sg"
		  }		  
variable "ami_id" {
          default = "0.0.0.0/24'
		  }
variable "instance_type" {
          default = "t2.small"
		  }
variable "key_name" {
          default = "newone.pem"
		  }
variable "subnet_id" {
          default = "0.0.0.0/24'
		  }
variable "filecontent" {
          default = "created file from terraform automate"
		  }
variable "filename" {
          default = "home/ec2-user/just1.txt'
		  }
variable "bucket1name" {
          default = "thisbucketiscreatedv01919"
		  }
variable "region" {
          default = "ap-south-1"
		  }
