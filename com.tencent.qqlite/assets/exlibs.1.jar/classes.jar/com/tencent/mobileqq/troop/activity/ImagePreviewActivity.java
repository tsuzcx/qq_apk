package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.Gallery;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class ImagePreviewActivity
  extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener
{
  public static final String a = "PhotoConst.PHOTO_PATHS";
  public static final String b = "selected_photo_index";
  public static final String c = "back_btn_text";
  protected int a;
  protected Drawable a;
  protected View a;
  protected Button a;
  protected CheckBox a;
  protected TextView a;
  protected ImagePreviewActivity.ImageAdapter a;
  protected Gallery a;
  protected ArrayList a;
  protected boolean a;
  protected int b;
  protected View b;
  protected Button b;
  protected TextView b;
  protected ArrayList b;
  protected boolean b;
  protected int c;
  protected boolean c;
  protected String d = null;
  protected String e = null;
  protected String f = null;
  
  public ImagePreviewActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Boolean = false;
  }
  
  private ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      if ((localInteger != null) && (localInteger.intValue() >= 0) && (localInteger.intValue() < this.jdField_a_of_type_JavaUtilArrayList.size())) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(localInteger.intValue()));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!new File((String)((Iterator)localObject).next()).exists()) {
        ((Iterator)localObject).remove();
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837553);
    this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.d = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
    this.e = localIntent.getStringExtra("back_btn_text");
    this.jdField_a_of_type_Int = localIntent.getIntExtra("selected_photo_index", 0);
    this.f = localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297424);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297263);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297433));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131297432));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131297431));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296936));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297425));
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131297187));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity$ImageAdapter = new ImagePreviewActivity.ImageAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity$ImageAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131492924));
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.e);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    e();
  }
  
  private void e()
  {
    String str = getString(2131363957);
    if (this.d != null) {
      str = this.d;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(str);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setText(str + "(" + this.jdField_b_of_type_JavaUtilArrayList.size() + ")");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(str);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void a(AdapterView paramAdapterView) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected boolean a()
  {
    finish();
    AlbumUtil.a(this, true, false);
    return true;
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.jdField_a_of_type_Int)));
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt + 1 + " / " + this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131363435));
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void doOnBackPressed()
  {
    if (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)) {
      super.doOnBackPressed();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903270);
    paramBundle = getResources().getDisplayMetrics();
    this.jdField_b_of_type_Int = paramBundle.widthPixels;
    this.jdField_c_of_type_Int = paramBundle.heightPixels;
    c();
    d();
    return true;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    c();
    d();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297431: 
      if (this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.jdField_a_of_type_Int)))
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        int i = this.jdField_b_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.jdField_a_of_type_Int));
        if (i >= 0) {
          this.jdField_b_of_type_JavaUtilArrayList.remove(i);
        }
        e();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(this.jdField_a_of_type_Int));
      e();
      return;
    case 2131297425: 
      a();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    paramView = new Intent();
    paramView.setClassName(this, this.f);
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", a());
    paramView.addFlags(603979776);
    startActivity(paramView);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (localObject != null)
        {
          localObject = new File((String)localObject);
          try
          {
            URLDrawable.removeMemoryCacheByUrl(((File)localObject).toURL().toString());
          }
          catch (Exception localException) {}
          if (!QLog.isColorLevel()) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.ImagePreviewActivity
 * JD-Core Version:    0.7.0.1
 */