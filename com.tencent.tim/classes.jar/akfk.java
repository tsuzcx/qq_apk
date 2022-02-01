import android.animation.LayoutTransition;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.12;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.22;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.23;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.26;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.OnPicDragListener.1;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class akfk
  extends akfj
  implements View.OnClickListener
{
  static final int[] mb = { 2131377653, 2131377649, 2131377648, 2131377654, 2131377651, 2131377652, 2131377650 };
  View Fg;
  TextView VO;
  TextView VP;
  TextView VQ;
  TextView VR;
  TextView VS;
  TextView VT;
  TextView VU;
  public TextView VV;
  public LinkedList<PicInfo> W = new LinkedList();
  akby jdField_a_of_type_Akby;
  private akfk.a jdField_a_of_type_Akfk$a;
  NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  public NearbyPeopleProfileActivity a;
  public BounceScrollView a;
  public final ajuu[] a;
  private IphonePickerView.d b = new akfs(this);
  String bTo = "";
  EditText bm;
  EditText bn;
  EditText bo;
  EditText bp;
  EditText br;
  EditText bs;
  EditText jdField_bt_of_type_AndroidWidgetEditText;
  FormSwitchItem jdField_bt_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  EditText bu;
  private IphonePickerView.d jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d = new akft(this);
  private PicInfo jdField_c_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  private boolean csm;
  private IphonePickerView.d d = new akgd(this);
  private int dmB;
  int dmN;
  HorizontalScrollView f;
  Button gU;
  private View.OnLongClickListener jdField_i_of_type_AndroidViewView$OnLongClickListener = new akgc(this);
  ImmersiveTitleBar2 jdField_i_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  LinearLayout jF;
  LinearLayout jG;
  LinearLayout jH;
  LinearLayout jI;
  LinearLayout jJ;
  private aook k = new akgb(this);
  RelativeLayout lp;
  private RelativeLayout lq;
  int mCurrentYear = 2015;
  int mHorizontalSpacing;
  int yE;
  int yF;
  int yG;
  int yH;
  int yI;
  final ArrayList<PicInfo> yi = new ArrayList(13);
  final ArrayList<PicInfo> yj = new ArrayList(13);
  
  public akfk(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_Akfk$a = new akfk.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth);
    }
    this.mHorizontalSpacing = rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2.0F);
    int m = akby.lX.length - 1;
    this.jdField_a_of_type_ArrayOfAjuu = new ajuu[m];
    int j = 0;
    while (j < m)
    {
      this.jdField_a_of_type_ArrayOfAjuu[j] = new ajuu(akby.lX[j]);
      j += 1;
    }
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
    a((CustomImgView)localObject, paramPicInfo, paramDrawable);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localRelativeLayout.setOnLongClickListener(this.jdField_i_of_type_AndroidViewView$OnLongClickListener);
      localRelativeLayout.setOnDragListener(this.jdField_a_of_type_Akfk$a);
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
  
  private void a(PicInfo paramPicInfo, View paramView)
  {
    if (this.yi.size() > 1)
    {
      this.yi.remove(paramPicInfo);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.remove(paramPicInfo);
      this.jF.removeView(paramView);
      dBg();
      dBi();
      return;
    }
    paramPicInfo = aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, acfp.m(2131708882), 0, 0, null, null);
    paramPicInfo.setPositiveButton(2131721079, new akgl(this, paramPicInfo));
    paramPicInfo.show();
  }
  
  private void a(CustomImgView paramCustomImgView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "setDrawable, pos:" + this.jF.indexOfChild(paramCustomImgView) + ",picInfo:" + paramPicInfo);
    }
    paramCustomImgView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846612);
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
        paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo, localURLDrawableOptions));
        return;
      }
      paramDrawable = null;
      if (TextUtils.isEmpty(paramPicInfo.thumbUrl)) {
        break label258;
      }
      paramDrawable = paramPicInfo.thumbUrl;
    }
    catch (MalformedURLException paramCustomImgView)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      while (QLog.isColorLevel())
      {
        paramPicInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        QLog.d("Q.nearby_people_card.", 2, "GridAdapter.getView() new URL(). " + paramCustomImgView.getMessage(), paramCustomImgView);
        return;
        if (!TextUtils.isEmpty(paramPicInfo.bSZ)) {
          paramDrawable = paramPicInfo.bSZ;
        }
      }
    }
    if (!TextUtils.isEmpty(paramDrawable))
    {
      paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(aomc.l(paramDrawable), localURLDrawableOptions));
      return;
    }
    label258:
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
      if (((PicInfo)this.yi.get(j)).photoId != ((PicInfo)this.yj.get(j)).photoId) {
        return true;
      }
      j += 1;
    }
    return false;
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(acfp.m(2131708820));
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(acfp.m(2131708833));
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
    ((TextView)localObject).setText(acfp.m(2131708901));
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
  
  private void dBe()
  {
    ausj localausj = ausj.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    Object localObject = (DispatchActionMoveScrollView)localausj.findViewById(2131362014);
    ((DispatchActionMoveScrollView)localObject).cZW = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    localObject = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561390, null);
    ((IphonePickerView)localObject).a(this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d);
    if (this.bu.getTag() != null)
    {
      int m = (byte)(((Byte)this.bu.getTag()).byteValue() - 1);
      int j;
      if (m >= 0)
      {
        j = m;
        if (m <= 3) {}
      }
      else
      {
        j = 0;
      }
      ((IphonePickerView)localObject).setSelection(0, j);
      ((IphonePickerView)localObject).setPickListener(new akgg(this, (IphonePickerView)localObject, localausj));
      localausj.a(new akgh(this));
      localausj.setActionContentView((View)localObject, null);
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing()) {}
    }
    else
    {
      return;
    }
    localausj.show();
    o(this.jJ, localausj.getActionContentView());
    c(this.bu, true);
  }
  
  private void dBg()
  {
    dBh();
    int j = 0;
    if (j < this.jF.getChildCount())
    {
      Object localObject;
      if ((this.jF.getChildAt(j) instanceof RelativeLayout))
      {
        localObject = (RelativeLayout)this.jF.getChildAt(j);
        ((RelativeLayout)localObject).setOnClickListener(e(j));
        if (((RelativeLayout)localObject).getChildCount() == 2) {
          if (j == 0)
          {
            ((RelativeLayout)localObject).getChildAt(1).setVisibility(0);
            label73:
            if (this.jF.getChildAt(j) != null) {
              this.jF.getChildAt(j).setContentDescription(acfp.m(2131708811) + (j + 1));
            }
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        ((RelativeLayout)localObject).getChildAt(1).setVisibility(8);
        break label73;
        if (QLog.isColorLevel())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
          QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, headItem's child count is not 2");
          continue;
          if (QLog.isColorLevel())
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
            QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, the child of mEditLayout is not a instance of RelativeLayout");
          }
        }
      }
    }
    if (this.yi.size() <= 0) {
      this.jG.setVisibility(8);
    }
    for (;;)
    {
      this.VQ.setText(this.yi.size() + "/" + NearbyPeopleProfileActivity.dmr);
      return;
      this.jG.setVisibility(0);
    }
  }
  
  private void dBh()
  {
    this.yi.clear();
    int j = 0;
    while (j < this.jF.getChildCount())
    {
      this.yi.add((PicInfo)this.jF.getChildAt(j).getTag());
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "reorganizePicInfo:" + this.yi);
    }
  }
  
  private void dBi()
  {
    anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "del_pho", 0, 0, "", "", "", "");
  }
  
  private void dBj()
  {
    anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "up_gif", 0, 0, "", "", "", "");
  }
  
  private void dBk()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696258, new Object[] { this.bTo });
      localObject = aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
      ((aqju)localObject).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696744), new akgk(this, (aqju)localObject));
      ((aqju)localObject).show();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) && (QLog.isColorLevel())) {
        QLog.d("NearbyProfileEditPanel", 2, "mcard is null");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dAC();
    }
  }
  
  private void dBl()
  {
    this.VO.setText(acfp.m(2131708840));
    this.VO.setVisibility(0);
    this.VP.setText(acfp.m(2131708801));
    this.VP.setTextSize(2, 10.0F);
    this.VP.setVisibility(0);
    this.VO.setOnClickListener(null);
    this.VP.setOnClickListener(null);
    this.VP.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.Fg.findViewById(2131369579).setVisibility(8);
    TextView localTextView = (TextView)this.Fg.findViewById(2131369581);
    localTextView.setVisibility(0);
    localTextView.setText(2131721058);
    localTextView.setOnClickListener(new akfu(this));
    localTextView = (TextView)this.Fg.findViewById(2131369612);
    localTextView.setVisibility(0);
    localTextView.setText(2131721066);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new akfw(this));
    this.Fg.findViewById(2131377361).setOnClickListener(this);
  }
  
  private View.OnClickListener e(int paramInt)
  {
    return new akgi(this, paramInt);
  }
  
  private void o(View paramView1, View paramView2)
  {
    paramView2.postDelayed(new NearbyProfileEditPanel.26(this, paramView2, paramView1), 300L);
  }
  
  private void uM()
  {
    if (this.W.size() > 0)
    {
      Object localObject = new StringBuilder(acfp.m(2131708829));
      ((StringBuilder)localObject).append(this.dmN - this.W.size() + 1).append("/").append(this.dmN).append(")...");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dN(((StringBuilder)localObject).toString());
      localObject = new NearbyProfileEditPanel.22(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute((Runnable)localObject);
      return;
    }
    dBn();
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
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", NearbyPeopleProfileActivity.dmr - paramInt);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = acbn.SDCARD_PATH + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("enter_from", 30);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
    aqfy.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, true);
    anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  public boolean a(PicInfo paramPicInfo)
  {
    this.jF.addView(a(paramPicInfo, null), this.jF.getChildCount());
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
    if (arM()) {
      return true;
    }
    int j;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_bt_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!aqft.equalsWithNullCheck(this.bm.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
      if ((this.bu.getTag() != null) && (((Byte)this.bu.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus)) {
        return true;
      }
      if (((Byte)this.bn.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.bo.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        return true;
      }
      if (((Integer)this.bp.getTag()).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job) {
        return true;
      }
      if (!aqmr.trim(this.br.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
        return true;
      }
      if (!aqmr.trim(this.VT.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
        return true;
      }
      if (!Arrays.equals((String[])this.bs.getTag(), new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict })) {
        return true;
      }
      boolean bool2 = this.jdField_bt_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible == 0L) {}
      for (boolean bool1 = true; bool2 != bool1; bool1 = false) {
        return true;
      }
      Object localObject2 = this.jdField_a_of_type_ArrayOfAjuu;
      int n = localObject2.length;
      m = 0;
      j = 0;
      if (m >= n) {
        break label561;
      }
      StringBuilder localStringBuilder = localObject2[m];
      if (localStringBuilder == null) {}
      do
      {
        m += 1;
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(localStringBuilder.tagType);
      } while ((localObject1 == null) && (localStringBuilder.tagInfos.size() == 0));
      if (!localStringBuilder.equals(localObject1))
      {
        j = 1;
        label440:
        if (j == 0) {
          break label558;
        }
        m = j;
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          localStringBuilder = ((StringBuilder)localObject2).append("tagChanged \n").append("item: ").append(localStringBuilder.toString()).append("\n").append("tag: ");
          if (localObject1 != null) {
            break label546;
          }
          localObject1 = "null";
          label507:
          localStringBuilder.append((String)localObject1).append("\n");
          QLog.i("InterestTag", 4, ((StringBuilder)localObject2).toString());
        }
      }
    }
    label546:
    label558:
    label561:
    for (int m = j;; m = j)
    {
      if (m != 0)
      {
        return true;
        j = 0;
        break label440;
        localObject1 = ((ajuu)localObject1).toString();
        break label507;
      }
      return false;
      break;
    }
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
  
  public boolean arN()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crv) {
      return true;
    }
    if (arM()) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_bt_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!aqft.equalsWithNullCheck(this.bm.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
    }
    return false;
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    Object localObject;
    int j;
    label268:
    label295:
    label587:
    label733:
    boolean bool;
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
        break label1208;
      }
      this.bTo = acfp.m(2131708830);
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
        break label1232;
      }
      this.VR.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696224));
      this.gU.setContentDescription(acfp.m(2131708794));
      this.gU.setOnClickListener(new akfm(this));
      dBf();
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
      this.VS.setText(aqek.fZ(j));
      if (!aqmr.isEmpty(aqek.fZ(j))) {
        break label1276;
      }
      this.VS.setVisibility(8);
      this.bp.setText(aqek.ga(j));
      this.bp.setTag(Integer.valueOf(j));
      this.br.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
      this.br.clearFocus();
      paramNearbyPeopleCard = (String)ajrb.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_name", "");
      if (!this.csm)
      {
        this.VT.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        if (!TextUtils.equals(paramNearbyPeopleCard, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
          break label1310;
        }
        this.dmB = ((Integer)ajrb.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(0))).intValue();
        if (this.dmB != 2) {
          break label1298;
        }
        this.VU.setVisibility(0);
      }
      this.jI.setOnClickListener(this);
      dBd();
      a(this.jdField_bt_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.jdField_bt_of_type_AndroidWidgetEditText.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.bu.setText(aqek.fW(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
      this.bu.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus));
      if (aqek.y(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo) == 0) {
        break label1439;
      }
      this.jdField_bt_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
        break label1433;
      }
      bool = true;
      label846:
      this.jdField_bt_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696259, new Object[] { this.bTo });
        paramNearbyPeopleCard = aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramNearbyPeopleCard, 0, 0, null, null);
        paramNearbyPeopleCard.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696744), new akfn(this, paramNearbyPeopleCard));
        paramNearbyPeopleCard.show();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfAjuu);
      this.jdField_a_of_type_Akby.a(this.jdField_a_of_type_ArrayOfAjuu);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crB) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmw == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.postDelayed(new NearbyProfileEditPanel.12(this), 300L);
      }
      this.Fg.findViewById(2131382395).setOnClickListener(this);
      this.jdField_bt_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.Fg.findViewById(2131378722).setOnClickListener(this);
      this.bu.setOnClickListener(this);
      this.Fg.findViewById(2131367943).setOnClickListener(this);
      this.bn.setOnClickListener(this);
      this.Fg.findViewById(2131362335).setOnClickListener(this);
      this.bo.setOnClickListener(this);
      this.Fg.findViewById(2131369978).setOnClickListener(this);
      this.bp.setOnClickListener(this);
      this.Fg.findViewById(2131368578).setOnClickListener(this);
      this.bs.setOnClickListener(this);
      this.bm.addTextChangedListener(new akfo(this));
      this.jdField_bt_of_type_AndroidWidgetEditText.addTextChangedListener(new akfp(this));
      this.br.addTextChangedListener(new akfq(this));
      this.bm.getViewTreeObserver().addOnGlobalLayoutListener(new akfr(this));
      return;
      localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.size());
      break;
      label1208:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label268;
      }
      this.bTo = acfp.m(2131708885);
      break label268;
      label1232:
      if (this.yi.size() <= NearbyPeopleProfileActivity.dmq) {
        break label295;
      }
      this.VR.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131696225, new Object[] { this.bTo }));
      break label295;
      label1276:
      this.VS.setBackgroundResource(aqek.jV(j));
      this.VS.setVisibility(0);
      break label587;
      label1298:
      this.VU.setVisibility(8);
      break label733;
      label1310:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.collegeId == 0L) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
        {
          this.VU.setVisibility(8);
          this.dmB = 1;
        }
      }
      for (;;)
      {
        ajrb.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_name", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        ajrb.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.dmB));
        break;
        this.VU.setVisibility(0);
        this.dmB = 2;
        continue;
        this.VU.setVisibility(8);
        this.dmB = 1;
      }
      label1433:
      bool = false;
      break label846;
      label1439:
      this.jdField_bt_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
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
    this.lp = ((RelativeLayout)paramView.findViewById(2131366248));
    this.lp.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167363));
    this.f = ((HorizontalScrollView)paramView.findViewById(2131366249));
    this.jF = ((LinearLayout)paramView.findViewById(2131366229));
    this.jF.getLayoutParams().height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
    this.jF.setLayoutParams(this.jF.getLayoutParams());
    this.VQ = ((TextView)paramView.findViewById(2131373111));
    this.VR = ((TextView)paramView.findViewById(2131378920));
    this.gU = ((Button)paramView.findViewById(2131366246));
    this.jG = ((LinearLayout)paramView.findViewById(2131366247));
    this.jJ = ((LinearLayout)paramView.findViewById(2131378722));
    this.bm = ((EditText)paramView.findViewById(2131372384));
    this.bn = ((EditText)paramView.findViewById(2131367940));
    this.bo = ((EditText)paramView.findViewById(2131362333));
    this.VS = ((TextView)paramView.findViewById(2131364333));
    this.bp = ((EditText)paramView.findViewById(2131369977));
    this.jH = ((LinearLayout)paramView.findViewById(2131369978));
    this.br = ((EditText)paramView.findViewById(2131365108));
    this.jI = ((LinearLayout)paramView.findViewById(2131364873));
    this.VT = ((TextView)paramView.findViewById(2131364872));
    this.VU = ((TextView)paramView.findViewById(2131364356));
    this.bs = ((EditText)paramView.findViewById(2131368577));
    this.jdField_bt_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131382394));
    this.bu = ((EditText)paramView.findViewById(2131378717));
    this.jdField_bt_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131367351));
    this.jdField_bt_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.VV = ((TextView)paramView.findViewById(2131377647));
    this.jdField_i_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131379866));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.Fg.findViewById(2131366254));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    paramView = (LinearLayout)this.Fg.findViewById(2131370115);
    this.jdField_a_of_type_Akby = new akby();
    this.jdField_a_of_type_Akby.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView);
    dBl();
  }
  
  public void dBb()
  {
    this.f.fullScroll(66);
  }
  
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
  
  @TargetApi(11)
  void dBf()
  {
    int j = 0;
    if (this.isEditing) {}
    do
    {
      return;
      this.isEditing = true;
    } while (this.yi.size() == 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.oldPhotoCount > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age >= 14) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age <= 24) && (this.yi.size() <= 1)) {
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481B", "0X800481B", 0, 0, "", "", "", "");
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      LayoutTransition localLayoutTransition = new LayoutTransition();
      localLayoutTransition.setAnimator(2, null);
      if (Build.VERSION.SDK_INT <= 15)
      {
        localLayoutTransition.setAnimator(0, null);
        localLayoutTransition.setAnimator(1, null);
        localLayoutTransition.setAnimator(3, null);
      }
      this.jF.setLayoutTransition(localLayoutTransition);
    }
    this.jF.removeAllViews();
    while (j < this.yi.size())
    {
      this.jF.addView(a((PicInfo)this.yi.get(j), null));
      j += 1;
    }
    dBg();
  }
  
  void dBm()
  {
    anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004823", "0X8004823", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dN(acfp.m(2131708877));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.yi);
    if (arM())
    {
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 1) {
        break label1305;
      }
    }
    label1158:
    label1288:
    label1305:
    for (int j = 1;; j = 3)
    {
      Object localObject;
      boolean bool1;
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
          byte[] arrayOfByte = (byte[])this.jdField_bt_of_type_AndroidWidgetEditText.getTag();
          localObject = arrayOfByte;
          if (arrayOfByte == null) {
            localObject = new byte[0];
          }
          localBundle.putByteArray("key_xuan_yan", (byte[])localObject);
          if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_bt_of_type_AndroidWidgetEditText.getTag()))
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
          if ((this.bu.getTag() != null) && (((Byte)this.bu.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus))
          {
            localBundle.putByte("key_marital_status", ((Byte)this.bu.getTag()).byteValue());
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 3, 0, "", "", "", "");
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
          j = ((Integer)this.bp.getTag()).intValue();
          if (j != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job)
          {
            localBundle.putInt("profession", j);
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 6, 0, "", "", "", "");
          }
          localObject = this.br.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
          {
            localBundle.putString("company", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crw = true;
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 7, 0, "", "", "", "");
          }
          localObject = this.VT.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
          {
            localBundle.putString("college", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crw = true;
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 8, 0, "", "", "", "");
          }
          localObject = (String[])this.bs.getTag();
          if (!Arrays.equals((Object[])localObject, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict }))
          {
            localBundle.putStringArray("hometown", (String[])localObject);
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 9, 0, "", "", "", "");
          }
          boolean bool2 = this.jdField_bt_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
            break label1242;
          }
          bool1 = true;
          label1097:
          if (bool2 != bool1)
          {
            if (!bool2) {
              break label1247;
            }
            j = 0;
            label1110:
            localBundle.putShort("key_flower_visible_switch", (short)j);
            if (!bool2) {
              break label1252;
            }
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BB", "0X80060BB", 0, 0, "", "", "", "");
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.update_profile", 2, "Q.nearby_people_card..saveNearbyProfileCard, modified_data = " + localBundle.toString());
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c;
        if (localObject == null) {
          break label1288;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileEditPanel.23(this, (ajrs)localObject, localBundle, localArrayList));
      }
      label1242:
      label1247:
      label1252:
      while (!QLog.isDevelopLevel())
      {
        return;
        localObject = "2";
        break;
        bool1 = false;
        break label1097;
        j = 1;
        break label1110;
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BC", "0X80060BC", 0, 0, "", "", "", "");
        break label1158;
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
    localIntent.putExtra("param_old_xuan_yan", (byte[])this.jdField_bt_of_type_AndroidWidgetEditText.getTag());
    localIntent.putExtra("max_word_count", 30);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 1);
  }
  
  public void dzo()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().b(this.k);
  }
  
  protected int getContentLayoutId()
  {
    return 2131561473;
  }
  
  Intent h(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = acbn.SDCARD_PATH + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", acfp.m(2131708834));
    localIntent.putExtra("FROM_WHERE", "FROM_NEARBY_PROFILE");
    return localIntent;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    switch (paramInt1)
    {
    }
    label406:
    label413:
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
            if (this.jdField_bt_of_type_AndroidWidgetEditText != null)
            {
              a(this.jdField_bt_of_type_AndroidWidgetEditText, paramIntent);
              this.jdField_bt_of_type_AndroidWidgetEditText.setTag(paramIntent);
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
                      if ((paramInt2 == -1) && (paramIntent != null))
                      {
                        Object localObject2;
                        for (;;)
                        {
                          try
                          {
                            localObject2 = paramIntent.getParcelableArrayListExtra("choosed_interest_tags");
                            paramInt2 = paramIntent.getIntExtra("interest_tag_type", -1);
                            paramInt1 = j;
                            if (paramInt1 < this.jdField_a_of_type_ArrayOfAjuu.length)
                            {
                              if (this.jdField_a_of_type_ArrayOfAjuu[paramInt1].tagType != paramInt2) {
                                break label406;
                              }
                              paramIntent = this.jdField_a_of_type_ArrayOfAjuu[paramInt1];
                              paramIntent.tagInfos.clear();
                              if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
                                paramIntent.tagInfos.addAll((Collection)localObject2);
                              }
                            }
                            this.jdField_a_of_type_Akby.a(this.jdField_a_of_type_ArrayOfAjuu);
                            if (!QLog.isDevelopLevel()) {
                              break;
                            }
                            localObject1 = new StringBuilder().append("doOnActivity result code :11 ");
                            if (localObject2 != null) {
                              break label413;
                            }
                            paramIntent = "";
                            QLog.i("Q.nearby_people_card.", 4, paramIntent + " " + paramInt2);
                            return;
                          }
                          catch (Exception paramIntent) {}
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          QLog.i("Q.nearby_people_card.", 2, paramIntent.getMessage());
                          return;
                          paramInt1 += 1;
                          continue;
                          paramIntent = localObject2.toString();
                        }
                        if ((paramInt2 == -1) && (this.bp != null))
                        {
                          localObject1 = paramIntent.getStringExtra("param_name");
                          paramInt1 = paramIntent.getIntExtra("param_id", -1);
                          localObject2 = paramIntent.getStringExtra("param_tag");
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
        ((IphonePickerView)localObject2).setPickListener(new akfl(this, (IphonePickerView)localObject2, (ausj)localObject1));
        ((ausj)localObject1).a(new akfv(this));
        ((ausj)localObject1).setActionContentView((View)localObject2, null);
        ((ausj)localObject1).show();
        o(paramView, ((ausj)localObject1).getActionContentView());
        c(this.bn, true);
      }
    }
    Object localObject3;
    do
    {
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
          else if ((paramView.getId() == 2131382395) || (paramView == this.jdField_bt_of_type_AndroidWidgetEditText))
          {
            dBp();
          }
          else
          {
            if ((paramView.getId() != 2131378722) && (paramView != this.bu)) {
              break;
            }
            dBe();
          }
        }
      } while ((paramView.getId() != 2131362335) && (paramView != this.bo));
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
      ((IphonePickerView)localObject3).setPickListener(new akge(this, (IphonePickerView)localObject3, (ausj)localObject1));
      ((IphonePickerView)localObject3).setSelection(0, n);
      ((IphonePickerView)localObject3).setSelection(1, m);
      ((IphonePickerView)localObject3).setSelection(2, j);
      ((ausj)localObject1).a(new akgf(this));
      ((ausj)localObject1).setActionContentView((View)localObject3, null);
      ((ausj)localObject1).show();
      o(paramView, ((ausj)localObject1).getActionContentView());
      c(this.bo, true);
      break;
      n = (j >>> 16) - 1896;
      m = ((0xFF00 & j) >>> 8) - 1;
    }
  }
  
  @TargetApi(11)
  public class a
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
        continue;
        RelativeLayout localRelativeLayout = akfk.a(akfk.this);
        int i = akfk.this.jF.indexOfChild(paramView);
        int j = akfk.this.jF.indexOfChild(localRelativeLayout);
        if ((i != -1) && (j != -1) && (((i > j) && (paramDragEvent.getX() > this.width / 2)) || ((i < j) && (paramDragEvent.getX() < this.width / 2))))
        {
          try
          {
            akfk.this.jF.removeView(localRelativeLayout);
            akfk.this.jF.addView(localRelativeLayout, i);
            akfk.e(akfk.this);
          }
          catch (Exception paramView) {}
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.", 2, "drag between small pics exception" + paramView.getMessage());
            continue;
            akfk.this.jF.post(new NearbyProfileEditPanel.OnPicDragListener.1(this));
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  class b
    extends View.DragShadowBuilder
  {
    public int dmO = (int)(akfk.this.a.imageWidth * 1.4D);
    
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
 * Qualified Name:     akfk
 * JD-Core Version:    0.7.0.1
 */