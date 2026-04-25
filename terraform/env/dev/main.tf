module "vpc" {
  source = "../../modules/vpc"

  env                     = var.env
  cidr                    = var.cidr
  public_subnet_cidr      = var.public_subnet_cidr
  public_subnet_tag       = var.public_subnet_tag
  private_subnet_cidr     = var.private_subnet_cidr
  private_subnet_tag      = var.private_subnet_tag
  internet_gateway_tag    = var.internet_gateway_tag
}