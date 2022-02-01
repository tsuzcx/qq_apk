package com.tencent.mobileqq.activity.weather;

import abcm;
import abcn;
import abco;
import abcp;
import abcq;
import abcr;
import abcu;
import abcv;
import abcw;
import acfp;
import acsf;
import acsh;
import acsn;
import aduk;
import afei;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqhq;
import aqhu;
import arhz;
import axol;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vnk;
import xuh;
import xuh.a;

public class SessionClearFragment
  extends PublicBaseFragment
  implements vnk
{
  private TextView Pc;
  private acsn jdField_a_of_type_Acsn;
  private arhz jdField_a_of_type_Arhz;
  private b jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$b;
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  private RelativeLayout bottomBar;
  private SparseArray<URLDrawable> by = new SparseArray();
  private aduk jdField_c_of_type_Aduk;
  private xuh jdField_c_of_type_Xuh;
  private int cnG = 0;
  private int cnH;
  private int cnI;
  private aduk d;
  private aduk e;
  private Bitmap eB;
  private Button fA;
  private Button fz;
  private LinearLayout jdField_if;
  private LinearLayoutManager layoutManager;
  private Activity mActivity;
  private View mRoot;
  private RecyclerView recyclerView;
  List<acsf> vL;
  
  private void GU(int paramInt)
  {
    if (paramInt == 1) {
      this.fz.setText(acfp.m(2131714324));
    }
    for (;;)
    {
      this.cnG = paramInt;
      return;
      this.fz.setText(acfp.m(2131714312));
    }
  }
  
  private void cBb()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$b.getItemCount())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$b.a(i).isCheck) {
        localArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$b.a(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$b.a(i));
      }
    }
    if (localArrayList1.size() > 0)
    {
      this.jdField_a_of_type_Acsn.aR(localArrayList1);
      if ((localArrayList2 != null) && (localArrayList2.size() != 0)) {
        break label147;
      }
      this.jdField_if.setVisibility(0);
    }
    for (;;)
    {
      QQToast.a(this.mActivity, 2, 2131692514, 0).show(getResources().getDimensionPixelSize(2131299627));
      return;
      label147:
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$b.bF(localArrayList2);
      this.Pc.setVisibility(8);
      GU(0);
    }
  }
  
  private void d(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.mActivity != null) && (!this.mActivity.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SessionClearFragment", 2, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  public static Drawable getCoverDrawable(String paramString, int paramInt1, int paramInt2)
  {
    afei localafei = new afei(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localafei, localafei);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SessionClearFragment", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localafei;
  }
  
  private void initUI(View paramView)
  {
    this.recyclerView = ((RecyclerView)paramView.findViewById(2131378077));
    this.fz = ((Button)paramView.findViewById(2131377930));
    this.cnG = 0;
    this.Pc = ((TextView)paramView.findViewById(2131378588));
    this.fA = ((Button)paramView.findViewById(2131365697));
    this.bottomBar = ((RelativeLayout)paramView.findViewById(2131363682));
    this.layoutManager = new LinearLayoutManager(getActivity());
    this.jdField_if = ((LinearLayout)paramView.findViewById(2131366395));
    this.recyclerView.setLayoutManager(this.layoutManager);
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$b = new b(new ArrayList());
    this.recyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$b);
    this.fz.setOnClickListener(new abcq(this));
    this.fA.setOnClickListener(new abcr(this));
    paramView.findViewById(2131364687).setOnClickListener(new abcu(this));
  }
  
  private void loadShortVideoCover(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.j(paramString);
      if (paramString != null)
      {
        paramString = getCoverDrawable(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.by.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
      }
    }
    else
    {
      return;
    }
    QLog.d("SessionClearFragment", 2, "url  is null ");
  }
  
  protected void dismissProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public void hP(List<acsf> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$b.bF(paramList);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onAttach");
    }
  }
  
  public void onBackPressed()
  {
    this.mActivity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRoot = this.mActivity.getWindow().getDecorView().findViewById(16908290);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = (LinearLayout.LayoutParams)this.mRoot.getLayoutParams();
      int i = ImmersiveUtils.getStatusBarHeight(getActivity());
      if (paramBundle != null) {
        paramBundle.setMargins(0, i, 0, 0);
      }
      this.mRoot.setSystemUiVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)axol.getAppInterface());
    if (this.jdField_c_of_type_Xuh == null)
    {
      paramBundle = (BinderWarpper)this.mActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (paramBundle == null) {
        break label336;
      }
      this.jdField_c_of_type_Xuh = xuh.a.a(paramBundle.binder);
      if (QLog.isColorLevel()) {
        QLog.d("SessionClearFragment", 2, "IAIOImageProvider is " + this.jdField_c_of_type_Xuh);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)axol.getAppInterface());
    this.jdField_a_of_type_Acsn = ((acsn)this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.getManager(4));
    this.jdField_a_of_type_Acsn.a(new abcm(this));
    this.jdField_a_of_type_Acsn.b(this.jdField_c_of_type_Xuh);
    this.jdField_c_of_type_Aduk = new aduk(this.mActivity, 1);
    this.jdField_c_of_type_Aduk.init();
    this.jdField_c_of_type_Aduk.a(new abcn(this));
    this.d = new aduk(this.mActivity, 4);
    this.d.init();
    this.d.a(new abco(this));
    this.e = new aduk(this.mActivity, 101);
    this.e.init();
    this.e.a(new abcp(this));
    this.jdField_a_of_type_Acsn.cOs();
    this.eB = aqhu.G();
    return;
    label336:
    throw new IllegalArgumentException("can't find Binder in Intent..");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563077, paramViewGroup, false);
    initUI(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Acsn.onDestroy();
    this.jdField_c_of_type_Aduk.destroy();
    this.d.destroy();
    this.e.destroy();
    if (this.jdField_a_of_type_Arhz != null) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
    this.mActivity = null;
  }
  
  public void showProgressDialog()
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this.mActivity, getResources().getDimensionPixelSize(2131299627));
    }
    this.jdField_a_of_type_Arhz.setCancelable(false);
    this.jdField_a_of_type_Arhz.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Arhz.setMessage(acfp.m(2131714319));
    this.jdField_a_of_type_Arhz.show();
    this.jdField_a_of_type_Arhz.a(new abcv(this));
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    RecentDynamicAvatarView c;
    public CheckBox mCheckBox;
    TextView name;
    TextView size;
    
    public a(View paramView)
    {
      super();
      this.mCheckBox = ((CheckBox)paramView.findViewById(2131364587));
      this.c = ((RecentDynamicAvatarView)paramView.findViewById(2131368698));
      this.name = ((TextView)paramView.findViewById(2131372190));
      this.size = ((TextView)paramView.findViewById(2131378460));
    }
  }
  
  public class b
    extends RecyclerView.Adapter<SessionClearFragment.a>
  {
    Map<String, Integer> iN = new HashMap();
    public List<acsf> vM;
    
    public b()
    {
      Object localObject;
      this.vM = localObject;
    }
    
    public acsf a(int paramInt)
    {
      return (acsf)this.vM.get(paramInt);
    }
    
    public SessionClearFragment.a a(ViewGroup paramViewGroup, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SessionClearFragment", 2, "onCreateViewHolder");
      }
      paramViewGroup = SessionClearFragment.a(SessionClearFragment.this).getLayoutInflater().inflate(2131563076, paramViewGroup, false);
      return new SessionClearFragment.a(SessionClearFragment.this, paramViewGroup);
    }
    
    public void a(SessionClearFragment.a parama, int paramInt)
    {
      acsf localacsf = a(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("SessionClearFragment", 2, "onBindViewHolder info uin=" + localacsf.uin + " pos=" + paramInt);
      }
      parama.name.setText(localacsf.displayName);
      parama.size.setText(localacsf.bqC);
      if ((localacsf.eP != null) && (!localacsf.eP.isRecycled()))
      {
        parama.c.setImageBitmap(localacsf.eP);
        if (!((acsf)this.vM.get(paramInt)).isCheck) {
          break label345;
        }
        parama.mCheckBox.setChecked(true);
      }
      for (;;)
      {
        parama.itemView.setOnClickListener(new abcw(this, parama, paramInt));
        EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
        return;
        if (localacsf.iconUrl != null)
        {
          SessionClearFragment.a(SessionClearFragment.this, localacsf.iconUrl, 80, 80, parama.c, paramInt);
          break;
        }
        Bitmap localBitmap = SessionClearFragment.a(SessionClearFragment.this);
        this.iN.put(localacsf.uin, Integer.valueOf(paramInt));
        if ((localacsf.messageType == 0) || (localacsf.messageType == 1000) || (localacsf.messageType == 1004)) {
          localBitmap = SessionClearFragment.a(SessionClearFragment.this).getFaceBitmap(localacsf.uin, true);
        }
        for (;;)
        {
          if (localBitmap == null) {
            break label343;
          }
          parama.c.setImageBitmap(localBitmap);
          break;
          if (localacsf.messageType == 1) {
            localBitmap = SessionClearFragment.b(SessionClearFragment.this).getFaceBitmap(localacsf.uin, true);
          } else if (localacsf.messageType == 3000) {
            localBitmap = SessionClearFragment.c(SessionClearFragment.this).getFaceBitmap(localacsf.uin, true);
          }
        }
        label343:
        break;
        label345:
        parama.mCheckBox.setChecked(false);
      }
    }
    
    public void b(String paramString1, Bitmap paramBitmap, String paramString2)
    {
      int i = ca(paramString1);
      if (i >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SessionClearFragment", 4, "updateImage  uin: " + paramString1 + " pos =" + i);
        }
        SessionClearFragment.a(SessionClearFragment.this).a(i).iconUrl = paramString2;
        SessionClearFragment.a(SessionClearFragment.this).a(i).eP = paramBitmap;
        SessionClearFragment.a(SessionClearFragment.this).notifyItemChanged(i);
      }
    }
    
    public void bF(List<acsf> paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SessionClearFragment", 2, "setList sessionList size=" + paramList.size());
      }
      if (this.vM != null) {
        this.vM.clear();
      }
      this.vM = paramList;
      notifyDataSetChanged();
    }
    
    public void cBc()
    {
      SessionClearFragment.b(SessionClearFragment.this, 0);
      SessionClearFragment.c(SessionClearFragment.this, 0);
      int i = 0;
      boolean bool = false;
      while (i < this.vM.size())
      {
        if (((acsf)this.vM.get(i)).isCheck)
        {
          SessionClearFragment.b(SessionClearFragment.this, (int)(SessionClearFragment.c(SessionClearFragment.this) + ((acsf)this.vM.get(i)).totalSize));
          SessionClearFragment.d(SessionClearFragment.this);
          bool = true;
        }
        i += 1;
      }
      if (SessionClearFragment.c(SessionClearFragment.this) == 0)
      {
        SessionClearFragment.a(SessionClearFragment.this).setVisibility(8);
        if (SessionClearFragment.b(SessionClearFragment.this) != this.vM.size()) {
          break label223;
        }
        SessionClearFragment.a(SessionClearFragment.this, 1);
      }
      for (;;)
      {
        SessionClearFragment.b(SessionClearFragment.this).setEnabled(bool);
        return;
        SessionClearFragment.a(SessionClearFragment.this).setVisibility(0);
        SessionClearFragment.a(SessionClearFragment.this).setText(acfp.m(2131714322) + acsh.aV(SessionClearFragment.c(SessionClearFragment.this)));
        break;
        label223:
        SessionClearFragment.a(SessionClearFragment.this, 0);
      }
    }
    
    public void cBd()
    {
      int i = 0;
      while (i < this.vM.size())
      {
        ((acsf)this.vM.get(i)).isCheck = false;
        i += 1;
      }
      notifyDataSetChanged();
      cBc();
    }
    
    public int ca(String paramString)
    {
      if (this.iN.containsKey(paramString)) {
        return ((Integer)this.iN.get(paramString)).intValue();
      }
      return -1;
    }
    
    public int getItemCount()
    {
      return this.vM.size();
    }
    
    public void selectAll()
    {
      int i = 0;
      while (i < this.vM.size())
      {
        ((acsf)this.vM.get(i)).isCheck = true;
        i += 1;
      }
      notifyDataSetChanged();
      cBc();
      anot.a(null, "dc00898", "", "", "0X800A0C6", "0X800A0C6", 0, 0, String.valueOf(SessionClearFragment.b(SessionClearFragment.this)), String.valueOf(SessionClearFragment.c(SessionClearFragment.this)), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment
 * JD-Core Version:    0.7.0.1
 */