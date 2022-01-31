package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopBarPostContentEntity.Pic_list;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyLBSApiPOI;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.ReplyDataEntity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import gtd;
import gte;
import gtf;
import gtg;
import gth;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarReplyActivity
  extends BaseActivity
  implements View.OnClickListener, EmoticonCallback, HttpWebCgiAsyncTask.Callback, InputMethodRelativeLayout.onSizeChangedListenner
{
  protected static final int a = 3;
  protected static final int b = 700;
  protected long a;
  protected Drawable a;
  public Uri a;
  protected Handler a;
  protected View a;
  protected Button a;
  public EditText a;
  protected FrameLayout a;
  protected ImageButton a;
  protected ImageView a;
  public LinearLayout a;
  public SystemEmoticonPanel a;
  protected TroopBarPublishActivity.PreUploadTask a;
  protected TroopBarReplyActivity.LocListener a;
  protected TroopBarUtils.MyLBSApiPOI a;
  protected InputMethodRelativeLayout a;
  public QQProgressDialog a;
  protected ActionSheet a;
  protected CharSequence a;
  protected String a;
  public ArrayList a;
  protected boolean a;
  public ImageButton b;
  protected String b;
  protected ArrayList b;
  protected boolean b;
  protected int c;
  protected String c;
  protected boolean c;
  protected int d;
  protected String d;
  protected boolean d;
  protected String e;
  protected boolean e;
  protected String f;
  protected boolean f;
  protected boolean g = false;
  
  public TroopBarReplyActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidNetUri = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$LocListener = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new gth(this);
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    Object localObject = "";
    boolean bool;
    switch (paramInt)
    {
    default: 
      paramVarArgs = (String[])localObject;
      bool = false;
      label41:
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(bool);
      if (!bool) {
        break;
      }
    }
    for (paramVarArgs = getString(2131558484, new Object[] { paramVarArgs });; paramVarArgs = getString(2131558483))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = getString(2131561058);
      bool = false;
      break label41;
      String str = getString(2131561057);
      localObject = str;
      if (paramVarArgs == null) {
        break;
      }
      localObject = str;
      if (paramVarArgs.length <= 0) {
        break;
      }
      QQToast.a(this, paramVarArgs[0], 1).b(d());
      paramVarArgs = str;
      bool = false;
      break label41;
      paramVarArgs = getString(2131561056);
      bool = false;
      break label41;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!android.text.TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (android.text.TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        bool = true;
        break label41;
      }
      a(0, new String[0]);
      return;
    }
  }
  
  protected void a(View paramView, String paramString, int paramInt)
  {
    View localView;
    URLImageView localURLImageView;
    Object localObject2;
    if ((paramView != null) && (!android.text.TextUtils.isEmpty(paramString)))
    {
      localView = paramView.findViewById(2131232528);
      localURLImageView = (URLImageView)paramView.findViewById(2131232527);
      localURLImageView.setAdjustViewBounds(false);
      localObject1 = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = 100;
      ((RelativeLayout.LayoutParams)localObject1).height = 100;
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      localObject1 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = Utils.a(this, 2.0F);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = Utils.a(this, 2.0F);
      localObject2 = new File(paramString);
    }
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      label259:
      try
      {
        if (!((File)localObject2).exists()) {
          break label259;
        }
        localObject2 = URLDrawable.getDrawable(((File)localObject2).toURL(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        label147:
        break label147;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      ((Drawable)localObject2).setBounds(0, 0, 100, 100);
      localURLImageView.setImageDrawable((Drawable)localObject2);
      localURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      localView.setTag(paramString);
      localView.setOnClickListener(this);
      localURLImageView.setTag(paramString);
      localURLImageView.setOnClickListener(this);
      paramView = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      paramView.rightMargin = Utils.a(this, 2.0F);
      paramView.width = (Utils.a(this, 10.0F) + 100);
      paramView.height = (Utils.a(this, 17.0F) + 100);
      return;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  protected void a(ArrayList paramArrayList)
  {
    runOnUiThread(new gte(this));
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (((TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(str) != null) {
      new TroopBarPublishActivity.PicUploadThread(this, this.jdField_a_of_type_AndroidOsHandler, paramArrayList).start();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("qqBaseActivity", 2, "startUploadImage skey is null!!!!!!!!!!!!!!!");
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      if (paramJSONObject == null) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_b_of_type_JavaUtilArrayList == null)
        {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          break label479;
          if (paramInt < paramJSONObject.length())
          {
            this.jdField_b_of_type_JavaUtilArrayList.add(new TroopBarUtils.MyLBSApiPOI(paramJSONObject.getJSONObject(paramInt)));
            paramInt += 1;
            continue;
          }
        }
        else
        {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramJSONObject.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI != null)
        {
          if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.j))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.k;
            a(1, new String[] { paramJSONObject });
            return;
            if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI = ((TroopBarUtils.MyLBSApiPOI)this.jdField_b_of_type_JavaUtilArrayList.get(0));
            continue;
          }
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.j;
          continue;
        }
        a(0, new String[0]);
        return;
      }
      a(3, new String[0]);
      return;
      a(false);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if (paramJSONObject != null)
      {
        paramInt = paramJSONObject.optInt("retcode", -1);
        if (paramInt != -1)
        {
          this.g = false;
          paramBundle = paramJSONObject.optString("msg");
          paramJSONObject = paramBundle;
          if (android.text.TextUtils.isEmpty(paramBundle)) {
            paramJSONObject = getString(2131560704, new Object[] { Integer.valueOf(paramInt) });
          }
          QQToast.a(this, 1, paramJSONObject, 0).b(d());
          TroopBarUtils.a("reply_page", "fail", this.jdField_e_of_type_JavaLangString, "4", "", "");
          return;
        }
        String str = this.jdField_e_of_type_JavaLangString;
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
        for (paramBundle = "0";; paramBundle = "1")
        {
          TroopBarUtils.a("reply_page", "suc", str, "", paramBundle, "");
          this.jdField_f_of_type_Boolean = true;
          QQToast.a(this, 2, 2131560741, 1).b(d());
          paramBundle = new Intent();
          paramBundle.putExtra("result", paramJSONObject.toString());
          setResult(-1, paramBundle);
          finish();
          return;
        }
      }
      QQToast.a(this, 1, 2131560703, 0).b(d());
      return;
      label479:
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131560747);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130839369);
      this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131558489));
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 8) {
        break label53;
      }
      QQToast.a(this, getString(2131560946, new Object[] { Integer.valueOf(8) }), 1).b(d());
    }
    label53:
    while (android.text.TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    View localView = LayoutInflater.from(this).inflate(2130903411, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    a(localView, paramString, this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    i();
    return true;
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 8))
    {
      QQToast.a(this, getString(2131560946, new Object[] { Integer.valueOf(8) }), 1).b(d());
      return false;
    }
    Object localObject = new ArrayList(paramArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int k = ((ArrayList)localObject).size();
      if (j > k) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(k, j - k);
      }
      for (;;)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i), (String)this.jdField_a_of_type_JavaUtilArrayList.get(i), i);
          i += 1;
        }
        if (j < k)
        {
          paramArrayList = LayoutInflater.from(this);
          i = 0;
          while (i < k - j)
          {
            localObject = paramArrayList.inflate(2130903411, null);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
            i += 1;
          }
        }
      }
      i();
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    i();
    return false;
  }
  
  public void b()
  {
    if (this.g) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask = null;
    }
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      i = str.length();
      if (i == 0)
      {
        QQToast.a(this, 2131560730, 0).b(d());
        TroopBarUtils.a("reply_page", "fail", this.jdField_e_of_type_JavaLangString, "2", "", "");
        return;
      }
      if (i < this.jdField_c_of_type_Int)
      {
        QQToast.a(this, getString(2131560731, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) }), 0).b(d());
        TroopBarUtils.a("reply_page", "fail", this.jdField_e_of_type_JavaLangString, "2", "", "");
        return;
      }
      if (i > this.jdField_d_of_type_Int)
      {
        QQToast.a(this, getString(2131560732, new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }), 0).b(d());
        TroopBarUtils.a("reply_page", "fail", this.jdField_e_of_type_JavaLangString, "4", "", "");
        return;
      }
    }
    if (!HttpUtil.a(this))
    {
      QQToast.a(this, 2131562450, 0).b(d());
      TroopBarUtils.a("reply_page", "fail", this.jdField_e_of_type_JavaLangString, "7", "", "");
      return;
    }
    a(true);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((TroopBarPostContentEntity.Pic_list)TroopBarUtils.a.get(localObject) == null)
      {
        a(this.jdField_a_of_type_JavaUtilArrayList);
        TroopBarUtils.a("reply_page", "fail", this.jdField_e_of_type_JavaLangString, "10", "", "");
        return;
      }
      i += 1;
    }
    str = TroopBarPublishActivity.a(str, this.jdField_a_of_type_JavaUtilArrayList);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("bid", this.jdField_e_of_type_JavaLangString);
    ((Bundle)localObject).putString("pid", this.jdField_f_of_type_JavaLangString);
    ((Bundle)localObject).putString("comment", str);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI != null)
    {
      ((Bundle)localObject).putString("uid", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.h);
      ((Bundle)localObject).putString("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.jdField_b_of_type_Int));
      ((Bundle)localObject).putString("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.jdField_a_of_type_Int));
    }
    TroopBarUtils.b(this, (Bundle)localObject, "http://xiaoqu.qq.com/cgi-bin/bar/post/comment_v2", 7, null, this);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  protected boolean c()
  {
    Object localObject = getIntent().getExtras().getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "publish option: " + (String)localObject);
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      long l = ((JSONObject)localObject).optLong("bid", 0L);
      this.jdField_e_of_type_JavaLangString = String.valueOf(l);
      this.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("pid");
      this.jdField_d_of_type_JavaLangString = ("bid:" + l + "&pid:" + this.jdField_f_of_type_JavaLangString);
      d();
      this.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("minContentLength", this.jdField_c_of_type_Int);
      this.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("maxContentLength", this.jdField_d_of_type_Int);
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("contentPlaceholder", this.jdField_a_of_type_JavaLangString);
      this.jdField_e_of_type_Boolean = ((JSONObject)localObject).optBoolean("photoOrContent");
      this.jdField_a_of_type_Boolean = ((JSONObject)localObject).optBoolean("photoOrContent");
      this.jdField_b_of_type_Boolean = ((JSONObject)localObject).optBoolean("needLocation", true);
      this.jdField_d_of_type_Boolean = ((JSONObject)localObject).optBoolean("needFace", true);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839362);
      this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131561262);
      TroopBarUtils.a("reply_page", "exp", String.valueOf(l), "", "", "");
      return true;
    }
    catch (JSONException localJSONException)
    {
      QQToast.a(this, 1, getString(2131560704, new Object[] { Integer.valueOf(999) }), 0).b(d());
    }
    return false;
  }
  
  public void d() {}
  
  protected boolean d()
  {
    TroopBarUtils.ReplyDataEntity localReplyDataEntity = (TroopBarUtils.ReplyDataEntity)TroopBarUtils.b.get(this.jdField_d_of_type_JavaLangString);
    TroopBarUtils.b.clear();
    if (localReplyDataEntity == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList = localReplyDataEntity.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI = localReplyDataEntity.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI;
    this.jdField_b_of_type_JavaUtilArrayList = localReplyDataEntity.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_c_of_type_Int = localReplyDataEntity.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = localReplyDataEntity.jdField_b_of_type_Int;
    this.jdField_a_of_type_JavaLangString = localReplyDataEntity.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = localReplyDataEntity.jdField_b_of_type_JavaLangString;
    return true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (this.jdField_a_of_type_AndroidNetUri == null);
    paramIntent = com.tencent.mobileqq.utils.ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
    com.tencent.mobileqq.utils.ImageUtil.a(this, paramIntent);
    a(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask = new TroopBarPublishActivity.PreUploadTask(this, this.jdField_a_of_type_JavaUtilArrayList);
    ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask);
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI = ((TroopBarUtils.MyLBSApiPOI)paramIntent.getParcelableExtra("key_selected_poi"));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI != null) {
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.j))
      {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.k;
        a(1, new String[] { paramIntent });
      }
    }
    for (;;)
    {
      TroopBarUtils.a("reply_page", "choose_place", this.jdField_e_of_type_JavaLangString, "2", "", "");
      return;
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.j;
      break;
      a(0, new String[0]);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!c())
    {
      finish();
      return false;
    }
    e();
    com.tencent.biz.common.util.ImageUtil.b((String)null, 0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.jdField_f_of_type_Boolean) {
      h();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (paramIntent != null)
      {
        a(paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask = new TroopBarPublishActivity.PreUploadTask(this, this.jdField_a_of_type_JavaUtilArrayList);
        ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask);
      }
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    }
  }
  
  protected void e()
  {
    int j = 0;
    setContentView(2130903412);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131232490));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131232530));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131232512));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232517));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131232510));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232067));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232532));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232531);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131232472));
    a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishActivity.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new gtd(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    findViewById(2131232473).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setPressed(false);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_c_of_type_Int <= 0) || (this.jdField_d_of_type_Int <= 0))
    {
      this.jdField_c_of_type_Int = 3;
      this.jdField_d_of_type_Int = 700;
      this.jdField_a_of_type_JavaLangString = getString(2131560717, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int) });
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_JavaLangString);
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    Object localObject;
    if (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      localEditText.setText((CharSequence)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI == null) {
        break label491;
      }
      if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.j)) {
        break label480;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.k;
      label388:
      a(1, new String[] { localObject });
      label401:
      f();
      TroopBarUtils.a("reply_page", "choose_place", this.jdField_e_of_type_JavaLangString, "0", "", "");
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_b_of_type_Boolean) {
        break label503;
      }
      i = 0;
      label450:
      ((ImageView)localObject).setVisibility(i);
      localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (!this.jdField_d_of_type_Boolean) {
        break label509;
      }
    }
    label480:
    label491:
    label503:
    label509:
    for (int i = j;; i = 4)
    {
      ((ImageButton)localObject).setVisibility(i);
      return;
      localObject = null;
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.j;
      break label388;
      a(0, new String[0]);
      break label401;
      i = 8;
      break label450;
    }
  }
  
  protected void f()
  {
    if (SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$LocListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$LocListener = new TroopBarReplyActivity.LocListener(this, 1, 1, 4, 1);
      }
      SOSOMapLBSApi.getInstance().requestLocationUpdate(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity$LocListener);
    }
    a(2, new String[0]);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968590);
    if (((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.length() > 0)) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))) {}
    for (String str = "0";; str = "1")
    {
      TroopBarUtils.a("reply_page", "un", this.jdField_e_of_type_JavaLangString, str, "", "");
      return;
    }
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.a(2131563013, 1);
    localActionSheet.a(2131562302, 1);
    localActionSheet.d(2131561746);
    localActionSheet.a(new gtg(this, localActionSheet));
    localActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
  }
  
  protected void h()
  {
    int j = 0;
    TroopBarUtils.ReplyDataEntity localReplyDataEntity = new TroopBarUtils.ReplyDataEntity();
    ArrayList localArrayList;
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      localReplyDataEntity.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI != null)
    {
      localReplyDataEntity.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI = new TroopBarUtils.MyLBSApiPOI(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI);
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localArrayList = new ArrayList();
        i = j;
        while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          localArrayList.add(new TroopBarUtils.MyLBSApiPOI((TroopBarUtils.MyLBSApiPOI)this.jdField_b_of_type_JavaUtilArrayList.get(i)));
          i += 1;
        }
        localReplyDataEntity.jdField_b_of_type_JavaUtilArrayList = localArrayList;
      }
    }
    localReplyDataEntity.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
    localReplyDataEntity.jdField_b_of_type_Int = this.jdField_d_of_type_Int;
    localReplyDataEntity.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localReplyDataEntity.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    TroopBarUtils.b.put(this.jdField_d_of_type_JavaLangString, localReplyDataEntity);
  }
  
  public void i()
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      View[] arrayOfView = new View[k];
      int i = 0;
      while (i < k)
      {
        arrayOfView[i] = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      i = j;
      while (i < k)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(arrayOfView[i]);
        i += 1;
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
    case 2131232473: 
    case 2131232517: 
    case 2131232512: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.w("qqBaseActivity", 2, "transparent_space click!!!!!!!!!!!!!!!");
        }
        finish();
        return;
        paramView = new Intent(this, TroopBarPublishLocationSelectActivity.class);
        paramView.putParcelableArrayListExtra("current_location_list", this.jdField_b_of_type_JavaUtilArrayList);
        paramView.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI);
        startActivityForResult(paramView, 1002);
        String str = this.jdField_e_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI != null) {}
        for (paramView = "0";; paramView = "1")
        {
          TroopBarUtils.a("reply_page", "Clk_place", str, paramView, "", "");
          return;
        }
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
        InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130839369);
        this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131558489));
        return;
      }
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gtf(this), 200L);
      return;
    case 2131232530: 
      if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 8)
      {
        QQToast.a(this, getString(2131560746, new Object[] { Integer.valueOf(8) }), 1).b(d());
        return;
      }
      g();
      return;
    case 2131232528: 
      paramView = (String)paramView.getTag();
      i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramView);
      this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(i);
      i();
      TroopBarUtils.a("reply_page", "del_photo", this.jdField_e_of_type_JavaLangString, "", "", "");
      return;
    case 2131232527: 
      paramView = (String)paramView.getTag();
      i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramView);
      AlbumUtil.a();
      paramView = new Intent(this, ImagePreviewActivity.class);
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
      paramView.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", TroopBarReplyActivity.class.getName());
      paramView.putExtra("selected_photo_index", i);
      paramView.putExtra("back_btn_text", getString(2131560719));
      paramView.addFlags(603979776);
      startActivity(paramView);
      AlbumUtil.a(this, true, true);
      TroopBarUtils.a("pub_page", "choose_photo", this.jdField_e_of_type_JavaLangString, "", "", "");
      return;
    }
    b();
  }
  
  public void u_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity
 * JD-Core Version:    0.7.0.1
 */