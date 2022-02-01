package com.tencent.mobileqq.activity;

import accn;
import acff;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqhq;
import aqju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.profile.ProfileLabelInfo;>;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vmp;
import vmq;
import vmr;
import vms;
import vmt;
import vmu;

public class ProfileLabelEditorActivity
  extends IphoneTitleBarActivity
{
  public TextView ED;
  public b a;
  public ProfileLabelPanel.a a;
  public ProfileLabelPanel a;
  public boolean aZm;
  private accn cardObserver = new vmp(this);
  public Context context;
  public Card d;
  public float density;
  public LinearLayout gh;
  public GridView i;
  public List<ProfileLabelInfo> qV = new ArrayList();
  public List<Long> qW = new ArrayList();
  public List<ProfileLabelTypeInfo> typeList = new ArrayList();
  
  private boolean Qo()
  {
    return (this.typeList != null) && (this.typeList.size() > 0);
  }
  
  private List<ProfileLabelInfo> Z(String paramString)
  {
    this.d = ((acff)this.app.getManager(51)).b(paramString);
    if (this.d != null)
    {
      this.qV = this.d.getLabelList();
      if (this.qV != null) {
        fT(this.qV);
      }
    }
    return this.qV;
  }
  
  private void bSE()
  {
    if (Qp())
    {
      if (this.aZm)
      {
        showToast(2131720754);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileLabelEditorActivity", 2, "saveEdit save labes num = " + this.qV.size());
      }
      this.aZm = true;
      ((CardHandler)this.app.getBusinessHandler(2)).iC(this.qV);
      return;
    }
    finish();
  }
  
  private void bSF()
  {
    ThreadManager.post(new ProfileLabelEditorActivity.3(this), 8, null, true);
  }
  
  private void bSG()
  {
    try
    {
      vU(hi("qvip_default_tags.json"));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void fT(List<ProfileLabelInfo> paramList)
  {
    this.qW.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)paramList.next();
      this.qW.add(localProfileLabelInfo.labelId);
    }
  }
  
  private void fU(List<ProfileLabelInfo> paramList)
  {
    if (this.qV != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity$b = new b(this.qV);
      this.i.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity$b);
      Bn(this.qV.size());
    }
    Object localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "labelList");
    if ((localObject == null) || (!((File)localObject).exists())) {
      bSG();
    }
    for (;;)
    {
      return;
      localObject = new ByteArrayInputStream(aqhq.fileToBytes((File)localObject));
      try
      {
        ObjectInputStream localObjectInputStream = new ObjectInputStream((InputStream)localObject);
        this.typeList = ((List)localObjectInputStream.readObject());
        localObjectInputStream.close();
        ((ByteArrayInputStream)localObject).close();
        if (!Qo())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileLabelEditorActivity", 2, "get available label list fail ");
          }
          bSG();
        }
        if (!Qo()) {
          continue;
        }
        w(paramList, this.typeList);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
        }
      }
    }
  }
  
  private void fV(List<ProfileLabelTypeInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel = new ProfileLabelPanel(this.context, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$a, paramList, new vmr(this));
    paramList = new LinearLayout.LayoutParams(-1, (int)(202.0F * this.density));
    this.gh.addView(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel, paramList);
  }
  
  /* Error */
  private String hi(String paramString)
  {
    // Byte code:
    //   0: new 317	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 318	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 288	com/tencent/mobileqq/activity/ProfileLabelEditorActivity:context	Landroid/content/Context;
    //   13: invokevirtual 324	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   16: aload_1
    //   17: invokevirtual 330	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   20: astore_3
    //   21: aload_3
    //   22: astore_1
    //   23: sipush 4096
    //   26: newarray byte
    //   28: astore 4
    //   30: aload_3
    //   31: astore_1
    //   32: aload_3
    //   33: aload 4
    //   35: iconst_0
    //   36: sipush 4096
    //   39: invokevirtual 336	java/io/InputStream:read	([BII)I
    //   42: istore_2
    //   43: iload_2
    //   44: iconst_m1
    //   45: if_icmpeq +47 -> 92
    //   48: aload_3
    //   49: astore_1
    //   50: aload 5
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 340	java/io/ByteArrayOutputStream:write	([BII)V
    //   59: goto -29 -> 30
    //   62: astore 4
    //   64: aload_3
    //   65: astore_1
    //   66: ldc 122
    //   68: iconst_1
    //   69: ldc_w 342
    //   72: aload 4
    //   74: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 347	java/io/InputStream:close	()V
    //   85: aload 5
    //   87: invokevirtual 348	java/io/ByteArrayOutputStream:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: aload_3
    //   93: astore_1
    //   94: new 350	java/lang/String
    //   97: dup
    //   98: aload 5
    //   100: invokevirtual 354	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   103: ldc_w 356
    //   106: invokespecial 359	java/lang/String:<init>	([BLjava/lang/String;)V
    //   109: astore 4
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 347	java/io/InputStream:close	()V
    //   119: aload 5
    //   121: invokevirtual 348	java/io/ByteArrayOutputStream:close	()V
    //   124: aload 4
    //   126: areturn
    //   127: astore_1
    //   128: ldc 122
    //   130: iconst_1
    //   131: ldc_w 342
    //   134: aload_1
    //   135: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   138: aload 4
    //   140: areturn
    //   141: astore_1
    //   142: ldc 122
    //   144: iconst_1
    //   145: ldc_w 342
    //   148: aload_1
    //   149: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: goto -62 -> 90
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 347	java/io/InputStream:close	()V
    //   166: aload 5
    //   168: invokevirtual 348	java/io/ByteArrayOutputStream:close	()V
    //   171: aload_3
    //   172: athrow
    //   173: astore_1
    //   174: ldc 122
    //   176: iconst_1
    //   177: ldc_w 342
    //   180: aload_1
    //   181: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -13 -> 171
    //   187: astore_3
    //   188: goto -30 -> 158
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_3
    //   195: goto -131 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	ProfileLabelEditorActivity
    //   0	198	1	paramString	String
    //   42	14	2	j	int
    //   20	96	3	localInputStream	InputStream
    //   155	17	3	localObject1	Object
    //   187	1	3	localObject2	Object
    //   194	1	3	localObject3	Object
    //   28	25	4	arrayOfByte	byte[]
    //   62	11	4	localIOException1	IOException
    //   109	30	4	str	String
    //   191	1	4	localIOException2	IOException
    //   7	160	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   23	30	62	java/io/IOException
    //   32	43	62	java/io/IOException
    //   50	59	62	java/io/IOException
    //   94	111	62	java/io/IOException
    //   115	119	127	java/lang/Exception
    //   119	124	127	java/lang/Exception
    //   81	85	141	java/lang/Exception
    //   85	90	141	java/lang/Exception
    //   9	21	155	finally
    //   162	166	173	java/lang/Exception
    //   166	171	173	java/lang/Exception
    //   23	30	187	finally
    //   32	43	187	finally
    //   50	59	187	finally
    //   66	77	187	finally
    //   94	111	187	finally
    //   9	21	191	java/io/IOException
  }
  
  private void vU(String paramString)
    throws JSONException
  {
    if (paramString != null)
    {
      paramString = new JSONArray(paramString);
      int m = paramString.length();
      int j = 0;
      while (j < m)
      {
        Object localObject = paramString.optJSONObject(j);
        ProfileLabelTypeInfo localProfileLabelTypeInfo = new ProfileLabelTypeInfo();
        localProfileLabelTypeInfo.typeId = ((JSONObject)localObject).optString("id");
        localProfileLabelTypeInfo.typeName = ((JSONObject)localObject).optString("name");
        localProfileLabelTypeInfo.typeInfo = ((JSONObject)localObject).optString("classinfo");
        localObject = ((JSONObject)localObject).optJSONArray("taglist");
        int n = ((JSONArray)localObject).length();
        int k = 0;
        while (k < n)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(k);
          ProfileLabelInfo localProfileLabelInfo = new ProfileLabelInfo();
          localProfileLabelInfo.labelId = Long.valueOf(localJSONObject.optLong("id"));
          localProfileLabelInfo.labelName = localJSONObject.optString("name");
          localProfileLabelInfo.typeId = localProfileLabelTypeInfo.typeId;
          localProfileLabelTypeInfo.labels.add(localProfileLabelInfo);
          k += 1;
        }
        this.typeList.add(localProfileLabelTypeInfo);
        j += 1;
      }
    }
  }
  
  private void w(List<ProfileLabelInfo> paramList, List<ProfileLabelTypeInfo> paramList1)
  {
    Iterator localIterator1 = paramList1.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ProfileLabelTypeInfo)localIterator1.next()).labels.iterator();
      while (localIterator2.hasNext())
      {
        ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)localIterator2.next();
        localProfileLabelInfo.labelStatus = ProfileLabelInfo.STATUS_NORMAL;
        if (a(localProfileLabelInfo.labelId, paramList)) {
          localProfileLabelInfo.labelStatus = ProfileLabelInfo.STATUS_CHECKED;
        }
      }
    }
    fV(paramList1);
  }
  
  public void Bn(int paramInt)
  {
    if (paramInt > 7) {
      return;
    }
    this.ED.setText(getString(2131720747) + " (" + paramInt + "/" + 7 + ")");
  }
  
  boolean Qp()
  {
    if ((this.qV != null) && (this.qW != null) && (this.qV.size() == this.qW.size()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.qV.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((ProfileLabelInfo)localIterator.next()).labelId);
      }
      if ((localArrayList.containsAll(this.qW)) && (this.qW.containsAll(localArrayList))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean W(List<ProfileLabelInfo> paramList)
  {
    return paramList.size() >= 7;
  }
  
  ProfileLabelInfo a(Long paramLong, List<ProfileLabelInfo> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = localObject2;
      localObject1 = paramList;
      if (localIterator.hasNext())
      {
        localObject1 = (ProfileLabelInfo)localIterator.next();
        if (!((ProfileLabelInfo)localObject1).labelId.equals(paramLong)) {
          break label61;
        }
        paramList = (List<ProfileLabelInfo>)localObject1;
      }
    }
    label61:
    for (;;)
    {
      break;
      return localObject1;
    }
  }
  
  public void a(ProfileLabelInfo paramProfileLabelInfo, List<ProfileLabelInfo> paramList)
  {
    if (paramList != null)
    {
      int j = 0;
      while (j < paramList.size())
      {
        if (((ProfileLabelInfo)paramList.get(j)).labelId.equals(paramProfileLabelInfo.labelId))
        {
          paramList.remove(j);
          anot.a(this.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
        }
        j += 1;
      }
    }
  }
  
  public boolean a(Long paramLong, List<ProfileLabelInfo> paramList)
  {
    return a(paramLong, paramList) != null;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.cardObserver);
    this.context = this;
    this.density = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$a = new ProfileLabelPanel.a();
    getResources();
    initUI();
    bSF();
    anot.a(this.app, "CliOper", "", "", "card_mall", "0X80066C8", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.cardObserver);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$a.destroy();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$a = null;
  }
  
  public void initUI()
  {
    super.setContentView(2131559792);
    getWindow().setBackgroundDrawable(null);
    super.setTitle(getString(2131720749));
    this.gh = ((LinearLayout)findViewById(2131377546));
    this.ED = ((TextView)this.gh.findViewById(2131379184));
    this.i = ((GridView)this.gh.findViewById(2131379181));
    setRightButton(2131721083, new vmq(this));
    enableRightHighlight(true);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (Qp())
    {
      aqha.a(this, 230).setMessage(getString(2131720746)).setPositiveButton(2131721952, new vmt(this)).setNegativeButton(2131696322, new vms(this)).show();
      return true;
    }
    finish();
    return false;
  }
  
  public void showToast(int paramInt)
  {
    QQToast.a(this.context, paramInt, 1).show(getResources().getDimensionPixelSize(2131299627));
  }
  
  public static class a
  {
    public int index;
    public TextView xy;
  }
  
  public class b
    extends BaseAdapter
  {
    private View.OnClickListener jdField_do = new vmu(this);
    List<ProfileLabelInfo> mList;
    
    public b()
    {
      Object localObject;
      this.mList = localObject;
    }
    
    private void a(ProfileLabelInfo paramProfileLabelInfo)
    {
      Object localObject = null;
      Iterator localIterator = ProfileLabelEditorActivity.this.a.ar().keySet().iterator();
      if (localIterator.hasNext())
      {
        ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)localIterator.next();
        if (!localProfileLabelInfo.labelId.equals(paramProfileLabelInfo.labelId)) {
          break label114;
        }
        localObject = localProfileLabelInfo;
      }
      label114:
      for (;;)
      {
        break;
        if ((localObject != null) && (ProfileLabelEditorActivity.this.a.a(localObject)))
        {
          ProfileLabelEditorActivity.this.a.c(localObject, ProfileLabelEditorActivity.this.a.a(localObject));
          return;
        }
        i(paramProfileLabelInfo.labelId);
        return;
      }
    }
    
    private void i(Long paramLong)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ProfileLabelEditorActivity.this.typeList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((ProfileLabelTypeInfo)localIterator.next()).labels);
      }
      paramLong = ProfileLabelEditorActivity.this.a(paramLong, localArrayList);
      if (paramLong != null) {
        paramLong.toggleStatus();
      }
    }
    
    public int getCount()
    {
      return this.mList.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = ProfileLabelEditorActivity.this.getLayoutInflater().inflate(2131563159, null);
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(32.0F * ProfileLabelEditorActivity.this.density)));
        paramView = new ProfileLabelEditorActivity.a();
        paramView.xy = ((TextView)localView.findViewById(2131379183));
        localView.setTag(paramView);
      }
      for (;;)
      {
        paramView.index = paramInt;
        int i = paramInt % ProfileActivity.p.length;
        localView.setBackgroundResource(ProfileActivity.p[i][0]);
        localView.setOnClickListener(this.jdField_do);
        i = ProfileActivity.p[i][1];
        paramView.xy.setTextColor(i);
        paramView.xy.setText(((ProfileLabelInfo)this.mList.get(paramInt)).labelName);
        paramView.xy.setContentDescription(((ProfileLabelInfo)this.mList.get(paramInt)).labelName);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        ProfileLabelEditorActivity.a locala = (ProfileLabelEditorActivity.a)paramView.getTag();
        localView = paramView;
        paramView = locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity
 * JD-Core Version:    0.7.0.1
 */