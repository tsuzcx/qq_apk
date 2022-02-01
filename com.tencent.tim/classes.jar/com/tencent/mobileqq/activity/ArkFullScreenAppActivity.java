package com.tencent.mobileqq.activity;

import acfp;
import adqr;
import adqu;
import adrl;
import adrr;
import adta;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqjn.a;
import ausj;
import auss;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.ark.ArkTopGestureLayout;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import ufm;
import ufn;
import ufo;
import ufp;
import ufq;
import ufr;
import wyw;
import wyw.b;

public class ArkFullScreenAppActivity
  extends IphoneTitleBarActivity
{
  private static ArrayList<Bundle> oL = new ArrayList();
  private aqjn.a jdField_a_of_type_Aqjn$a;
  protected ArkTopGestureLayout a;
  private wyw.b jdField_a_of_type_Wyw$b = new ufm(this);
  private boolean aRo;
  private int bDU;
  ArkAppView c;
  private Stack<aqjn.a> f = new Stack();
  private int mCardHeight;
  private ImageView mCloseBtn;
  private int mScreenWidth;
  private int mSourceType = 0;
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramFloat, ArkAppCacheMgr.getApplicationFromManifest(paramString2, "0.0.0.1"));
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, Map<String, String> paramMap)
  {
    Object localObject1 = "0.0.0.1";
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        if (paramMap == null) {
          break label308;
        }
        if (!paramMap.containsKey("desc")) {
          break label294;
        }
        localObject1 = (String)paramMap.get("desc");
        if (!paramMap.containsKey("version")) {
          break label301;
        }
        localObject2 = (String)paramMap.get("version");
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArkFullScreenAppActivity", 1, "buildForwardIntent send message parameter error: " + paramContext.getMessage());
        return null;
      }
      Object localObject3 = String.format(acfp.m(2131702816), new Object[] { localObject2 });
      paramMap = e(paramString4, paramMap);
      paramString4 = aqjn.a.a(paramString2, paramString1, (String)localObject1, paramString3, paramFloat, null, null);
      paramString4.putBoolean("forward_ark_app_direct", false);
      paramString4.putString("forward_ark_app_name", paramString2);
      paramString4.putString("forward_ark_app_view", paramString1);
      paramString4.putString("forward_ark_app_desc", (String)localObject2);
      paramString4.putString("forward_ark_app_ver", (String)localObject1);
      paramString4.putString("forward_ark_app_meta", paramString3);
      paramString4.putString("forward_ark_app_prompt", (String)localObject3);
      paramString4.putString("forward_ark_app_config", paramMap);
      paramString1 = new Intent();
      paramString1.setClass(paramContext, ForwardRecentActivity.class);
      paramString1.putExtra("forward_type", 27);
      paramString1.putExtra("is_ark_display_share", true);
      paramString1.putExtras(paramString4);
      if (QLog.isColorLevel())
      {
        QLog.i("ArkFullScreenAppActivity", 2, "buildForwardIntent: " + paramString4);
        return paramString1;
        label294:
        localObject1 = "";
        continue;
        label301:
        localObject2 = "0.0.0.1";
        break label317;
        label308:
        localObject2 = "";
        continue;
      }
      else
      {
        return paramString1;
      }
      label317:
      localObject3 = localObject1;
      localObject1 = localObject2;
      Object localObject2 = localObject3;
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat)
  {
    adta.GI(true);
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramFloat, ArkAppCacheMgr.getApplicationFromManifest(paramString2, "0.0.0.1"));
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat, Map<String, String> paramMap)
  {
    Object localObject = "0.0.0.1";
    label301:
    label308:
    label315:
    label332:
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        if (paramMap == null) {
          break label315;
        }
        if (!paramMap.containsKey("desc")) {
          break label301;
        }
        localObject = (String)paramMap.get("desc");
        if (!paramMap.containsKey("version")) {
          break label308;
        }
        paramMap = (String)paramMap.get("version");
      }
      catch (Exception paramContext)
      {
        String str2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArkFullScreenAppActivity", 1, "buildForwardIntent send message parameter error: " + paramContext.getMessage());
        return null;
      }
      String str1 = String.format(acfp.m(2131702818), new Object[] { localObject });
      str2 = ha(paramString4);
      paramString4 = aqjn.a.a(paramString2, paramString1, paramMap, paramString3, paramFloat, null, null);
      paramString4.putBoolean("forward_ark_app_direct", false);
      paramString4.putString("forward_ark_app_name", paramString2);
      paramString4.putString("forward_ark_app_view", paramString1);
      paramString4.putString("forward_ark_app_desc", (String)localObject);
      paramString4.putString("forward_ark_app_ver", paramMap);
      paramString4.putString("forward_ark_app_meta", paramString3);
      paramString4.putString("forward_ark_app_prompt", str1);
      paramString4.putString("forward_ark_app_config", str2);
      paramString4.putBoolean("forward_ark_from_sdk", true);
      paramString4.putString("forward_appId_ark_from_sdk", paramString5);
      paramString1 = new Intent();
      paramString1.setClass(paramContext, ForwardRecentActivity.class);
      paramString1.putExtra("forward_type", 11);
      paramString1.putExtras(paramString4);
      if (QLog.isColorLevel())
      {
        QLog.i("ArkFullScreenAppActivity", 2, "buildForwardIntent: " + paramString4);
        return paramString1;
        localObject = "";
        continue;
        paramMap = "0.0.0.1";
        break label332;
        str1 = "";
        paramMap = (Map<String, String>)localObject;
        localObject = str1;
      }
      else
      {
        return paramString1;
      }
    }
  }
  
  private wyw a(aqjn.a parama)
  {
    wyw localwyw = new wyw();
    parama.e = localwyw;
    int i = this.c.getWidth();
    int j = this.c.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "create App: w=" + i + ",h=" + j);
    }
    localwyw.a(parama.appName, parama.appView, parama.appMinVersion, parama.metaData, adqr.getDensity(), parama.d);
    localwyw.setFixSize(i, j);
    localwyw.setMaxSize(i, j);
    localwyw.setMinSize(i, j);
    localwyw.a(this.jdField_a_of_type_Wyw$b);
    return localwyw;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, String paramString5, int paramInt)
  {
    paramString1 = aqjn.a.a(paramString1, paramString2, paramString3, paramString4, adqr.getDensity(), paramString5, null);
    paramString1.putInt("sourceType", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "startFullScreenApp:" + paramString1);
    }
    paramString2 = new Intent(paramContext, ArkFullScreenAppActivity.class);
    paramString2.putExtras(paramString1);
    paramContext.startActivity(paramString2);
  }
  
  public static void c(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    paramString1 = aqjn.a.a(paramString1, paramString2, "0.0.0.1", paramString3, adqr.getDensity(), null, null);
    paramString1.putInt("sourceType", 0);
    paramString2 = new Intent(paramActivity, ArkFullScreenAppActivity.class);
    paramString2.putExtras(paramString1);
    paramString2.putExtra("card_height", MessageForArkApp.dp2px(297.0F));
    paramString2.putExtra("show_as_card", true);
    paramActivity.startActivity(paramString2);
    paramActivity.overridePendingTransition(2130772009, 2130772013);
  }
  
  private void clear()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      wyw localwyw = ((aqjn.a)localIterator.next()).e;
      if (localwyw != null) {
        localwyw.doOnEvent(2);
      }
    }
    this.f.clear();
  }
  
  private static String e(String paramString, Map<String, String> paramMap)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("forward", 1);
        localJSONObject.put("autosize", 1);
        if ((paramMap != null) && ("normal".equals(paramMap.get("type"))))
        {
          localJSONObject.put("type", "normal");
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          paramString = new JSONObject(paramString);
          paramMap = paramString.keys();
          if (!paramMap.hasNext()) {
            break;
          }
          String str = (String)paramMap.next();
          localJSONObject.put(str, paramString.getString(str));
          continue;
        }
        localJSONObject.put("type", "card");
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return "";
      }
    }
    paramString = localJSONObject.toString();
    return paramString;
  }
  
  public static String ha(String paramString)
    throws JSONException
  {
    if (!TextUtils.isEmpty(paramString))
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localJSONObject.put("forward", 1);
      paramString = localJSONObject;
      if (!localJSONObject.has("type"))
      {
        localJSONObject.put("type", "card");
        paramString = localJSONObject;
      }
    }
    for (;;)
    {
      return paramString.toString();
      paramString = new JSONObject();
      paramString.put("forward", 1);
      paramString.put("autosize", 1);
      paramString.put("type", "card");
    }
  }
  
  private void init(Bundle paramBundle)
  {
    aqjn.a locala = new aqjn.a(paramBundle);
    this.mSourceType = paramBundle.getInt("sourceType", 0);
    paramBundle = a(locala);
    this.f.push(locala);
    this.jdField_a_of_type_Aqjn$a = locala;
    this.c.initArkView(paramBundle, false);
    if (locala != null)
    {
      setTitle(locala.title);
      if (1 == this.mSourceType) {
        adqu.a(this.app, locala.appName, "ArkFullEnterFromAppManage", 1, 0, 0L, 0L, 0L, null, null);
      }
    }
    if (this.f.size() > 1) {
      this.mCloseBtn.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 2, "init: " + locala.appName + ", " + this.f.size());
      }
      return;
      this.mCloseBtn.setVisibility(8);
    }
  }
  
  public static boolean t(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("forward_ark_app_name");
    String str2 = paramBundle.getString("forward_ark_app_view");
    String str3 = paramBundle.getString("forward_ark_app_ver");
    String str4 = paramBundle.getString("forward_ark_app_meta");
    paramBundle = paramBundle.getString("forward_ark_app_config");
    if (QLog.isColorLevel()) {
      QLog.e("ArkFullScreenAppActivity", 2, "richMsgBody displayArk appName =" + str1 + ", appView =" + str2 + ", appMeta =" + str4 + ", config =" + paramBundle + ", appVer" + str3);
    }
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4));
  }
  
  public void Qq()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(getString(2131720196), 0);
    localausj.a(new ufr(this, localausj));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  public Intent a(wyw paramwyw)
  {
    try
    {
      Object localObject1 = paramwyw.getViewShare();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      Document localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
      localObject1 = localDocument.getElementsByTagName("View").item(0);
      if ((localObject1 != null) && (((Node)localObject1).getChildNodes().getLength() > 0) && ((((Node)localObject1).getFirstChild() instanceof Text)))
      {
        String str = ((Node)localObject1).getFirstChild().getNodeValue();
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        Node localNode = localDocument.getElementsByTagName("Metadata").item(0);
        Object localObject2 = new JSONObject();
        localObject1 = localObject2;
        if (localNode != null)
        {
          localObject1 = localObject2;
          if (localNode.getChildNodes().getLength() > 0)
          {
            localObject1 = localObject2;
            if (!adrl.a(localNode.getFirstChild(), (JSONObject)localObject2)) {
              localObject1 = new JSONObject();
            }
          }
        }
        paramwyw = paramwyw.getAppName();
        localObject1 = ((JSONObject)localObject1).toString();
        float f1 = adqr.getDensity();
        localObject2 = MessageForArkApp.getConfigFromXml(localDocument);
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp", 2, "ArkFullScreenApp config getShareMsg:" + (String)localObject2);
        }
        paramwyw = a(this, str, paramwyw, (String)localObject1, (String)localObject2, f1);
        return paramwyw;
      }
    }
    catch (Exception paramwyw)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 1, "getShareMsg send message parameter error: " + paramwyw.getMessage());
      }
      return null;
    }
    return null;
  }
  
  public void a(wyw paramwyw, String paramString)
  {
    if ((this.jdField_a_of_type_Aqjn$a != null) && (this.jdField_a_of_type_Aqjn$a.e == paramwyw))
    {
      this.jdField_a_of_type_Aqjn$a.title = paramString;
      setTitle(paramString);
    }
    aqjn.a locala;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.f.iterator();
      }
      locala = (aqjn.a)localIterator.next();
    } while ((locala == null) || (locala.e != paramwyw));
    locala.title = paramString;
  }
  
  public void a(wyw paramwyw, boolean paramBoolean)
  {
    int j = 0;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      aqjn.a locala = (aqjn.a)localIterator.next();
      if ((locala != null) && (locala.e == paramwyw))
      {
        locala.cUs = paramBoolean;
        if (this.jdField_a_of_type_Aqjn$a == locala)
        {
          if ((!locala.e.checkShare()) || (!locala.cUs)) {
            break label102;
          }
          i = 1;
          paramwyw = this.rightViewImg;
          if (i == 0) {
            break label107;
          }
        }
      }
    }
    label102:
    label107:
    for (int i = j;; i = 4)
    {
      paramwyw.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 100) && (this.jdField_a_of_type_Aqjn$a != null))
    {
      adqu.b(this.app, "FullScreenClickOper", this.jdField_a_of_type_Aqjn$a.appName, null, adqu.cJm, 0, 0);
      adqu.a(this.app, this.jdField_a_of_type_Aqjn$a.appName, "FullScreenShareSuccess", 0, 0, 0L, 0L, 0L, "", "");
      if (1 == this.mSourceType) {
        adqu.a(this.app, this.jdField_a_of_type_Aqjn$a.appName, "ArkFullShareFromAppManage", 1, 0, 0L, 0L, 0L, null, null);
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    Object localObject = getWindowManager().getDefaultDisplay();
    if (localObject != null)
    {
      this.mScreenWidth = ((Display)localObject).getWidth();
      this.bDU = ((Display)localObject).getHeight();
    }
    setContentView(2131558748);
    localObject = (FrameLayout)findViewById(16908290);
    if (this.titleRoot != null) {
      this.titleRoot.setBackgroundColor(getResources().getColor(2131165570));
    }
    this.leftView.setText("");
    this.leftView.setMinWidth(MessageForArkApp.dp2px(35.0F));
    localObject = (RelativeLayout)findViewById(2131377361);
    this.mCloseBtn = new ImageView(this);
    this.mCloseBtn.setImageResource(2130840662);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(1, 2131369579);
    ((RelativeLayout)localObject).addView(this.mCloseBtn, localLayoutParams);
    this.mCloseBtn.setOnClickListener(new ufn(this));
    int i = MessageForArkApp.dp2px(6.0F);
    this.mCloseBtn.setPadding(i, 0, i, 0);
    this.rightViewImg = ((ImageView)findViewById(2131369594));
    this.rightViewImg.setBackgroundDrawable(null);
    setLayerType(this.rightViewImg);
    this.rightViewImg.setVisibility(4);
    this.rightViewImg.setImageResource(2130840664);
    this.rightViewImg.setContentDescription(acfp.m(2131702814));
    this.rightViewImg.setOnClickListener(new ufo(this));
    this.c = ((ArkAppView)findViewById(2131362969));
    this.c.setBorderType(0);
    this.c.setOnTouchListener(this.c);
    this.c.setCallback(new ufp(this));
    this.c.post(new ArkFullScreenAppActivity.5(this, paramBundle));
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "doOnCreate:" + paramBundle);
    }
    findViewById(2131377361);
    adqu.b(this.app, "ShowView", paramBundle.getString("appName"), null, adqu.cJp, 0, 0);
    adrr.a(this, this.c);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkTopGestureLayout = new ArkTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentMobileqqArkArkTopGestureLayout);
    }
    if (ThemeUtil.isInNightMode(this.app))
    {
      paramBundle = (RelativeLayout)findViewById(2131379881);
      LayoutInflater.from(this).inflate(2131560438, paramBundle);
    }
    this.aRo = getIntent().getBooleanExtra("show_as_card", false);
    this.mCardHeight = getIntent().getIntExtra("card_height", 0);
    if ((this.aRo) && (this.mCardHeight > 0))
    {
      findViewById(2131377361).setVisibility(8);
      paramBundle = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      paramBundle.addRule(12);
      paramBundle.height = this.mCardHeight;
      this.titleRoot.setBackgroundResource(0);
      this.titleRoot.setOnClickListener(new ufq(this));
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    clear();
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("ArkFullScreenAppActivity", 2, "doOnDestroy: ");
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getExtras();
    init(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "doOnNewIntent" + paramIntent);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SystemBarCompact localSystemBarCompact;
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusBarDrawable(null);
      localSystemBarCompact = this.mSystemBarComp;
      if (!this.aRo) {
        break label39;
      }
    }
    label39:
    for (int i = 0;; i = -16777216)
    {
      localSystemBarCompact.setStatusBarColor(i);
      return;
    }
  }
  
  public void finish()
  {
    clear();
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Aqjn$a != null) {
      adqu.b(this.app, "FullScreenClickOper", this.jdField_a_of_type_Aqjn$a.appName, null, adqu.cJi, 0, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkFullScreenAppActivity", 2, "onBackEvent: " + this.f.size());
    }
    if (this.f.size() <= 1)
    {
      this.mCloseBtn.setVisibility(8);
      if (this.aRo)
      {
        finish();
        overridePendingTransition(2130772009, 2130772013);
        return true;
      }
      return super.onBackEvent();
    }
    wyw localwyw = ((aqjn.a)this.f.pop()).e;
    if (localwyw != null) {
      localwyw.doOnEvent(2);
    }
    this.jdField_a_of_type_Aqjn$a = ((aqjn.a)this.f.peek());
    if (this.jdField_a_of_type_Aqjn$a != null)
    {
      this.c.initArkView(this.jdField_a_of_type_Aqjn$a.e);
      setTitle(this.jdField_a_of_type_Aqjn$a.title);
    }
    if (this.f.size() > 1) {
      this.mCloseBtn.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.mCloseBtn.setVisibility(8);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getWindowManager().getDefaultDisplay();
    if (paramConfiguration == null)
    {
      QLog.d("ArkFullScreenAppActivity", 2, "onConfigurationChanged:get display null");
      return;
    }
    int i = paramConfiguration.getWidth();
    int j = paramConfiguration.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, new Object[] { "onConfigurationChanged:width=", Integer.valueOf(i), ", height=", Integer.valueOf(j), ", mScreenWidth=", Integer.valueOf(this.mScreenWidth), ", mScreenheight=", Integer.valueOf(this.bDU) });
    }
    if ((this.mScreenWidth != 0) && (this.bDU != 0) && ((this.mScreenWidth != i) || (this.bDU != j)))
    {
      this.c.setFixSize(i, j);
      this.c.setMinSize(i, j);
      this.c.setMaxSize(i, j);
      this.c.setViewRect(i, j);
    }
    this.mScreenWidth = i;
    this.bDU = j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity
 * JD-Core Version:    0.7.0.1
 */