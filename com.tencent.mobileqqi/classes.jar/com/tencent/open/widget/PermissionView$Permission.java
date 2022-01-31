package com.tencent.open.widget;

import org.json.JSONObject;

public class PermissionView$Permission
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  
  public PermissionView$Permission()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PermissionView$Permission(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramJSONObject.getInt("default_flag");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("title");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("api_list");
    this.jdField_b_of_type_Int = paramJSONObject.getInt("id");
    if (paramJSONObject.getInt("is_new") > 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (this.jdField_b_of_type_Int == 1001) {
      this.jdField_a_of_type_JavaLangString += " (默认)";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.widget.PermissionView.Permission
 * JD-Core Version:    0.7.0.1
 */