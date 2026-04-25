output "vpc_id" {
  value = aws_vpc.walwil_vpc.id
}

output "public_subnet_1_id" {
  value = aws_subnet.walwil_public_subnet.id
}

output "public_subnet_2_id" {
  value = aws_subnet.walwil_private_subnet.id
}