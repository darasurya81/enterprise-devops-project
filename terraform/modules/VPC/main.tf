resource "aws_vpc" "walwil_vpc" {
  cidr_block           = var.cidr
  enable_dns_support   = true
  enable_dns_hostnames = true

  tags = {   
    Name        = var.vpc_tag
    Environment = var.env
    ManagedBy   = "Terraform"
    Project     = "enterprise-devops-project"
  }
}

resource "aws_subnet" "walwil_public_subnet" {
  vpc_id     = aws_vpc.walwil_vpc.id
  cidr_block = var.public_subnet_cidr

  tags = {
    Name        = var.public_subnet_tag
    Environment = var.env
    ManagedBy   = "Terraform"
    Project     = "enterprise-devops-project"
  }
}

resource "aws_subnet" "walwil_private_subnet" {
  vpc_id     = aws_vpc.walwil_vpc.id
  cidr_block = var.private_subnet_cidr

  tags = {
    Name        = var.private_subnet_tag
    Environment = var.env
    ManagedBy   = "Terraform"
    Project     = "enterprise-devops-project"
  }
}

resource "aws_internet_gateway" "walwil_igw" {
  vpc_id = aws_vpc.walwil_vpc.id

  tags = {
    Name        = var.internet_gateway_tag
    Environment = var.env
    ManagedBy   = "Terraform"
    Project     = "enterprise-devops-project"
  }
}

resource "aws_route_table" "walwil_public_RT" {
  vpc_id = aws_vpc.walwil_vpc.id

  }
  
resource "aws_route_table" "walwil_private_RT" {
  vpc_id = aws_vpc.walwil_vpc.id
  }
  
resource "aws_route_table_association" "Public_RT_ASS" {
  subnet_id      = aws_subnet.walwil_public_subnet.id
  route_table_id = aws_route_table.walwil_public_RT.id
}

resource "aws_route_table_association" "Private_RT_ASS" {
  subnet_id      = aws_subnet.walwil_private_subnet.id
  route_table_id = aws_route_table.walwil_private_RT.id
}

resource "aws_route" "public_internet" {
  route_table_id         = aws_route_table.walwil_public_RT.id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id             = aws_internet_gateway.walwil_igw.id
}
