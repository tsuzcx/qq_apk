package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.data.TroopBarPostContentEntity.Pic_list;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyBar;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyLBSApiPOI;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.PublishDataEntity;
import com.tencent.mobileqq.troop.widget.ExtendInputMethodRelativeLayout;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import gwp;
import gwq;
import gwr;
import gws;
import gwt;
import gwu;
import gwv;
import gww;
import gwx;
import gwy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, EmoticonCallback, HttpWebCgiAsyncTask.Callback, InputMethodRelativeLayout.onSizeChangedListenner
{
  protected static final int a = 4;
  public static final String a = "1";
  public static final int b = 8;
  public static final String b = "0";
  protected static final int c = 1001;
  public static final String c = "key_photo_delete_action";
  protected static final int d = 1002;
  public static final String d = "key_photo_delete_position";
  protected static final int e = 1003;
  protected static final String e = "sync_weibo";
  protected static final int f = 0;
  protected static final String f = "sync_qzone";
  protected static final int g = 1;
  protected static final int h = 2;
  protected static final int i = 3;
  protected static final int j = 4;
  protected static final int k = 25;
  protected static final int l = 20;
  protected static final int m = 700;
  protected static final int n = 1001;
  protected static final int o = 1003;
  public static final int p = 500;
  public long a;
  protected BroadcastReceiver a;
  protected Drawable a;
  public Uri a;
  protected Handler a;
  protected View a;
  public EditText a;
  protected FrameLayout a;
  public ImageButton a;
  protected ImageView a;
  protected TextView a;
  public TroopBarPageEntity.TypeListEntity a;
  public SystemEmoticonPanel a;
  protected ExtendGridView a;
  public TroopBarImagePreviewAdapter a;
  protected TroopBarPublishActivity.LocListener a;
  protected TroopBarPublishActivity.PreUploadTask a;
  public TroopBarUtils.MyBar a;
  protected TroopBarUtils.MyLBSApiPOI a;
  protected ExtendInputMethodRelativeLayout a;
  public QQProgressDialog a;
  protected ActionSheet a;
  public ArrayList a;
  boolean a;
  protected View b;
  public EditText b;
  protected ImageView b;
  protected TextView b;
  protected ArrayList b;
  boolean b;
  protected View c;
  protected ImageView c;
  public TextView c;
  public ArrayList c;
  protected boolean c;
  protected View d;
  protected ImageView d;
  protected TextView d;
  protected boolean d;
  protected View e;
  protected boolean e;
  protected boolean f = true;
  protected String g;
  protected boolean g;
  protected String h;
  protected boolean h;
  protected String i;
  public boolean i;
  protected String j = null;
  protected String k;
  protected String l;
  protected String m;
  protected String n = null;
  protected int q = 0;
  protected int r = 0;
  protected int s = 0;
  protected int t = 0;
  
  public TroopBarPublishActivity()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExtendInputMethodRelativeLayout = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_b_of_type_AndroidWidgetEditText = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidNetUri = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$LocListener = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = null;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new gwx(this);
    this.jdField_a_of_type_AndroidOsHandler = new gwy(this);
  }
  
  @TargetApi(11)
  public static SystemAndEmojiEmoticonPanel a(Context paramContext, ViewGroup paramViewGroup, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(QQTextBuilder.a);
    Object localObject = Build.MODEL;
    if ((localObject != null) && ((((String)localObject).startsWith("SH-")) || (((String)localObject).startsWith("SBM")) || (((String)localObject).startsWith("SHL")))) {}
    try
    {
      localObject = TextView.class.getDeclaredField("mTextSelectHandleRes");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(paramEditText, Integer.valueOf(((Integer)((Field)localObject).get(new TextView(paramContext))).intValue()));
      label90:
      paramEditText = new SystemAndEmojiEmoticonPanel(paramContext, paramEmoticonCallback);
      paramEditText.setBackgroundResource(2130837627);
      paramViewGroup.addView(paramEditText, new RelativeLayout.LayoutParams(-1, (int)(150.0F * paramContext.getResources().getDisplayMetrics().density)));
      paramEditText.setVisibility(8);
      return paramEditText;
    }
    catch (Exception paramEditText)
    {
      break label90;
    }
  }
  
  public static String a(String paramString, ArrayList paramArrayList)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    try
    {
      localJSONObject.put("content", localObject);
      label29:
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramString = new ArrayList(paramArrayList);
        paramArrayList = new JSONArray();
        int i1 = 0;
        while (i1 < paramString.size())
        {
          localObject = (String)paramString.get(i1);
          localObject = (TroopBarPostContentEntity.Pic_list)TroopBarUtils.jdField_a_of_type_JavaUtilHashtable.get(localObject);
          if (localObject != null) {
            paramArrayList.put(((TroopBarPostContentEntity.Pic_list)localObject).getJsonObject());
          }
          i1 += 1;
        }
      }
      try
      {
        localJSONObject.put("pic_list", paramArrayList);
        label117:
        return localJSONObject.toString();
      }
      catch (JSONException paramString)
      {
        break label117;
      }
    }
    catch (JSONException paramString)
    {
      break label29;
    }
  }
  
  private void k()
  {
    if (((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) || (this.jdField_c_of_type_JavaUtilArrayList == null)) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this);
    int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localActionSheet.a(((TroopBarPageEntity.TypeListEntity)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).name, 1);
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity != null) {
      localActionSheet.a(2131560745, 3);
    }
    localActionSheet.d(2131561746);
    localActionSheet.a(new gwv(this, i2, localActionSheet));
    localActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    Object localObject = "";
    boolean bool;
    switch (paramInt)
    {
    default: 
      paramVarArgs = (String[])localObject;
      paramInt = 8;
      bool = false;
      label44:
      this.jdField_a_of_type_AndroidViewView.setSelected(bool);
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(bool);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVarArgs);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
      if (!bool) {
        break;
      }
    }
    for (paramVarArgs = getString(2131558484, new Object[] { paramVarArgs });; paramVarArgs = getString(2131558483))
    {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(paramVarArgs);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramVarArgs);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = getString(2131561058);
      paramInt = 8;
      bool = false;
      break label44;
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
      paramInt = 8;
      bool = false;
      break label44;
      paramVarArgs = getString(2131561056);
      paramInt = 8;
      bool = false;
      break label44;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!android.text.TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (android.text.TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        paramInt = 0;
        bool = true;
        break label44;
      }
      a(0, new String[0]);
      return;
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  protected void a(ArrayList paramArrayList)
  {
    runOnUiThread(new gwq(this));
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (((TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(str) != null) {
      new TroopBarPublishActivity.PicUploadThread(this, this.jdField_a_of_type_AndroidOsHandler, paramArrayList).start();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("IphoneTitleBarActivity", 2, "startUploadImage skey is null!!!!!!!!!!!!!!!");
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.q = paramJSONObject.optInt("minTitleLength", this.q);
      this.r = paramJSONObject.optInt("maxTitleLength", this.r);
      this.jdField_g_of_type_JavaLangString = paramJSONObject.optString("titlePlaceholder", this.jdField_g_of_type_JavaLangString);
      this.s = paramJSONObject.optInt("minContentLength", this.s);
      this.t = paramJSONObject.optInt("maxContentLength", this.t);
      this.jdField_i_of_type_JavaLangString = paramJSONObject.optString("contentPlaceholder", this.jdField_i_of_type_JavaLangString);
      this.jdField_g_of_type_Boolean = paramJSONObject.optBoolean("photoOrContent");
      this.jdField_c_of_type_Boolean = paramJSONObject.optBoolean("needPhoto", true);
      this.jdField_d_of_type_Boolean = paramJSONObject.optBoolean("needLocation", true);
      this.f = paramJSONObject.optBoolean("needFace", true);
      this.jdField_k_of_type_JavaLangString = paramJSONObject.optString("from");
      this.jdField_e_of_type_Boolean = paramJSONObject.optBoolean("needCategory", true);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.e = paramJSONObject.optInt("flag");
      }
      Object localObject = paramJSONObject.optJSONArray("categorys");
      if (localObject == null) {}
      for (paramJSONObject = paramJSONObject.optJSONArray("typelist"); paramJSONObject != null; paramJSONObject = (JSONObject)localObject)
      {
        localObject = new ArrayList();
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i1);
          if (localJSONObject != null) {
            ((ArrayList)localObject).add(new TroopBarPageEntity.TypeListEntity(localJSONObject));
          }
          i1 += 1;
        }
        this.jdField_c_of_type_JavaUtilArrayList = ((ArrayList)localObject);
        return;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 7: 
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
          break label618;
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
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.jdField_k_of_type_JavaLangString;
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
      b(false);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_m_of_type_AndroidWidgetTextView.setEnabled(true);
      if (paramJSONObject != null)
      {
        paramInt = paramJSONObject.optInt("retcode", -1);
        if (paramInt != -1)
        {
          paramBundle = paramJSONObject.optString("msg");
          paramJSONObject = paramBundle;
          if (android.text.TextUtils.isEmpty(paramBundle)) {
            paramJSONObject = getString(2131560704, new Object[] { Integer.valueOf(paramInt) });
          }
          QQToast.a(this, 1, paramJSONObject, 0).b(d());
          if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
          for (paramJSONObject = "0";; paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
          {
            TroopBarUtils.a("pub_page", "fail", paramJSONObject, "4", "", "");
            return;
          }
        }
        String str3;
        String str1;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null)
        {
          paramBundle = "0";
          str3 = this.n;
          if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break label521;
          }
          str1 = "0";
          label430:
          if (!this.jdField_a_of_type_Boolean) {
            break label528;
          }
        }
        label521:
        label528:
        for (String str2 = "0";; str2 = "1")
        {
          TroopBarUtils.a("pub_page", "suc", paramBundle, str3, str1, str2);
          this.jdField_h_of_type_Boolean = true;
          QQToast.a(this, 2, 2131560740, 1).b(d());
          paramBundle = new Intent();
          paramBundle.putExtra("result", paramJSONObject.toString());
          setResult(-1, paramBundle);
          finish();
          return;
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s;
          break;
          str1 = "1";
          break label430;
        }
      }
      QQToast.a(this, 1, 2131560703, 0).b(d());
      return;
      if ((paramJSONObject == null) || (paramJSONObject.optInt("retcode", -1) != -1)) {
        break;
      }
      long l1 = paramJSONObject.optLong("bid", 0L);
      paramBundle = paramJSONObject.optString("barName");
      if (l1 > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar = new TroopBarUtils.MyBar(l1, paramBundle);
      }
      a(paramJSONObject);
      j();
      return;
      label618:
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gww(this), 200L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130839367);
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131558489));
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent, View paramView)
  {
    int i2 = TroopBarUtils.a(getResources());
    int i3 = d();
    if (paramView != null)
    {
      int i1 = (int)paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      float f2 = i3;
      i2 = (int)(i2 + (f2 + f1));
      paramMotionEvent = TroopBarUtils.a(paramView);
      if ((paramMotionEvent != null) && (paramMotionEvent.contains(i1, i2))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  protected boolean a(String paramString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 8) {
        break label55;
      }
      QQToast.a(this, getString(2131560946, new Object[] { Integer.valueOf(8) }), 1).b(d());
    }
    label55:
    while (android.text.TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    paramString = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 8) {
      bool = true;
    }
    paramString.a(bool, true);
    return true;
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    boolean bool = false;
    if ((paramArrayList != null) && (paramArrayList.size() > 8)) {
      QQToast.a(this, getString(2131560946, new Object[] { Integer.valueOf(8) }), 1).b(d());
    }
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = new ArrayList(paramArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    } while (paramArrayList == null);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 8) {
      bool = true;
    }
    paramArrayList.a(bool, true);
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = TroopBarUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
    if ((this.jdField_b_of_type_AndroidWidgetEditText == null) || (paramEditable == null)) {}
    for (int i1 = 0; (this.t > 0) && (i1 > this.t); i1 = paramEditable.length())
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.t - i1));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$PreUploadTask = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null)
    {
      QQToast.a(this, 2131560722, 1).b(d());
      h();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
      for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
      {
        TroopBarUtils.a("pub_page", "fail", str1, "8", "", "");
        return;
      }
    }
    String str2 = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    int i1 = str2.length();
    if (i1 == 0)
    {
      QQToast.a(this, 2131560723, 0).b(d());
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
      for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
      {
        TroopBarUtils.a("pub_page", "fail", str1, "0", "", "");
        return;
      }
    }
    if (i1 < this.q)
    {
      QQToast.a(this, getString(2131560725, new Object[] { Integer.valueOf(this.q) }), 0).b(d());
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
      for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
      {
        TroopBarUtils.a("pub_page", "fail", str1, "0", "", "");
        return;
      }
    }
    if (i1 > this.r)
    {
      QQToast.a(this, getString(2131560726, new Object[] { Integer.valueOf(this.r) }), 0).b(d());
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
      for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
      {
        TroopBarUtils.a("pub_page", "fail", str1, "1", "", "");
        return;
      }
    }
    String str1 = TroopBarUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
    if ((!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      i1 = str1.length();
      if (i1 == 0)
      {
        QQToast.a(this, 2131560724, 0).b(d());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
        for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
        {
          TroopBarUtils.a("pub_page", "fail", str1, "2", "", "");
          return;
        }
      }
      if (i1 < this.s)
      {
        QQToast.a(this, getString(2131560727, new Object[] { Integer.valueOf(this.s) }), 0).b(d());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
        for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
        {
          TroopBarUtils.a("pub_page", "fail", str1, "2", "", "");
          return;
        }
      }
      if (i1 > this.t)
      {
        QQToast.a(this, getString(2131560728, new Object[] { Integer.valueOf(this.t) }), 0).b(d());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
        for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
        {
          TroopBarUtils.a("pub_page", "fail", str1, "4", "", "");
          return;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.e == 1) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())))
    {
      QQToast.a(this, 2131560739, 0).b(d());
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
      for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
      {
        TroopBarUtils.a("pub_page", "fail", str1, "9", "", "");
        return;
      }
    }
    if (!HttpUtil.a(this))
    {
      QQToast.a(this, 2131562450, 0).b(d());
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
      for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
      {
        TroopBarUtils.a("pub_page", "fail", str1, "7", "", "");
        return;
      }
    }
    b(true);
    this.jdField_m_of_type_AndroidWidgetTextView.setEnabled(false);
    i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((TroopBarPostContentEntity.Pic_list)TroopBarUtils.jdField_a_of_type_JavaUtilHashtable.get(localObject) == null)
      {
        a(this.jdField_a_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
        for (str1 = "0";; str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
        {
          TroopBarUtils.a("pub_page", "fail", str1, "10", "", "");
          return;
        }
      }
      i1 += 1;
    }
    String str3 = a(str1, this.jdField_a_of_type_JavaUtilArrayList);
    Object localObject = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null)
    {
      str1 = "0";
      ((Bundle)localObject).putString("bid", str1);
      ((Bundle)localObject).putString("post", str3);
      ((Bundle)localObject).putString("title", str2);
      ((Bundle)localObject).putString("type", "0");
      if (!this.jdField_a_of_type_Boolean) {
        break label1041;
      }
      str1 = "1";
      label913:
      ((Bundle)localObject).putString("sync_weibo", str1);
      if (!this.jdField_b_of_type_Boolean) {
        break label1047;
      }
      str1 = "1";
      label930:
      ((Bundle)localObject).putString("sync_qzone", str1);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI != null)
      {
        ((Bundle)localObject).putString("uid", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.jdField_h_of_type_JavaLangString);
        ((Bundle)localObject).putString("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.jdField_b_of_type_Int));
        ((Bundle)localObject).putString("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.jdField_a_of_type_Int));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity == null) {
        break label1053;
      }
    }
    label1041:
    label1047:
    label1053:
    for (str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity.type);; str1 = "")
    {
      ((Bundle)localObject).putString("type", str1);
      TroopBarUtils.b(this, (Bundle)localObject, "http://xiaoqu.qq.com/cgi-bin/bar/post/publish_v2", 4, null, this);
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s;
      break;
      str1 = "0";
      break label913;
      str1 = "0";
      break label930;
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.jdField_l_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837854);
        this.jdField_l_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    while ((this.jdField_l_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      return;
    }
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_l_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0))
    {
      a(false);
      return true;
    }
    return super.b();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean c()
  {
    Object localObject = getIntent().getExtras().getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "publish option: " + (String)localObject);
    }
    JSONObject localJSONObject;
    long l1;
    try
    {
      localObject = new JSONObject((String)localObject);
      if (localObject == null)
      {
        QQToast.a(this, 1, getString(2131560704, new Object[] { Integer.valueOf(999) }), 0).b(d());
        return false;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONObject = null;
      }
      l1 = localJSONObject.optLong("bid", 0L);
      str = localJSONObject.optString("barName");
      if (l1 > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar = new TroopBarUtils.MyBar(l1, str);
      }
      this.jdField_l_of_type_JavaLangString = ("bid:" + l1);
      this.jdField_k_of_type_JavaLangString = localJSONObject.optString("from");
      if (!"barindex".equals(this.jdField_k_of_type_JavaLangString)) {}
    }
    for (String str = "0";; str = "1")
    {
      this.n = str;
      f();
      a(localJSONObject);
      TroopBarUtils.a("pub_page", "exp", String.valueOf(l1), this.n, "", "");
      return true;
    }
  }
  
  public void d() {}
  
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
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.jdField_k_of_type_JavaLangString;
        a(1, new String[] { paramIntent });
        label162:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar != null) {
          break label215;
        }
      }
    }
    label215:
    for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
    {
      TroopBarUtils.a("pub_page", "choose_place", paramIntent, "2", "", "");
      return;
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.j;
      break;
      a(0, new String[0]);
      break label162;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar = ((TroopBarUtils.MyBar)paramIntent.getParcelableExtra("key_selected_item"));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar != null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.q);
      this.jdField_l_of_type_JavaLangString = ("bid:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s);
      paramIntent = getString(2131558492, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.q });
      this.jdField_e_of_type_AndroidViewView.setContentDescription(paramIntent);
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
      paramIntent = new Bundle();
      paramIntent.putString("bid", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s);
      TroopBarUtils.b(this, paramIntent, "http://xiaoqu.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(null);
    paramIntent = getString(2131558491);
    this.jdField_e_of_type_AndroidViewView.setContentDescription(paramIntent);
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
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
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("key_photo_delete_action"));
    com.tencent.biz.common.util.ImageUtil.b((String)null, 0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if (!this.jdField_h_of_type_Boolean) {
      i();
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
    }
    if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
      this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
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
    setContentView(2130903407);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "TroopBarPublishActivity initUI --------------");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExtendInputMethodRelativeLayout = ((ExtendInputMethodRelativeLayout)findViewById(2131232487));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131232502);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232504));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131232509));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131232469));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232513);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232514));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232515));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232516));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232520));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131232519);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232522));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131232521);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131232506));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131232507));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232510));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232517));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131232511);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView = ((ExtendGridView)findViewById(2131232512));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter = new TroopBarImagePreviewAdapter(this, this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter);
    a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new gwp(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExtendInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if ((android.text.TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) || (this.q <= 0) || (this.r <= 0))
    {
      this.q = 4;
      this.r = 25;
      this.jdField_g_of_type_JavaLangString = getString(2131560716, new Object[] { Integer.valueOf(this.q), Integer.valueOf(this.r) });
    }
    if ((android.text.TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) || (this.s <= 0) || (this.t <= 0))
    {
      this.s = 20;
      this.t = 700;
      this.jdField_i_of_type_JavaLangString = getString(2131560717, new Object[] { Integer.valueOf(this.s), Integer.valueOf(this.t) });
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_g_of_type_JavaLangString);
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (!android.text.TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      localObject = this.jdField_h_of_type_JavaLangString;
      localEditText.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(this.jdField_i_of_type_JavaLangString);
      localEditText = this.jdField_b_of_type_AndroidWidgetEditText;
      if (android.text.TextUtils.isEmpty(this.j)) {
        break label922;
      }
      localObject = this.j;
      label674:
      localEditText.setText((CharSequence)localObject);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {
        break label927;
      }
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      label711:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI != null)
      {
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.j)) {
          break label938;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.jdField_k_of_type_JavaLangString;
        label739:
        a(1, new String[] { localObject });
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setSelected(this.jdField_b_of_type_Boolean);
      this.jdField_d_of_type_AndroidWidgetImageView.setSelected(this.jdField_a_of_type_Boolean);
      setTitle(2131560719);
      h(2131561746);
      c(2131560720, this);
      this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(getString(2131558479));
      this.jdField_m_of_type_AndroidWidgetTextView.setContentDescription(getString(2131558480));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("bid", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s);
        TroopBarUtils.b(this, (Bundle)localObject, "http://xiaoqu.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
      }
      f();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar != null) {
        break label949;
      }
    }
    label922:
    label927:
    label938:
    label949:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
    {
      TroopBarUtils.a("pub_page", "choose_place", (String)localObject, "0", "", "");
      j();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExtendInputMethodRelativeLayout.setOnDownListener(new gwr(this));
      return;
      localObject = null;
      break;
      localObject = null;
      break label674;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      break label711;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI.j;
      break label739;
    }
  }
  
  protected void f()
  {
    if (SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$LocListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$LocListener = new TroopBarPublishActivity.LocListener(this, 1, 1, 4, 1);
      }
      SOSOMapLBSApi.getInstance().requestLocationUpdate(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity$LocListener);
    }
    a(2, new String[0]);
  }
  
  protected boolean f()
  {
    TroopBarUtils.PublishDataEntity localPublishDataEntity = (TroopBarUtils.PublishDataEntity)TroopBarUtils.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_l_of_type_JavaLangString);
    TroopBarUtils.jdField_a_of_type_JavaUtilHashMap.clear();
    if (localPublishDataEntity == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList = localPublishDataEntity.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI = localPublishDataEntity.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI;
    this.jdField_b_of_type_JavaUtilArrayList = localPublishDataEntity.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_b_of_type_Boolean = localPublishDataEntity.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Boolean = localPublishDataEntity.jdField_a_of_type_Boolean;
    this.q = localPublishDataEntity.jdField_a_of_type_Int;
    this.r = localPublishDataEntity.jdField_b_of_type_Int;
    this.jdField_g_of_type_JavaLangString = localPublishDataEntity.jdField_a_of_type_JavaLangString;
    this.s = localPublishDataEntity.jdField_c_of_type_Int;
    this.t = localPublishDataEntity.jdField_d_of_type_Int;
    this.jdField_i_of_type_JavaLangString = localPublishDataEntity.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaUtilArrayList = localPublishDataEntity.jdField_c_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = localPublishDataEntity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity;
    this.jdField_h_of_type_JavaLangString = localPublishDataEntity.jdField_c_of_type_JavaLangString;
    this.j = localPublishDataEntity.jdField_d_of_type_JavaLangString;
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968590);
    String str1;
    if (((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.length() > 0)) || ((this.jdField_b_of_type_AndroidWidgetEditText != null) && (this.jdField_b_of_type_AndroidWidgetEditText.length() > 0)) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)))
    {
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar != null) {
        break label100;
      }
    }
    label100:
    for (String str2 = "0";; str2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
    {
      TroopBarUtils.a("pub_page", "un", str2, str1, "", "");
      return;
      str1 = "1";
      break;
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
    localActionSheet.a(new gwu(this, localActionSheet));
    localActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
  }
  
  protected void h()
  {
    Intent localIntent = new Intent(this, TroopBarPublishBarSelectActivity.class);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar != null) {
      localIntent.putExtra("key_selected_item", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar);
    }
    startActivityForResult(localIntent, 1003);
  }
  
  protected void i()
  {
    int i2 = 0;
    TroopBarUtils.PublishDataEntity localPublishDataEntity = new TroopBarUtils.PublishDataEntity();
    int i1;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = new ArrayList();
      i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((ArrayList)localObject).add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
        i1 += 1;
      }
      localPublishDataEntity.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI != null)
    {
      localPublishDataEntity.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI = new TroopBarUtils.MyLBSApiPOI(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI);
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localObject = new ArrayList();
        i1 = 0;
        while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          ((ArrayList)localObject).add(new TroopBarUtils.MyLBSApiPOI((TroopBarUtils.MyLBSApiPOI)this.jdField_b_of_type_JavaUtilArrayList.get(i1)));
          i1 += 1;
        }
        localPublishDataEntity.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      }
    }
    localPublishDataEntity.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    localPublishDataEntity.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localPublishDataEntity.jdField_a_of_type_Int = this.q;
    localPublishDataEntity.jdField_b_of_type_Int = this.r;
    localPublishDataEntity.jdField_a_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    localPublishDataEntity.jdField_c_of_type_Int = this.s;
    localPublishDataEntity.jdField_d_of_type_Int = this.t;
    localPublishDataEntity.jdField_b_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
    if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      localObject = new ArrayList();
      i1 = i2;
      while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        ((ArrayList)localObject).add(new TroopBarPageEntity.TypeListEntity((TroopBarPageEntity.TypeListEntity)this.jdField_c_of_type_JavaUtilArrayList.get(i1)));
        i1 += 1;
      }
      localPublishDataEntity.jdField_c_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    }
    localPublishDataEntity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity;
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {}
    for (Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();; localObject = null)
    {
      localPublishDataEntity.jdField_c_of_type_JavaLangString = ((String)localObject);
      localPublishDataEntity.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_AndroidWidgetEditText.getEditableText().toString();
      TroopBarUtils.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_l_of_type_JavaLangString, localPublishDataEntity);
      return;
    }
  }
  
  protected void j()
  {
    int i3 = 8;
    int i2 = 0;
    Object localObject;
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_JavaUtilArrayList != null))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity.name);
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131558494, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity.name }));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_g_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(this.jdField_i_of_type_JavaLangString);
      localObject = this.jdField_d_of_type_AndroidViewView;
      if (!this.jdField_c_of_type_Boolean) {
        break label184;
      }
      i1 = 0;
      label121:
      ((View)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidViewView;
      i1 = i3;
      if (this.jdField_d_of_type_Boolean) {
        i1 = 0;
      }
      ((View)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (!this.f) {
        break label190;
      }
    }
    label184:
    label190:
    for (int i1 = i2;; i1 = 4)
    {
      ((ImageButton)localObject).setVisibility(i1);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      i1 = 8;
      break label121;
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramView.getId())
    {
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0))
    {
      a(false);
      label153:
      label196:
      label359:
      do
      {
        return;
        h();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null)
        {
          paramView = "0";
          if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {
            break label196;
          }
        }
        for (String str = "0";; str = "1")
        {
          TroopBarUtils.a("pub_page", "choose_tribe", paramView, str, "", "");
          break;
          paramView = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s;
          break label153;
        }
        paramView = new Intent(this, TroopBarPublishLocationSelectActivity.class);
        paramView.putParcelableArrayListExtra("current_location_list", this.jdField_b_of_type_JavaUtilArrayList);
        paramView.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI);
        startActivityForResult(paramView, 1002);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null)
        {
          paramView = "0";
          if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI == null) {
            break label300;
          }
        }
        for (str = "0";; str = "1")
        {
          TroopBarUtils.a("pub_page", "Clk_place", paramView, str, "", "");
          break;
          paramView = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s;
          break label257;
        }
        if (!this.jdField_b_of_type_Boolean) {}
        for (;;)
        {
          this.jdField_b_of_type_Boolean = bool1;
          this.jdField_c_of_type_AndroidWidgetImageView.setSelected(this.jdField_b_of_type_Boolean);
          if (!this.jdField_b_of_type_Boolean) {
            break label359;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131558485));
          break;
          bool1 = false;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131558486));
        break;
        if (!this.jdField_a_of_type_Boolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          this.jdField_a_of_type_Boolean = bool1;
          this.jdField_d_of_type_AndroidWidgetImageView.setSelected(this.jdField_a_of_type_Boolean);
          if (!this.jdField_a_of_type_Boolean) {
            break label430;
          }
          this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(getString(2131558487));
          break;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(getString(2131558488));
        break;
        b();
        break;
      } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null);
      label257:
      label300:
      label430:
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130839367);
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131558489));
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gws(this), 200L);
        return;
      }
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gwt(this), 200L);
      return;
      k();
    }
    InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130839367);
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131558489));
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(paramInt))
    {
      g();
      return;
    }
    AlbumUtil.a();
    paramAdapterView = new Intent(this, ImagePreviewActivity.class);
    paramAdapterView.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", TroopBarPublishActivity.class.getName());
    paramAdapterView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
    paramAdapterView.putExtra("selected_photo_index", paramInt);
    paramAdapterView.putExtra("back_btn_text", getString(2131560719));
    paramAdapterView.addFlags(603979776);
    startActivity(paramAdapterView);
    AlbumUtil.a(this, true, true);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar == null) {}
    for (paramAdapterView = "0";; paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar.s)
    {
      TroopBarUtils.a("pub_page", "choose_photo", paramAdapterView, "", "", "");
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(true);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public void u_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity
 * JD-Core Version:    0.7.0.1
 */