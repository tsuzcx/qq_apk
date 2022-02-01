package com.tencent.mobileqq.profile;

import ProfileLogic.QC.profileItem;
import acle;
import aclh;
import alax;
import alay;
import alaz;
import alba;
import alco;
import alco.a;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqep;
import aqfy;
import aqnm;
import aqrc;
import arib;
import avpw;
import avpw.d;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import wja;

public class CustomCoverFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener
{
  private ImageView Cv;
  private View FJ;
  private Vector<Integer> K;
  private alco jdField_a_of_type_Alco;
  private arib jdField_a_of_type_Arib;
  private d jdField_a_of_type_ComTencentMobileqqProfileCustomCoverFragment$d;
  private boolean cvJ;
  private boolean cvK;
  private boolean cvL;
  private int drj;
  private int drk;
  private int drl = 2;
  private int drn;
  private int dro;
  private int drp;
  private DialogInterface.OnCancelListener f = new alay(this);
  public View.OnClickListener fB = new alaz(this);
  private aclh g = new alax(this);
  private QQAppInterface mApp;
  private Drawable mLoadingDrawable;
  private RecyclerView mRecyclerView;
  private Handler mUIHandler;
  private Uri y;
  
  private void SE(int paramInt)
  {
    if (this.mApp != null)
    {
      this.dro = paramInt;
      ((acle)this.mApp.getBusinessHandler(13)).JQ(paramInt);
      this.jdField_a_of_type_Arib.a(0, getString(2131701247), 0, this.f);
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "defaultcard", "set_defaultcard", "", 1, 0, 0, "", Integer.toString(paramInt), "");
    }
  }
  
  private void biW()
  {
    if (this.mApp != null)
    {
      startTitleProgress();
      ((acle)this.mApp.getBusinessHandler(13)).JP(this.drp);
    }
  }
  
  private void d(FragmentActivity paramFragmentActivity)
  {
    this.y = FriendProfileCardActivity.a(paramFragmentActivity, 1021);
    anot.a(paramFragmentActivity.app, "CliOper", "", "", "0X8006A89", "0X8006A89", 0, 0, "", "", "", "");
    VasWebviewUtil.reportCommercialDrainage(paramFragmentActivity.app.getCurrentAccountUin(), "defaultcard", "photo_takeaphoto", "", 1, 0, 0, "", "", "");
  }
  
  private void setChecked(boolean paramBoolean)
  {
    this.cvJ = paramBoolean;
    if (this.Cv != null)
    {
      if (paramBoolean) {
        this.Cv.setImageResource(2130841396);
      }
    }
    else {
      return;
    }
    this.Cv.setImageResource(2130841394);
  }
  
  private void setItems(List<profileItem> paramList)
  {
    if ((paramList != null) && (this.mApp != null) && (this.jdField_a_of_type_Alco != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        profileItem localprofileItem = (profileItem)paramList.next();
        this.jdField_a_of_type_Alco.a(localprofileItem.itemid, true);
        if (!this.K.contains(Integer.valueOf(localprofileItem.itemid))) {
          this.K.add(Integer.valueOf(localprofileItem.itemid));
        }
      }
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getResources().getString(2131694825));
    if (this.mLeftBackText != null) {
      this.mLeftBackText.setText("");
    }
    if (this.leftView != null) {
      this.leftView.setText("");
    }
    this.cvL = getActivity().getIntent().getBooleanExtra("is_default_key", true);
    this.mApp = getActivity().app;
    this.jdField_a_of_type_Alco = ((aqrc)this.mApp.getManager(235)).b;
    int i = aqnm.dip2px(3.0F);
    this.drj = ((aqnm.getScreenWidth() - i * 2) / 3);
    this.drk = ((int)(this.drj * 0.77F));
    this.K = new Vector();
    this.mUIHandler = new Handler(this);
    ((aqrc)this.mApp.getManager(235)).b.dj = this.mUIHandler;
    this.jdField_a_of_type_Arib = new arib(getActivity(), 2131561628);
    try
    {
      this.mLoadingDrawable = getActivity().getResources().getDrawable(2130851854);
      this.mRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131376994));
      this.mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
      this.jdField_a_of_type_ComTencentMobileqqProfileCustomCoverFragment$d = new d();
      this.mRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileCustomCoverFragment$d);
      this.mRecyclerView.addItemDecoration(new e(i));
      biW();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "doOnCreateView: mIsDefaultTypeCard=" + this.cvL);
      }
      return;
    }
    catch (Exception paramLayoutInflater)
    {
      for (;;)
      {
        QLog.e("Q.profilecard.FrdProfileCard.CustomCoverFragment", 1, "doOnCreateView: ", paramLayoutInflater);
      }
    }
  }
  
  public String eJ(int paramInt)
  {
    alco.a locala = this.jdField_a_of_type_Alco.a(paramInt, false);
    if ((locala != null) && (!TextUtils.isEmpty(locala.coverUrl)))
    {
      QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "getItemCoverUrl: " + locala.coverUrl);
      return locala.coverUrl;
    }
    QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "getItemCoverUrl: null");
    return "";
  }
  
  public int getContentLayoutId()
  {
    return 2131562210;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 101)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "handleMessage: refresh list");
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileCustomCoverFragment$d.notifyDataSetChanged();
    }
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramInt1 == 1021) {
      localIntent.putExtra("upload_uri_key", this.y);
    }
    if ((paramInt1 == 1020) || (paramInt1 == 1021))
    {
      if (paramInt2 == -1)
      {
        localIntent.putExtra("req_code_key", paramInt1);
        getActivity().setResult(paramInt2, localIntent);
        getActivity().finish();
      }
    }
    else if ((paramInt1 == 2001) && (paramInt2 == -1))
    {
      QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onActivityResult: ");
      paramInt1 = localIntent.getIntExtra("cover_id_key", 0);
      localIntent.putExtra("req_code_key", 2002);
      localIntent.putExtra("card_url_key", eJ(paramInt1));
      getActivity().setResult(paramInt2, localIntent);
      getActivity().finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, localIntent);
  }
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.app == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131361977: 
        if (Build.VERSION.SDK_INT >= 23) {
          if (localFragmentActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
            localFragmentActivity.requestPermissions(new alba(this, localFragmentActivity), 1, new String[] { "android.permission.CAMERA" });
          }
        }
        break;
      case 2131361983: 
        localObject = new Intent(localFragmentActivity, NewPhotoListActivity.class);
        ((Intent)localObject).putExtra("enter_from", 44);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localFragmentActivity.getClass().getName());
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
        ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
        ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
        ((Intent)localObject).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
        ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        int i = aqep.x(localFragmentActivity);
        int j = aqep.y(localFragmentActivity);
        ((Intent)localObject).putExtra("PhotoConst.CLIP_WIDTH", i);
        ((Intent)localObject).putExtra("PhotoConst.CLIP_HEIGHT", j);
        ((Intent)localObject).putExtra("PhotoConst.32_Bit_Config", true);
        ((Intent)localObject).putExtra("PhotoConst.TARGET_WIDTH", i);
        ((Intent)localObject).putExtra("PhotoConst.TARGET_HEIGHT", j);
        ((Intent)localObject).putExtra("PhotoConst.TARGET_PATH", aqep.H(localFragmentActivity.app));
        ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        ((Intent)localObject).putExtra("action_cover_pick_gallery", true);
        startActivity((Intent)localObject);
        aqfy.anim(localFragmentActivity, false, true);
        anot.a(localFragmentActivity.app, "CliOper", "", "", "0X8006A87", "0X8006A87", 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(localFragmentActivity.app.getCurrentAccountUin(), "defaultcard", "photo_album", "", 1, 0, 0, "", "", "");
        break;
      case 2131361997: 
        localObject = new Bundle();
        ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
        ((Bundle)localObject).putInt("_input_max", 1);
        ((Bundle)localObject).putBoolean("key_multiple_model_need_download_img", true);
        avpw.d locald = avpw.d.a();
        locald.cMP = localFragmentActivity.app.getCurrentAccountUin();
        ((Bundle)localObject).putString("keyAction", "actionSelectPicture");
        ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
        avpw.a(localFragmentActivity, locald, (Bundle)localObject, 1020);
        anot.a(localFragmentActivity.app, "CliOper", "", "", "0X8006A88", "0X8006A88", 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(localFragmentActivity.app.getCurrentAccountUin(), "defaultcard", "photo_qzone", "", 1, 0, 0, "", "", "");
        continue;
        d(localFragmentActivity);
        continue;
        d(localFragmentActivity);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.mApp != null) && (this.jdField_a_of_type_Alco != null)) {
      this.jdField_a_of_type_Alco.dj = null;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      paramIntent.putExtra("req_code_key", 1025);
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mApp != null) {
      this.mApp.removeObserver(this.g);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mApp != null) {
      this.mApp.addObserver(this.g);
    }
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
      this.itemView.setTag(this);
      this.itemView.findViewById(2131361983).setOnClickListener(CustomCoverFragment.this);
      this.itemView.findViewById(2131361997).setOnClickListener(CustomCoverFragment.this);
      this.itemView.findViewById(2131361977).setOnClickListener(CustomCoverFragment.this);
      CustomCoverFragment.a(CustomCoverFragment.this, this.itemView.findViewById(2131370173));
      CustomCoverFragment.a(CustomCoverFragment.this).setVisibility(8);
      CustomCoverFragment.a(CustomCoverFragment.this, (ImageView)this.itemView.findViewById(2131369698));
      CustomCoverFragment.a(CustomCoverFragment.this).setOnClickListener(CustomCoverFragment.this.fB);
      wja.i(CustomCoverFragment.a(CustomCoverFragment.this), 0, 0, (int)(CustomCoverFragment.a(CustomCoverFragment.this) * 20.0F + 0.5F), (int)(CustomCoverFragment.b(CustomCoverFragment.this) * 20.0F + 0.5F));
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    Button aI;
    int id;
    ImageView imageView;
    TextView textView;
    
    public b(View paramView)
    {
      super();
      paramView.setTag(this);
      this.imageView = ((ImageView)paramView.findViewById(2131368846));
      this.textView = ((TextView)paramView.findViewById(2131379419));
      this.aI = ((Button)paramView.findViewById(2131364084));
      this.aI.setOnClickListener(CustomCoverFragment.this.fB);
      this.imageView.setOnClickListener(CustomCoverFragment.this.fB);
    }
  }
  
  class c
    extends RecyclerView.ViewHolder
  {
    ImageView Cw;
    TextView ny;
    
    public c(View paramView)
    {
      super();
      this.itemView.setTag(this);
      this.ny = ((TextView)paramView.findViewById(2131367488));
      this.Cw = ((ImageView)paramView.findViewById(2131367478));
      this.itemView.setBackgroundColor(CustomCoverFragment.this.getResources().getColor(2131167654));
    }
  }
  
  public class d
    extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  {
    public d() {}
    
    private void a(CustomCoverFragment.b paramb)
    {
      if (CustomCoverFragment.c(CustomCoverFragment.this))
      {
        paramb.aI.setBackgroundResource(2130851044);
        paramb.aI.setTextColor(-8947849);
        paramb.aI.setText(2131697051);
        return;
      }
      if ((paramb.id == CustomCoverFragment.a(CustomCoverFragment.this)) && (CustomCoverFragment.a(CustomCoverFragment.this)))
      {
        paramb.aI.setBackgroundResource(2130851044);
        paramb.aI.setTextColor(-8947849);
        paramb.aI.setText(2131719632);
        return;
      }
      paramb.aI.setBackgroundResource(2130851071);
      paramb.aI.setTextColor(-16777216);
      paramb.aI.setText(2131697051);
    }
    
    public alco.a a(int paramInt)
    {
      if ((CustomCoverFragment.a(CustomCoverFragment.this) != null) && (paramInt > 0) && (paramInt - 1 < CustomCoverFragment.a(CustomCoverFragment.this).size()) && (CustomCoverFragment.a(CustomCoverFragment.this) != null))
      {
        paramInt = ((Integer)CustomCoverFragment.a(CustomCoverFragment.this).get(paramInt - 1)).intValue();
        return CustomCoverFragment.a(CustomCoverFragment.this).a(paramInt, false);
      }
      return null;
    }
    
    public int getItemCount()
    {
      if (CustomCoverFragment.a(CustomCoverFragment.this) == null) {}
      for (int i = 0;; i = CustomCoverFragment.a(CustomCoverFragment.this).size()) {
        return i + 2;
      }
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      if ((CustomCoverFragment.a(CustomCoverFragment.this) != null) && (paramInt > CustomCoverFragment.a(CustomCoverFragment.this).size())) {
        return 2;
      }
      return 1;
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      Object localObject1;
      alco.a locala;
      if ((paramViewHolder instanceof CustomCoverFragment.b))
      {
        localObject1 = (CustomCoverFragment.b)paramViewHolder;
        locala = a(paramInt);
        if (locala != null)
        {
          ((CustomCoverFragment.b)localObject1).id = locala.id;
          ((CustomCoverFragment.b)localObject1).textView.setText(locala.name);
          if (TextUtils.isEmpty(locala.previewUrl))
          {
            ((CustomCoverFragment.b)localObject1).imageView.setImageDrawable(CustomCoverFragment.a(CustomCoverFragment.this));
            ((CustomCoverFragment.b)localObject1).aI.setTag(Integer.valueOf(locala.id));
            ((CustomCoverFragment.b)localObject1).imageView.setTag(Integer.valueOf(locala.id));
            label100:
            a((CustomCoverFragment.b)localObject1);
          }
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = CustomCoverFragment.f(CustomCoverFragment.this);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = CustomCoverFragment.e(CustomCoverFragment.this);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = CustomCoverFragment.a(CustomCoverFragment.this);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = CustomCoverFragment.a(CustomCoverFragment.this);
        localObject2 = URLDrawable.getDrawable(locala.previewUrl, (URLDrawable.URLDrawableOptions)localObject2);
        ((CustomCoverFragment.b)localObject1).imageView.setImageDrawable((Drawable)localObject2);
        break;
        ((CustomCoverFragment.b)localObject1).aI.setTag(Integer.valueOf(0));
        ((CustomCoverFragment.b)localObject1).imageView.setTag(Integer.valueOf(0));
        break label100;
        if ((paramViewHolder instanceof CustomCoverFragment.c))
        {
          localObject1 = (CustomCoverFragment.c)paramViewHolder;
          if (CustomCoverFragment.c(CustomCoverFragment.this) == 0)
          {
            CustomCoverFragment.c(CustomCoverFragment.this, 3);
            CustomCoverFragment.a(CustomCoverFragment.this);
          }
          if (CustomCoverFragment.c(CustomCoverFragment.this) == 3)
          {
            ((CustomCoverFragment.c)localObject1).itemView.setVisibility(0);
            ((CustomCoverFragment.c)localObject1).ny.setTextColor(-16777216);
            ((CustomCoverFragment.c)localObject1).ny.setText(2131689613);
            ((CustomCoverFragment.c)localObject1).Cw.setVisibility(8);
            ((CustomCoverFragment.c)localObject1).itemView.setBackgroundResource(2131166609);
          }
          else if (CustomCoverFragment.c(CustomCoverFragment.this) == 1)
          {
            ((CustomCoverFragment.c)localObject1).itemView.setVisibility(0);
            ((CustomCoverFragment.c)localObject1).ny.setTextColor(CustomCoverFragment.this.getResources().getColor(2131165858));
            ((CustomCoverFragment.c)localObject1).ny.setText(2131691285);
            ((CustomCoverFragment.c)localObject1).Cw.setVisibility(0);
            ((CustomCoverFragment.c)localObject1).itemView.setBackgroundResource(2131167654);
          }
          else if (CustomCoverFragment.c(CustomCoverFragment.this) == 2)
          {
            ((CustomCoverFragment.c)localObject1).itemView.setVisibility(8);
          }
        }
      }
    }
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      CustomCoverFragment.a locala = null;
      if (paramInt == 0)
      {
        paramViewGroup = CustomCoverFragment.this.getActivity().getLayoutInflater().inflate(2131562208, paramViewGroup, false);
        locala = new CustomCoverFragment.a(CustomCoverFragment.this, paramViewGroup);
      }
      do
      {
        return locala;
        if (paramInt == 1)
        {
          paramViewGroup = CustomCoverFragment.this.getActivity().getLayoutInflater().inflate(2131562209, paramViewGroup, false);
          paramViewGroup = new CustomCoverFragment.b(CustomCoverFragment.this, paramViewGroup);
          ((CustomCoverFragment.b)paramViewGroup).imageView.getLayoutParams().height = CustomCoverFragment.e(CustomCoverFragment.this);
          return paramViewGroup;
        }
      } while (paramInt != 2);
      paramViewGroup = CustomCoverFragment.this.getActivity().getLayoutInflater().inflate(2131562087, paramViewGroup, false);
      return new CustomCoverFragment.c(CustomCoverFragment.this, paramViewGroup);
    }
    
    public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
    {
      boolean bool = true;
      super.onViewAttachedToWindow(paramViewHolder);
      Object localObject = paramViewHolder.itemView.getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
        if (getItemViewType(paramViewHolder.getLayoutPosition()) == 1) {
          break label49;
        }
      }
      for (;;)
      {
        ((StaggeredGridLayoutManager.LayoutParams)localObject).setFullSpan(bool);
        return;
        label49:
        bool = false;
      }
    }
  }
  
  public class e
    extends RecyclerView.ItemDecoration
  {
    private int space;
    
    public e(int paramInt)
    {
      this.space = paramInt;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      if (!(paramView.getTag() instanceof CustomCoverFragment.b))
      {
        paramRect.left = 0;
        return;
      }
      int i = paramRecyclerView.getChildLayoutPosition(paramView) - 1;
      float f = this.space * 2 * 1.0F / 3.0F;
      paramRect.left = ((int)(i % 3 * (this.space - f)));
      paramRect.right = ((int)(f - i % 3 * (this.space - f)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment
 * JD-Core Version:    0.7.0.1
 */