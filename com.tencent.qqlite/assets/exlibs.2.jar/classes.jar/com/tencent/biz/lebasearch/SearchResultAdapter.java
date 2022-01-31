package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import oa;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchResultAdapter
  extends BaseAdapter
{
  public static final String a = "SearchResultAdapter";
  private ViewPluginManager jdField_a_of_type_ComTencentBizViewpluginViewPluginManager;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  JSONArray jdField_a_of_type_OrgJsonJSONArray;
  
  public SearchResultAdapter(Context paramContext, ViewPluginManager paramViewPluginManager, JSONArray paramJSONArray)
  {
    a(paramJSONArray);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = paramViewPluginManager;
  }
  
  public static SpannableString a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 == null) {
      return new SpannableString(paramString1);
    }
    int i = paramString1.indexOf(paramString2);
    if (i != -1)
    {
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), i, paramString2.length() + i, 34);
      return paramString1;
    }
    return new SpannableString(paramString1);
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.jdField_a_of_type_OrgJsonJSONArray = paramJSONArray;
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    if (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
    {
      paramJSONArray = this.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(i);
      oa localoa = new oa(this);
      localoa.d = 1;
      if (paramJSONArray.has("result_name"))
      {
        localoa.jdField_a_of_type_JavaLangObject = paramJSONArray.optString("result_name");
        localoa.jdField_a_of_type_JavaLangString = paramJSONArray.optString("result_name");
      }
      Object localObject;
      if (paramJSONArray.has("result_extension"))
      {
        localObject = paramJSONArray.optJSONArray("result_extension");
        if (((JSONArray)localObject).length() != 0) {}
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilList.add(localoa);
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          localoa = new oa(this);
          localoa.d = 2;
          localoa.jdField_a_of_type_JavaLangObject = ((JSONArray)localObject).optJSONObject(j);
          localoa.jdField_a_of_type_JavaLangString = paramJSONArray.optString("result_name");
          this.jdField_a_of_type_JavaUtilList.add(localoa);
          j += 1;
        }
        if ((paramJSONArray.has("more_url")) && (!TextUtils.isEmpty(paramJSONArray.optString("more_url"))))
        {
          localObject = new oa(this);
          ((oa)localObject).d = 3;
          ((oa)localObject).jdField_a_of_type_JavaLangObject = paramJSONArray.optString("more_url");
          ((oa)localObject).jdField_a_of_type_JavaLangString = paramJSONArray.optString("result_name");
          ((oa)localObject).b = paramJSONArray.optString("more_name");
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    int j = 0;
    Object localObject2 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return null;
    }
    oa localoa = (oa)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localoa.d == 1)
    {
      paramView = new TextView((Context)localObject2);
      paramView.setBackgroundColor(((Context)localObject2).getResources().getColor(2131427418));
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)DisplayUtils.a((Context)localObject2, 23.0F)));
      paramView.setTextColor(((Context)localObject2).getResources().getColor(2131427395));
      paramView.setTextSize(14.0F);
      paramView.setPadding((int)DisplayUtils.a((Context)localObject2, 15.0F), 0, 0, 0);
      paramView.setText((String)localoa.jdField_a_of_type_JavaLangObject);
      paramView.setGravity(16);
      paramView.setFocusable(true);
      return paramView;
    }
    Object localObject1;
    if (localoa.d == 2)
    {
      localObject1 = (JSONObject)localoa.jdField_a_of_type_JavaLangObject;
      paramViewGroup = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(((JSONObject)localObject1).optInt("result_type"));
      if (paramViewGroup == null) {
        break label449;
      }
      if (ViewPluginManager.a(paramViewGroup, ((JSONObject)localObject1).toString()))
      {
        paramInt = i;
        paramViewGroup.setTag(localoa);
        paramView = paramViewGroup;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (paramInt != 0) {
          break label447;
        }
        paramView = LayoutInflater.from((Context)localObject2).inflate(2130903292, null);
        paramViewGroup = (URLImageView)paramView.findViewById(2131297556);
        localObject2 = (TextView)paramView.findViewById(2131297557);
        SpannableString localSpannableString = a(((JSONObject)localObject1).optString("name"), ((JSONObject)localObject1).optString("keyword"));
        if (localSpannableString != null) {
          ((TextView)localObject2).setText(localSpannableString);
        }
        try
        {
          new URL(((JSONObject)localObject1).optString("pic_url"));
          localObject1 = URLDrawable.getDrawable(((JSONObject)localObject1).optString("pic_url"));
          ((URLDrawable)localObject1).addHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
          paramViewGroup.setImageDrawable((Drawable)localObject1);
          paramView.setTag(localoa);
          return paramView;
          paramInt = 0;
        }
        catch (MalformedURLException paramViewGroup)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SearchResultAdapter", 2, paramViewGroup.getMessage());
            }
          }
        }
      }
      if (localoa.d == 3)
      {
        paramView = LayoutInflater.from((Context)localObject2).inflate(2130903291, null);
        paramViewGroup = new AbsListView.LayoutParams(-1, (int)DisplayUtils.a((Context)localObject2, 44.0F));
        localObject1 = (TextView)paramView.findViewById(2131297555);
        if (!TextUtils.isEmpty(localoa.b)) {
          ((TextView)localObject1).setText(localoa.b);
        }
        paramView.setLayoutParams(paramViewGroup);
        paramView.setTag(localoa);
      }
      return paramView;
      label447:
      return paramView;
      label449:
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */