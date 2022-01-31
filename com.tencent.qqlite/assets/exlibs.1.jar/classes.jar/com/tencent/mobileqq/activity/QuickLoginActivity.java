package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import bge;
import bgf;
import com.tencent.mobileqq.app.BaseActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.observer.AccountObserver;

public class QuickLoginActivity
  extends BaseActivity
{
  private static final String jdField_a_of_type_JavaLangString = "QuickLogin";
  ListView jdField_a_of_type_AndroidWidgetListView;
  SimpleAdapter jdField_a_of_type_AndroidWidgetSimpleAdapter;
  public ArrayList a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new bgf(this);
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131296466));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    e();
    d();
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("text", (String)localHashMap1.get("qq") + " " + (String)localHashMap1.get("password"));
      localArrayList.add(localHashMap2);
    }
    this.jdField_a_of_type_AndroidWidgetSimpleAdapter = new SimpleAdapter(this, localArrayList, 2130903048, new String[] { "text" }, new int[] { 2131296467 });
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_AndroidWidgetSimpleAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new bge(this));
  }
  
  private void e()
  {
    Object localObject = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/com/tencent/mobileqq/quicklogin.txt");
    if (((File)localObject).exists()) {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File)localObject)));
        for (localObject = localBufferedReader.readLine(); localObject != null; localObject = localBufferedReader.readLine())
        {
          localObject = ((String)localObject).split(" ");
          if (localObject.length == 2)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("qq", localObject[0]);
            localHashMap.put("password", localObject[1]);
            this.jdField_a_of_type_JavaUtilArrayList.add(localHashMap);
          }
        }
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903047);
    c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QuickLoginActivity
 * JD-Core Version:    0.7.0.1
 */