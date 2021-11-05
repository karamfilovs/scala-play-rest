package dto

case class Client(firm_name: String, firm_town: String, firm_addr: String, firm_mol: String, firm_is_reg_vat: Boolean, country: String = "Bulgaria")
