package com.project.objectmap;

public class ObjectRepos {

	public static class SignInPage {
		public static final String signIn_linkText = "Sign in";
	}

	public static class CreateAccountPage {
		public static final String createAccount_id = "email_create";
		public static final String createAccount_errorAlert_id = "create_account_error";
		public static final String createAccount_login_Email_id = "email";
		public static final String createAccount_login_Password_id = "passwd";
		public static final String createAccount_createAccountBtn_id = "SubmitCreate";
		public static final String createAccount_accountTitle_id = "id_gender1";
		public static final String createAccount_firstName_id = "customer_firstname";
		public static final String createAccount_LastName_id = "customer_lastname";
		public static final String createAccount_PassWord_id = "passwd";
		public static final String createAccount_addfirstName_id = "firstname";
		public static final String createAccount_addLastName_id = "lastname";
		public static final String createAccount_address_id = "address1";
		public static final String createAccount_city_id = "city";
		public static final String createAccount_state_id = "id_state";
		public static final String createAccount_zip_id = "postcode";
		public static final String createAccount_country_id = "id_country";
		public static final String createAccount_mobilePhone_id = "phone_mobile";
		public static final String createAccount_registerBtn_id = "submitAccount";
		public static final String createAccount_emptyCountryAlert_xpath = "//*[@id ='center_column']/div[1]/p[1]";
		public static final String createAccount_loginBtn_id = "SubmitLogin";
		public static final String createAccount_signOut_linkText = "Sign out";
		public static final String createAccount_searchKey_id = "search_query_top";
		public static final String createAccount_searchBtn_xpath = "//*[@id='searchbox']/button";
		public static final String createAccount_invalidLogin_Error_xpath = "//*[@id='center_column']/div[1]/p";
		public static final String createAccount_validateAccount_xpath = "//*[@id='center_column']/h1";
		//public static final String createAccount_amyAccScreen_xpath = "//*[@id='center_column']/h1[text()='My account']";
		public static final String createAccount_afterlogout_xpath = "//*[@id='center_column']/h1[text()='Authentication']";
		public static final String createAccount_productSearchResult_xpath = "//*[@id='center_column']/p";
		public static final String createAccount_searchResults_xpath = "//*[@id='center_column']/h1/span[2]";
		
	}

	public static class ProductPage {
		public static final String Product_searchResult1_xpath = "//*[@itemprop='name']/a";
		public static final String Product_searchResult2_xpath = "//*[@id='center_column']/ul/li/div/div[2]/h5/a";
		public static final String Product_searchResult3_xpath = "//*[@id='center_column']/ul/li/div/div[2]/h5/a";
		public static final String Product_writeReviewLink_xpath = "//*[@id='product_comments_block_extra']/ul/li/a";
		public static final String Product_titleReview_id = "comment_title";
		public static final String Product_comments_id = "content";
		public static final String Product_sendReview_id = "submitNewMessage";
		public static final String Product_incorrectComment_xpath = "//*[@id='new_comment_form_error']";
		public static final String Product_closeReview_xpath = "//*[@id='new_comment_form_footer']/p[2]/a";
		public static final String Product_pInterestLink_xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[4]";
		public static final String Product_facebookLink_xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[2]";
		public static final String Product_GPlusLink_xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[3]";
		public static final String Product_Addtocart_xpath = "//*[@id='add_to_cart']/button/span";
		public static final String Product_Verifycart_xpath = "//*[@id='summary_products_quantity']";
		public static final String Product_Proceed1_xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span";
		public static final String Product_Proceed2_xpath = "//*[@id='center_column']/p[2]/a[1]/span";
		public static final String Product_Proceed3_xpath = "//*[@id='center_column']/form/p/button/span";
		public static final String Product_AgreeTerms_id = "cgv";
		public static final String Product_Proceed4_xpath = "//*[@id='form']/p/button/span";
		public static final String Product_BankPay_xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a";
		public static final String Product_CheckPay_xpath = "//*[@id='HOOK_PAYMENT']/div[2]/div/p/a";
		public static final String Product_ConfirmOrder_xpath = "//*[@id='cart_navigation']/button/span";
		public static final String Product_OrderConfirmationAlert_xpath = "//*[@id='center_column']/p[1]";
	}

	public static class PinterestPage {
		public static final String Pinterest_pUserName_id = "email";
		public static final String Pinterest_pPassword_id = "password";

	}

	public static class FacebookPage {
		public static final String Facebook_fUserName_id = "email";
		public static final String Facebook_fPassword_id = "pass";

	}

	public static class GPlusPage {
		public static final String GPlus_Email = "identifierId";
	}

/*	public static class Encartalabs {
		public static final String courses_xpath = "//a[text()='Courses' and @target]";
		public static final String testAutomation_xpath = "//a[contains(.,'Software Test Automation (123)')]";
		public static final String seleniumcourse_xpath = "//a[contains(text(),'Selenium WebDriver using Java')]";
		public static final String ciLabel_xpath = "//h2[contains(.,'Continuous Integration with Jenkins')]";
		public static final String contact_xpath = "//a[text()='Contact']";
	}*/

	
}
