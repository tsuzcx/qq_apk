package com.tencent.mobileqq.activity.contact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import edg;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@SuppressLint({"UseSparseArrays"})
public class OnlineStatusIconHelper
{
  private static OnlineStatusIconHelper jdField_a_of_type_ComTencentMobileqqActivityContactOnlineStatusIconHelper;
  private static final String jdField_a_of_type_JavaLangString = "online_status_icon_config.xml";
  public HashMap a;
  
  private OnlineStatusIconHelper(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    a(paramContext);
  }
  
  public static OnlineStatusIconHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityContactOnlineStatusIconHelper == null) {
        jdField_a_of_type_ComTencentMobileqqActivityContactOnlineStatusIconHelper = new OnlineStatusIconHelper(BaseApplicationImpl.getContext());
      }
      return jdField_a_of_type_ComTencentMobileqqActivityContactOnlineStatusIconHelper;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    try
    {
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      edg localedg = new edg(this);
      localSAXParser.parse(paramContext.getAssets().open("online_status_icon_config.xml"), localedg);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public int a(int paramInt)
  {
    return a(paramInt, 1);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localInteger == null) {
      return paramInt2;
    }
    return localInteger.intValue();
  }
  
  public boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    return (paramInt == 3) || (paramInt == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper
 * JD-Core Version:    0.7.0.1
 */