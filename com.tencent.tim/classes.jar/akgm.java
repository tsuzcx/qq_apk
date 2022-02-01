import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.16;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.17;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.20;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.8;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomImgView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class akgm
  extends akfj
  implements View.OnClickListener
{
  static final String[] fG = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  View Fg;
  TextView VO;
  TextView VP;
  TextView VQ;
  TextView VR;
  TextView VS;
  TextView VT;
  TextView VU;
  public TextView VV;
  TextView VW;
  public LinkedList<PicInfo> W = new LinkedList();
  private akgm.a jdField_a_of_type_Akgm$a;
  NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  public NearbyPeopleProfileActivity a;
  public BounceScrollView a;
  private IphonePickerView.d b = new akgq(this);
  String bTo = "";
  EditText bm;
  EditText bn;
  EditText bo;
  EditText bp;
  EditText bs;
  EditText bt;
  URLImageView bv;
  URLImageView bw;
  private PicInfo c;
  private boolean csm;
  private IphonePickerView.d d = new akgz(this);
  private int dmB;
  int dmN;
  private View.OnLongClickListener i = new akgy(this);
  LinearLayout jF;
  LinearLayout jI;
  private aook k = new akgx(this);
  private RelativeLayout lq;
  int mCurrentYear = 2015;
  int mHorizontalSpacing;
  ImageView mVideoIcon;
  int yE;
  int yF;
  int yG;
  int yH;
  int yI;
  final ArrayList<PicInfo> yi = new ArrayList(13);
  final ArrayList<PicInfo> yj = new ArrayList(13);
  
  public akgm(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_Akgm$a = new akgm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth);
    }
    this.mHorizontalSpacing = rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2.0F);
    this.k.addFilter(new Class[] { aomd.class });
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a(this.k);
  }
  
  @TargetApi(11)
  private RelativeLayout a(PicInfo paramPicInfo, Drawable paramDrawable)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130845956);
    Object localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, this.mHorizontalSpacing, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((CustomImgView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    a(this.bw, paramPicInfo, paramDrawable);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localRelativeLayout.setOnLongClickListener(this.i);
      localRelativeLayout.setOnDragListener(this.jdField_a_of_type_Akgm$a);
    }
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.addView(cm());
    localRelativeLayout.setTag(paramPicInfo);
    return localRelativeLayout;
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    RichStatus localRichStatus;
    if (paramArrayOfByte != null)
    {
      localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165381));
      }
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus == null) || (TextUtils.isEmpty(localRichStatus.actionText))) {
        break label225;
      }
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Amhj == null) {
        break label208;
      }
    }
    label208:
    for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Amhj.i(localRichStatus.actionId, 200);; paramArrayOfByte = aqcu.decodeResource(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130850435))
    {
      paramArrayOfByte = new arjh(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
      int j = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramArrayOfByte.setBounds(0, 0, j, j);
      paramArrayOfByte = new argi(paramArrayOfByte, 0);
      paramArrayOfByte.a(-0.1F);
      ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    label225:
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void a(URLImageView paramURLImageView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "setDrawable ,picInfo:" + paramPicInfo);
    }
    paramURLImageView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null)
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      ((GradientDrawable)localObject).setCornerRadius(aqcx.dip2px(this.mContext, 15.0F));
      ((GradientDrawable)localObject).setColor(-1579033);
    }
    try
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      if ((paramPicInfo.localPath != null) && (paramPicInfo.localPath.length() > 0))
      {
        paramPicInfo = new File(paramPicInfo.localPath).toURL();
        URLDrawable.removeMemoryCacheByUrl(paramPicInfo.toString());
        paramPicInfo = URLDrawable.getDrawable(paramPicInfo, localURLDrawableOptions);
        paramPicInfo.setDecodeHandler(aqbn.b);
        paramURLImageView.setImageDrawable(paramPicInfo);
        return;
      }
      paramDrawable = null;
      if (TextUtils.isEmpty(paramPicInfo.thumbUrl)) {
        break label283;
      }
      paramDrawable = paramPicInfo.thumbUrl;
    }
    catch (MalformedURLException paramURLImageView)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      while (QLog.isColorLevel())
      {
        paramPicInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        QLog.d("Q.nearby_people_card.", 2, "GridAdapter.getView() new URL(). " + paramURLImageView.getMessage(), paramURLImageView);
        return;
        if (!TextUtils.isEmpty(paramPicInfo.bSZ)) {
          paramDrawable = paramPicInfo.bSZ;
        }
      }
    }
    if (!TextUtils.isEmpty(paramDrawable))
    {
      paramPicInfo = URLDrawable.getDrawable(aomc.l(paramDrawable), localURLDrawableOptions);
      paramPicInfo.setDecodeHandler(aqbn.b);
      paramURLImageView.setImageDrawable(paramPicInfo);
      return;
    }
    label283:
  }
  
  private boolean arM()
  {
    if (this.W.size() > 0) {
      return true;
    }
    int m = this.yi.size();
    if (m != this.yj.size()) {
      return true;
    }
    int j = 0;
    while (j < m)
    {
      if (this.yj.size() > 0)
      {
        if (((PicInfo)this.yi.get(j)).photoId != ((PicInfo)this.yj.get(j)).photoId) {
          return true;
        }
      }
      else {
        return false;
      }
      j += 1;
    }
    return false;
  }
  
  private boolean arO()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.W.size() > 0)
    {
      bool1 = true;
      return bool1;
    }
    int j = 0;
    for (;;)
    {
      bool1 = bool2;
      if (j >= this.yi.size()) {
        break;
      }
      bool1 = bool2;
      if (this.yj.size() <= 0) {
        break;
      }
      if (((PicInfo)this.yi.get(j)).photoId != ((PicInfo)this.yj.get(j)).photoId) {
        return true;
      }
      j += 1;
    }
  }
  
  private void c(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 2131167298;; j = 2131167304)
    {
      paramTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColorStateList(j));
      return;
    }
  }
  
  private boolean check()
  {
    String str = this.bm.getText().toString();
    if (!aqmr.isEmpty(str))
    {
      if (aqmr.trim(str).length() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(acfp.m(2131708881));
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(acfp.m(2131708805));
      return false;
    }
    return true;
  }
  
  private View cm()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130842188);
    Object localObject = new RelativeLayout.LayoutParams(rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 35.0F), rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 16.0F));
    int j = rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 5.0F);
    ((RelativeLayout.LayoutParams)localObject).setMargins(j, 0, 0, j);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((TextView)localObject).setText(acfp.m(2131708846));
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setSingleLine(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localLayoutParams.setMargins(j, 0, j, 0);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.setVisibility(8);
    return localRelativeLayout;
  }
  
  private void dBg()
  {
    dBh();
  }
  
  private void dBh()
  {
    this.yi.clear();
    this.yi.add((PicInfo)this.bw.getTag());
    if (QLog.isColorLevel())
    {
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "reorganizePicInfo:" + this.yi);
    }
  }
  
  private void dBl()
  {
    this.VO.setText(acfp.m(2131708903));
    this.VO.setVisibility(0);
    this.VP.setText(acfp.m(2131708871));
    this.VP.setTextSize(2, 10.0F);
    this.VP.setVisibility(0);
    this.VO.setOnClickListener(null);
    this.VP.setOnClickListener(null);
    this.VP.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.Fg.findViewById(2131369579).setVisibility(8);
    TextView localTextView = (TextView)this.Fg.findViewById(2131369581);
    localTextView.setVisibility(0);
    localTextView.setText(2131721058);
    localTextView.setOnClickListener(new akgr(this));
    localTextView = (TextView)this.Fg.findViewById(2131369612);
    localTextView.setVisibility(0);
    localTextView.setText(2131721066);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new akgs(this));
    this.Fg.findViewById(2131377361).setOnClickListener(this);
  }
  
  private void o(View paramView1, View paramView2)
  {
    paramView2.postDelayed(new NearbyProfileEditTribePanel.20(this, paramView2, paramView1), 300L);
  }
  
  private void uM()
  {
    if (this.W.size() > 0)
    {
      localObject = new StringBuilder(acfp.m(2131708897));
      ((StringBuilder)localObject).append(this.dmN - this.W.size() + 1).append("/").append(this.dmN).append(")...");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dN(((StringBuilder)localObject).toString());
      localObject = new NearbyProfileEditTribePanel.16(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute((Runnable)localObject);
      return;
    }
    dBn();
    Object localObject = new Intent("tribe_profile_edit_finish");
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
  }
  
  private String xB()
  {
    ArrayList localArrayList = new ArrayList(5);
    if (arO()) {
      localArrayList.add(Integer.valueOf(1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!aqft.equalsWithNullCheck(this.bm.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        localArrayList.add(Integer.valueOf(2));
      }
      if (((Byte)this.bn.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        localArrayList.add(Integer.valueOf(3));
      }
      if (((Integer)((Object[])(Object[])this.bo.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        localArrayList.add(Integer.valueOf(4));
      }
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.bt.getTag())) {
        localArrayList.add(Integer.valueOf(5));
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localArrayList.size() > 0)
    {
      int j = 0;
      if (j < localArrayList.size())
      {
        if (j != localArrayList.size() - 1) {
          localStringBuilder.append(localArrayList.get(j)).append("::");
        }
        for (;;)
        {
          j += 1;
          break;
          localStringBuilder.append(localArrayList.get(j));
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  int GO()
  {
    this.W.clear();
    int j = 0;
    while (j < this.yi.size())
    {
      PicInfo localPicInfo = (PicInfo)this.yi.get(j);
      if (localPicInfo.photoId == -1) {
        this.W.add(localPicInfo);
      }
      j += 1;
    }
    this.dmN = this.W.size();
    return this.dmN;
  }
  
  public void RO(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = acbn.SDCARD_PATH + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
    aqfy.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, true);
    anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  public boolean a(PicInfo paramPicInfo)
  {
    a(this.bw, paramPicInfo, null);
    dBg();
    return true;
  }
  
  void aT(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = this.mCurrentYear - (paramInt1 + 1896);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(1, paramInt2 + 1, paramInt3 + 1);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.yE, this.yF);
    int j = m;
    if (((Calendar)localObject1).after(localObject2)) {
      j = m - 1;
    }
    m = j;
    if (j < 0) {
      m = 0;
    }
    paramInt1 += 1896;
    j = paramInt2 + 1;
    int n = paramInt3 + 1;
    localObject1 = aqft.U(paramInt2 + 1, paramInt3 + 1);
    paramInt2 = AgeSelectionActivity.bB((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt1).append("-").append(j).append("-").append(n).append(" ").append("(").append(m).append("岁").append(" ").append((String)localObject1).append(")");
    this.bo.setText(((StringBuilder)localObject2).toString());
    this.bo.setTag(new Object[] { Integer.valueOf(paramInt1 << 16 | j << 8 | n), Integer.valueOf(m), Integer.valueOf(paramInt2) });
  }
  
  public boolean arK()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crv) {
      return true;
    }
    if (arO()) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.bt.getTag())) {
        return true;
      }
      if (!aqft.equalsWithNullCheck(this.bm.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
      if (((Byte)this.bn.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.bo.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        return true;
      }
    }
    return false;
  }
  
  public boolean arL()
  {
    int j = this.yi.size();
    int m = this.yj.size();
    if ((m <= 0) && (j >= 1)) {
      return true;
    }
    if ((m >= 1) && (j <= 0)) {
      return true;
    }
    if ((m >= 1) && (j >= 1)) {
      return ((PicInfo)this.yi.get(0)).photoId != ((PicInfo)this.yj.get(0)).photoId;
    }
    return false;
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    Object localObject;
    int j;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if ("EditPanel bindData, isEditing = " + this.isEditing + ", mActivity.mPicInfo.size = " + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi == null)
      {
        localObject = "null";
        QLog.d("Q.nearby_people_card.", 2, new Object[] { localObject });
      }
    }
    else
    {
      j = ((Integer)ajrb.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_edit", 0, 0, ajrk.eD(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from), j + "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.size() <= 0)) {
        break label802;
      }
      a(this.bw, (PicInfo)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.get(0), null);
      label216:
      if (!this.isEditing)
      {
        this.yi.clear();
        this.yi.addAll(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi);
        this.yj.clear();
        this.yj.addAll(this.yi);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crz)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.clear();
        this.yi.clear();
        this.yj.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
        break label833;
      }
      this.bTo = acfp.m(2131708891);
      label318:
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
        break label857;
      }
      this.VR.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696224));
    }
    for (;;)
    {
      this.bm.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      this.bn.setText(aqek.fX(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
      this.bn.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
      j = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age;
      int m = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday;
      int n = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation;
      int i1 = (0xFF00 & m) >> 8;
      int i2 = m & 0xFF;
      paramNearbyPeopleCard = aqft.U(i1, i2);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(m >> 16).append("-").append(i1).append("-").append(i2).append(" ").append("(").append(j).append("岁").append(" ").append(paramNearbyPeopleCard).append(")");
      this.bo.setText(((StringBuilder)localObject).toString());
      this.bo.setTag(new Object[] { Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(n) });
      j = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job;
      a(this.bt, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.bt.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crB) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmw == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.postDelayed(new NearbyProfileEditTribePanel.8(this), 300L);
      }
      this.Fg.findViewById(2131382395).setOnClickListener(this);
      this.bt.setOnClickListener(this);
      this.Fg.findViewById(2131367943).setOnClickListener(this);
      this.bn.setOnClickListener(this);
      this.Fg.findViewById(2131362335).setOnClickListener(this);
      this.bo.setOnClickListener(this);
      this.Fg.findViewById(2131363191).setOnClickListener(this);
      this.bw.setOnClickListener(this);
      this.bm.addTextChangedListener(new akhd(this));
      this.bt.addTextChangedListener(new akgo(this));
      this.bm.getViewTreeObserver().addOnGlobalLayoutListener(new akgp(this));
      return;
      localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.size());
      break;
      label802:
      paramNearbyPeopleCard = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramNearbyPeopleCard = aqdj.a(paramNearbyPeopleCard, 1, paramNearbyPeopleCard.getCurrentAccountUin());
      this.bw.setImageDrawable(paramNearbyPeopleCard);
      break label216;
      label833:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label318;
      }
      this.bTo = acfp.m(2131708842);
      break label318;
      label857:
      if (this.yi.size() > NearbyPeopleProfileActivity.dmq) {
        this.VR.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696225, new Object[] { this.bTo }));
      }
    }
  }
  
  public void bB(String paramString, int paramInt)
  {
    int m = 1;
    int j = 1;
    this.csm = true;
    if (TextUtils.isEmpty(paramString))
    {
      this.dmB = 1;
      this.VT.setText("");
      paramInt = 0;
      if (paramInt != 0)
      {
        this.VU.setVisibility(0);
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006784", "0X8006784", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (paramInt == 0)
      {
        if (TextUtils.equals(this.VT.getText().toString(), paramString)) {
          if (this.dmB == 2) {
            paramInt = j;
          }
        }
        for (;;)
        {
          this.VT.setText(paramString);
          break;
          paramInt = 0;
          continue;
          this.dmB = paramInt;
          paramInt = 0;
        }
      }
      if (paramInt == 2) {}
      for (j = m;; j = 0)
      {
        this.dmB = paramInt;
        paramInt = j;
        break;
      }
    }
    this.VU.setVisibility(8);
  }
  
  protected void cG(View paramView)
  {
    this.Fg = paramView;
    paramView.findViewById(2131379823).setVisibility(0);
    this.VO = ((TextView)paramView.findViewById(2131379865));
    this.VP = ((TextView)paramView.findViewById(2131379802));
    paramView.findViewById(2131369627).setVisibility(4);
    this.mVideoIcon = ((ImageView)paramView.findViewById(2131381715));
    this.VW = ((TextView)paramView.findViewById(2131373561));
    this.VQ = ((TextView)paramView.findViewById(2131373111));
    this.VR = ((TextView)paramView.findViewById(2131378920));
    this.bm = ((EditText)paramView.findViewById(2131372384));
    this.bn = ((EditText)paramView.findViewById(2131367940));
    this.bo = ((EditText)paramView.findViewById(2131362333));
    this.bw = ((URLImageView)paramView.findViewById(2131363175));
    this.bt = ((EditText)paramView.findViewById(2131382394));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.Fg.findViewById(2131366254));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    dBl();
    aprv.l("profile_edit", "exp", "", "", "", "");
  }
  
  public void dBb() {}
  
  public void dBc()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    accv localaccv = (accv)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(59);
    int j = localaccv.Ai();
    Object localObject1;
    if (j != 0)
    {
      j = localaccv.q(j, true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "startLocationSelectActivity | update result = " + j);
      }
      if (j == 2)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131696272, 0).show(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
        return;
      }
      if (j == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dN(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131691966));
        localaccv.addListener(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Accv$b);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dN(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131691966));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      ((Handler)localObject1).sendEmptyMessageDelayed(206, 20000L);
      return;
    }
    Object localObject2 = (String[])this.bs.getTag();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length == 4) {}
    }
    else
    {
      localObject1 = new String[4];
      localObject1[0] = "0";
      localObject1[1] = "0";
      localObject1[2] = "0";
      localObject1[3] = "0";
    }
    localIntent.putExtra("param_location", (String[])localObject1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", localaccv.e((String[])localObject1));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 4);
  }
  
  public void dBd()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {}
    String[] arrayOfString;
    String str;
    do
    {
      return;
      arrayOfString = new String[4];
      arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry;
      arrayOfString[1] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice;
      arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity;
      arrayOfString[3] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict;
      str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f.d(arrayOfString);
    } while (this.bs == null);
    if (!"不限".equals(str)) {
      this.bs.setText(str);
    }
    this.bs.setTag(arrayOfString);
  }
  
  void dBm()
  {
    anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004823", "0X8004823", 0, 0, "", "", "", "");
    aprv.l("profile_edit", "suc_edit", xB(), "", "", "");
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "doOldSaveAction, picInfo size|" + this.yi.size());
    }
    uM();
  }
  
  void dBn()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "saveNearbyProfileCard");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dN(acfp.m(2131708883));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.yi);
    if (arM())
    {
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 1) {
        break label696;
      }
    }
    label679:
    label696:
    for (int j = 1;; j = 3)
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0))
      {
        localObject = "1";
        anot.a(null, "dc00899", "grp_lbs", "", "data_card", "upload_video", 0, 0, "", (String)localObject, "", String.valueOf(j));
        j = ((Integer)ajrb.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "suc_edit", 0, 0, ajrk.eD(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from), j + "", "", "");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("key_is_nearby_people_card", true);
        localBundle.putShort("key_new_profile_modified_flag", (short)1);
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
        {
          byte[] arrayOfByte = (byte[])this.bt.getTag();
          localObject = arrayOfByte;
          if (arrayOfByte == null) {
            localObject = new byte[0];
          }
          localBundle.putByteArray("key_xuan_yan", (byte[])localObject);
          if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.bt.getTag()))
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crw = true;
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
          }
          localObject = this.bm.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname))
          {
            localBundle.putString("key_new_nickname", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crw = true;
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
          }
          byte b1 = ((Byte)this.bn.getTag()).byteValue();
          if (b1 != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender)
          {
            localBundle.putByte("sex", b1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crw = true;
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
          }
          localObject = (Object[])this.bo.getTag();
          j = ((Integer)localObject[0]).intValue();
          if (j != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday)
          {
            localBundle.putInt("birthday", j);
            localBundle.putInt("age", ((Integer)localObject[1]).intValue());
            localBundle.putInt("key_constellation", ((Integer)localObject[2]).intValue());
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c;
        if (localObject == null) {
          break label679;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileEditTribePanel.17(this, (ajrs)localObject, localBundle, localArrayList));
      }
      while (!QLog.isDevelopLevel())
      {
        return;
        localObject = "2";
        break;
      }
      QLog.i("Q.nearby_people_card.", 4, "NearbyCardHandler is null");
      return;
    }
  }
  
  public void dBo()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, JobSelectionActivity.class);
    if ((this.bp != null) && (this.bp.getTag() != null) && ((this.bp.getTag() instanceof Integer))) {
      localIntent.putExtra("param_id", (Integer)this.bp.getTag());
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 3);
  }
  
  public void dBp()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, EditActivity.class);
    localIntent.putExtra("param_entry", 1);
    localIntent.putExtra("param_old_xuan_yan", (byte[])this.bt.getTag());
    localIntent.putExtra("max_word_count", 30);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 1);
  }
  
  public void dzo()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().b(this.k);
  }
  
  protected int getContentLayoutId()
  {
    return 2131561474;
  }
  
  Intent h(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = acbn.SDCARD_PATH + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", acfp.m(2131708899));
    localIntent.putExtra("FROM_WHERE", "FROM_NEARBY_PROFILE");
    return localIntent;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
            if (this.bt != null)
            {
              a(this.bt, paramIntent);
              this.bt.setTag(paramIntent);
              return;
              if ((paramInt2 == -1) && (paramIntent != null))
              {
                Object localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mAlbumId = paramIntent.getStringExtra("key_album_id");
                if (!aqmr.isEmpty((String)localObject1))
                {
                  paramInt1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode;
                  paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                  if ((paramInt1 == 1) && (this.yi.size() < NearbyPeopleProfileActivity.dmr))
                  {
                    paramIntent = h((String)localObject1);
                    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramIntent);
                    return;
                    if (paramIntent != null)
                    {
                      paramIntent = paramIntent.getExtras();
                      paramIntent.getString("video_id");
                      paramIntent.getInt("head_id");
                      return;
                      if ((paramInt2 == -1) && (this.bp != null))
                      {
                        localObject1 = paramIntent.getStringExtra("param_name");
                        paramInt1 = paramIntent.getIntExtra("param_id", -1);
                        Object localObject2 = paramIntent.getStringExtra("param_tag");
                        paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
                        if ((localObject2 != null) && (((String)localObject2).length() > 0) && (paramInt2 > 0))
                        {
                          this.VS.setText((CharSequence)localObject2);
                          this.VS.setBackgroundResource(paramInt2);
                          this.VS.setVisibility(0);
                        }
                        for (;;)
                        {
                          this.bp.setText((CharSequence)localObject1);
                          this.bp.setTag(Integer.valueOf(paramInt1));
                          return;
                          this.VS.setVisibility(8);
                        }
                        if (paramInt2 == -1)
                        {
                          localObject2 = paramIntent.getStringArrayExtra("param_location");
                          try
                          {
                            paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f.d((String[])localObject2);
                            if (paramIntent != null)
                            {
                              localObject1 = paramIntent;
                              if (!paramIntent.equals("不限")) {}
                            }
                            else
                            {
                              localObject1 = "";
                            }
                            if (this.bs != null)
                            {
                              this.bs.setText((CharSequence)localObject1);
                              this.bs.setTag(localObject2);
                              return;
                            }
                          }
                          catch (Exception paramIntent)
                          {
                            for (;;)
                            {
                              paramIntent = null;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (paramInt2 != -1);
      paramIntent = paramIntent.getParcelableArrayListExtra("intent_param_pic_infos");
    } while ((paramIntent == null) || (paramIntent.size() == 0));
    this.jF.removeAllViews();
    paramInt1 = 0;
    while (paramInt1 < paramIntent.size())
    {
      this.jF.addView(a((PicInfo)paramIntent.get(paramInt1), null));
      paramInt1 += 1;
    }
    dBg();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    int m;
    if ((paramView.getId() == 2131367943) || (paramView == this.bn))
    {
      localObject1 = ausj.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = (DispatchActionMoveScrollView)((ausj)localObject1).findViewById(2131362014);
      ((DispatchActionMoveScrollView)localObject2).cZW = true;
      ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
      localObject2 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561390, null);
      ((IphonePickerView)localObject2).a(this.d);
      if (this.bn.getTag() != null)
      {
        m = ((Byte)this.bn.getTag()).byteValue();
        if (m >= 0)
        {
          j = m;
          if (m <= 1) {}
        }
        else
        {
          j = 0;
        }
        ((IphonePickerView)localObject2).setSelection(0, j);
        ((IphonePickerView)localObject2).setPickListener(new akgn(this, (IphonePickerView)localObject2, (ausj)localObject1));
        ((ausj)localObject1).a(new akha(this));
        ((ausj)localObject1).setActionContentView((View)localObject2, null);
        ((ausj)localObject1).show();
        o(paramView, ((ausj)localObject1).getActionContentView());
        c(this.bn, false);
      }
    }
    Object localObject3;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((paramView.getId() == 2131369978) || (paramView == this.bp))
        {
          dBo();
        }
        else if (paramView == this.jI)
        {
          localObject1 = this.VT.getText().toString();
          localObject1 = aurr.addParameter(aurr.addParameter(aurr.addParameter(aurr.addParameter("https://qun.qq.com/qqweb/m/nearby/pages/school_edit.html", "_bid", "2473"), "_wv", "1031"), "schoolName", (String)localObject1), "isValid", String.valueOf(this.dmB));
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        }
        else if ((paramView.getId() == 2131368578) || (paramView == this.bs))
        {
          dBc();
        }
        else
        {
          if ((paramView.getId() != 2131382395) && (paramView != this.bt)) {
            break;
          }
          dBp();
        }
      }
      if ((paramView.getId() != 2131362335) && (paramView != this.bo)) {
        break;
      }
      localObject1 = ausj.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = Calendar.getInstance();
      this.mCurrentYear = ((Calendar)localObject2).get(1);
      localObject3 = (DispatchActionMoveScrollView)((ausj)localObject1).findViewById(2131362014);
      ((DispatchActionMoveScrollView)localObject3).cZW = true;
      ((DispatchActionMoveScrollView)localObject3).setBackgroundResource(17170445);
      localObject3 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561390, null);
      ((IphonePickerView)localObject3).a(this.b);
    } while (this.bo.getTag() == null);
    int j = ((Integer)((Object[])(Object[])this.bo.getTag())[0]).intValue();
    int n;
    if (j == 0)
    {
      m = 0;
      n = 94;
    }
    for (j = 0;; j = (j & 0xFF) - 1)
    {
      ((Calendar)localObject2).setTimeInMillis(System.currentTimeMillis());
      this.mCurrentYear = ((Calendar)localObject2).get(1);
      this.yE = (((Calendar)localObject2).get(2) + 1);
      this.yF = ((Calendar)localObject2).get(5);
      ((IphonePickerView)localObject3).setPickListener(new akhb(this, (IphonePickerView)localObject3, (ausj)localObject1));
      ((IphonePickerView)localObject3).setSelection(0, n);
      ((IphonePickerView)localObject3).setSelection(1, m);
      ((IphonePickerView)localObject3).setSelection(2, j);
      ((ausj)localObject1).a(new akhc(this));
      ((ausj)localObject1).setActionContentView((View)localObject3, null);
      ((ausj)localObject1).show();
      o(paramView, ((ausj)localObject1).getActionContentView());
      c(this.bo, false);
      break;
      n = (j >>> 16) - 1896;
      m = ((0xFF00 & j) >>> 8) - 1;
    }
    if (paramView == this.bv)
    {
      if (ajrm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)) {
        break label882;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.bSZ)))
      {
        ajrm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, null, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.videoUrl, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.bSZ, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode, true);
        j = 1;
      }
    }
    for (;;)
    {
      ajrm.k("clk_video_entry", new String[] { "" + j, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "1" });
      break;
      ajrm.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 2);
      j = 2;
      continue;
      if (((paramView.getId() != 2131363191) && (paramView != this.bw)) || (this.yi == null)) {
        break;
      }
      RO(this.yi.size());
      break;
      label882:
      j = 2;
    }
  }
  
  @TargetApi(11)
  class a
    implements View.OnDragListener
  {
    private int width;
    
    public a(int paramInt)
    {
      this.width = paramInt;
    }
    
    public boolean onDrag(View paramView, DragEvent paramDragEvent)
    {
      switch (paramDragEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        QLog.d("onDrag", 4, "ACTION_DRAG_STARTED");
      }
    }
  }
  
  @TargetApi(11)
  class b
    extends View.DragShadowBuilder
  {
    public int dmO = (int)(akgm.this.a.imageWidth * 1.4D);
    
    public b(View paramView)
    {
      super();
    }
    
    public void onDrawShadow(Canvas paramCanvas)
    {
      getView().setDrawingCacheEnabled(false);
      getView().setDrawingCacheEnabled(true);
      Object localObject = new Paint();
      ((Paint)localObject).setShadowLayer(10.0F, 0.0F, 0.0F, -16777216);
      paramCanvas.drawRect(new Rect(10, 10, this.dmO + 10, this.dmO + 10), (Paint)localObject);
      localObject = getView().getDrawingCache();
      Matrix localMatrix = new Matrix();
      float f = this.dmO / ((Bitmap)localObject).getWidth();
      localMatrix.postScale(f, f);
      paramCanvas.drawBitmap(Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true), 10.0F, 10.0F, null);
    }
    
    public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
    {
      int i = this.dmO + 20;
      int j = this.dmO + 20;
      paramPoint1.set(i, j);
      paramPoint2.set(i / 2, j / 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgm
 * JD-Core Version:    0.7.0.1
 */