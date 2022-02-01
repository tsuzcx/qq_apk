import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XPanelContainer;

public class dg
  extends db
{
  private View.OnClickListener e = new dh(this);
  private View.OnClickListener g = new di(this);
  
  public dg(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramDataLineMsgSetList, paramLiteActivity, paramQQAppInterface);
  }
  
  private void a(View paramView, dl paramdl)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131372911);
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setImageResource(2130838370);
    localImageView.setId(2131364522);
    paramdl.a().B = localImageView;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramView.addView(localImageView, localLayoutParams);
    localImageView.setVisibility(8);
    localImageView.setContentDescription(this.mContext.getString(2131693507));
    localImageView = new ImageView(this.mContext);
    localImageView.setImageResource(2130838365);
    localImageView.setId(2131364509);
    paramdl.a().C = localImageView;
    paramdl = new RelativeLayout.LayoutParams(-2, -2);
    paramdl.addRule(13);
    paramView.addView(localImageView, paramdl);
    localImageView.setVisibility(8);
    localImageView.setContentDescription(this.mContext.getString(2131694144));
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, dl paramdl)
  {
    String str = "";
    if (paramDataLineMsgRecord.isSendFromLocal()) {
      if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc)) {
        str = " / " + this.mContext.getString(2131693599);
      }
    }
    while (!TextUtils.isEmpty(str))
    {
      paramdl.a().V.setVisibility(0);
      paramdl.a().V.setText(str);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L) {
        str = " / " + this.mContext.getString(2131695427);
      } else if (paramDataLineMsgRecord.bIsTransfering) {
        str = "";
      } else if (!paramDataLineMsgRecord.issuc) {
        if ((paramDataLineMsgRecord.bIsSended) || (paramDataLineMsgRecord.nOpType == 1))
        {
          str = " / " + this.mContext.getString(2131693597);
        }
        else
        {
          str = " / " + this.mContext.getString(2131693598);
          continue;
          if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc)) {
            str = " / " + this.mContext.getString(2131693591);
          } else if (paramDataLineMsgRecord.fileMsgStatus == 2L) {
            str = " / " + this.mContext.getString(2131695427);
          } else if (paramDataLineMsgRecord.bIsTransfering) {
            str = "";
          } else if (!paramDataLineMsgRecord.issuc) {
            str = " / " + this.mContext.getString(2131693597);
          }
        }
      }
    }
    paramdl.a().V.setVisibility(8);
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet, dl paramdl)
  {
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      paramdl.o.setBackgroundResource(2130851006);
      return;
    }
    paramdl.o.setBackgroundResource(2130850829);
  }
  
  private boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) && (ahbj.isFileExists(paramDataLineMsgRecord.path));
  }
  
  private void b(View paramView, dl paramdl)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131372911);
    CircleFileStateView localCircleFileStateView = new CircleFileStateView(this.mContext);
    localCircleFileStateView.setId(2131364507);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(2);
    paramdl.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = localCircleFileStateView;
    int i = wja.dp2px(24.0F, this.mContext.getResources());
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
    localCircleFileStateView.setContentDescription(this.mContext.getString(2131693592));
    localCircleFileStateView = new CircleFileStateView(this.mContext);
    localCircleFileStateView.setId(2131364508);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(1);
    paramdl.a().b = localCircleFileStateView;
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
    localCircleFileStateView.setContentDescription(this.mContext.getString(2131693840));
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord, dl paramdl)
  {
    if ((paramDataLineMsgRecord.progress == 1.0F) || (!paramDataLineMsgRecord.issuc) || (paramDataLineMsgRecord.fileMsgStatus == 1L) || (paramDataLineMsgRecord.fileMsgStatus == 2L))
    {
      paramdl.a().j.setVisibility(8);
      i = wja.dp2px(14.0F, this.mContext.getResources());
      j = wja.dp2px(18.0F, this.mContext.getResources());
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramdl.a().r.setPadding(i, i, j, i);
        return;
      }
      paramdl.a().r.setPadding(j, i, i, i);
      return;
    }
    int i = (int)(paramDataLineMsgRecord.progress * 100.0F);
    paramdl.a().j.setVisibility(0);
    paramdl.a().j.setProgress(i);
    paramdl.a().j.setContentDescription(this.mContext.getString(2131693638) + i);
    i = wja.dp2px(14.0F, this.mContext.getResources());
    int j = wja.dp2px(18.0F, this.mContext.getResources());
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramdl.a().r.setPadding(i, i, j, 0);
      return;
    }
    paramdl.a().r.setPadding(j, i, i, 0);
  }
  
  private void c(DataLineMsgRecord paramDataLineMsgRecord, dl paramdl)
  {
    ImageView localImageView1 = paramdl.a().B;
    ImageView localImageView2 = paramdl.a().C;
    if ((localImageView1 == null) || (localImageView2 == null)) {
      return;
    }
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
    }
    for (;;)
    {
      localImageView1.setTag(paramdl);
      localImageView2.setTag(paramdl);
      localImageView1.setOnClickListener(this.e);
      localImageView2.setOnClickListener(this.b.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(0);
      }
      else if (paramDataLineMsgRecord.bIsTransfering)
      {
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
      }
      else if (!paramDataLineMsgRecord.issuc)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(0);
      }
      else
      {
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
      }
    }
  }
  
  private void d(DataLineMsgRecord paramDataLineMsgRecord, dl paramdl)
  {
    CircleFileStateView localCircleFileStateView1 = paramdl.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    CircleFileStateView localCircleFileStateView2 = paramdl.a().b;
    if ((localCircleFileStateView1 == null) || (localCircleFileStateView2 == null)) {
      return;
    }
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
    {
      localCircleFileStateView1.setVisibility(8);
      localCircleFileStateView2.setVisibility(8);
    }
    for (;;)
    {
      localCircleFileStateView1.setTag(paramdl);
      localCircleFileStateView2.setTag(paramdl);
      localCircleFileStateView1.setOnClickListener(this.b.jdField_b_of_type_AndroidViewView$OnClickListener);
      localCircleFileStateView2.setOnClickListener(this.g);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.fileMsgStatus == 1L)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.bIsTransfering)
      {
        localCircleFileStateView1.setVisibility(8);
        localCircleFileStateView2.setVisibility(0);
      }
      else if (!paramDataLineMsgRecord.issuc)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else
      {
        localCircleFileStateView1.setVisibility(8);
        localCircleFileStateView2.setVisibility(0);
      }
    }
  }
  
  private void e(DataLineMsgRecord paramDataLineMsgRecord, dl paramdl)
  {
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc) && (!a(paramDataLineMsgRecord)))
    {
      CircleFileStateView localCircleFileStateView1 = paramdl.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      CircleFileStateView localCircleFileStateView2 = paramdl.a().b;
      localCircleFileStateView1.setVisibility(0);
      localCircleFileStateView1.setState(2);
      localCircleFileStateView2.setVisibility(8);
      if (!paramDataLineMsgRecord.isSendFromLocal()) {
        paramdl.a().V.setVisibility(8);
      }
      localCircleFileStateView1.setTag(paramdl);
      localCircleFileStateView2.setTag(paramdl);
      localCircleFileStateView1.setOnClickListener(this.b.jdField_b_of_type_AndroidViewView$OnClickListener);
      localCircleFileStateView2.setOnClickListener(this.g);
    }
  }
  
  private void e(dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramdl == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    Object localObject = paramDataLineMsgSet.filename;
    long l = paramDataLineMsgSet.filesize;
    a(paramdl.a().jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramDataLineMsgSet);
    paramdl.a().T.setText((CharSequence)localObject);
    paramdl.a().U.setText(ahbj.j(l, this.mContext.getResources().getDisplayMetrics().densityDpi));
    b(paramDataLineMsgSet, paramdl);
    a(paramDataLineMsgSet, paramdl);
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      localObject = paramdl.a().B;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramdl.a().C;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramdl.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      localObject = paramdl.a().b;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      if ((paramDataLineMsgSet.bIsSended) || (paramDataLineMsgSet.nOpType == 1)) {
        d(paramDataLineMsgSet, paramdl);
      }
    }
    for (;;)
    {
      e(paramDataLineMsgSet, paramdl);
      return;
      c(paramDataLineMsgSet, paramdl);
      continue;
      d(paramDataLineMsgSet, paramdl);
    }
  }
  
  protected View a(int paramInt, dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int i;
    if (paramInt == 17)
    {
      localObject1 = this.mInflater.inflate(2131559186, null);
      localObject3 = (ImageView)((View)localObject1).findViewById(2131368698);
      localObject2 = this.b.getResources().getDrawable(2130845074);
      i = DataLineMsgRecord.getDevTypeBySet(paramDataLineMsgSet);
      if (i == 0)
      {
        paramDataLineMsgSet = this.b.getResources().getDrawable(2130845074);
        ((ImageView)localObject3).setImageDrawable(paramDataLineMsgSet);
      }
    }
    for (paramDataLineMsgSet = (DataLineMsgSet)localObject1;; paramDataLineMsgSet = this.mInflater.inflate(2131559187, null))
    {
      paramdl.o = ((RelativeLayout)paramDataLineMsgSet.findViewById(2131372014));
      paramdl.o.setTag(paramdl);
      paramdl.o.setClickable(true);
      paramdl.o.setLongClickable(true);
      paramdl.o.setOnClickListener(this.mOnClickListener);
      paramdl.o.setOnLongClickListener(this.b.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      paramdl.o.setOnTouchListener(this.b.jdField_b_of_type_AndroidViewView$OnTouchListener);
      paramdl.o.setAddStatesFromChildren(true);
      paramdl.a((TextView)paramDataLineMsgSet.findViewById(2131365616));
      i = wja.dp2px(14.0F, this.mContext.getResources());
      int j = wja.dp2px(6.0F, this.mContext.getResources());
      localObject1 = new RelativeLayout(this.mContext);
      ((RelativeLayout)localObject1).setId(2131364503);
      localObject2 = this.mContext.getResources();
      ((RelativeLayout)localObject1).setPadding(((Resources)localObject2).getDimensionPixelSize(2131296404), ((Resources)localObject2).getDimensionPixelSize(2131296406), ((Resources)localObject2).getDimensionPixelSize(2131296403), ((Resources)localObject2).getDimensionPixelSize(2131296405));
      localObject3 = new RelativeLayout.LayoutParams(BaseChatItemLayout.bOh, -2);
      int k = ((Resources)localObject2).getDimensionPixelSize(2131299515);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131368698);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = new LinearLayout(this.mContext);
      ((LinearLayout)localObject2).setMinimumHeight(wja.dp2px(76.0F, this.mContext.getResources()));
      ((LinearLayout)localObject2).setOrientation(1);
      localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10, 2131364503);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new RelativeLayout(this.mContext);
      ((RelativeLayout)localObject3).setId(2131367050);
      Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject3).setPadding(i, i, i, 0);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramdl.a().r = ((RelativeLayout)localObject3);
      k = wja.dp2px(48.0F, this.mContext.getResources());
      localObject4 = new AsyncImageView(this.mContext);
      ((AsyncImageView)localObject4).setWidth(k);
      ((AsyncImageView)localObject4).setHeight(k);
      ((AsyncImageView)localObject4).setId(2131364472);
      ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramdl.a().jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject4);
      localObject4 = new EllipsizingTextView(this.mContext, null);
      ((TextView)localObject4).setId(2131364474);
      ((TextView)localObject4).setGravity(48);
      ((TextView)localObject4).setIncludeFontPadding(false);
      ((TextView)localObject4).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject4).setTextSize(1, 17.0F);
      ((TextView)localObject4).setMaxLines(2);
      ((TextView)localObject4).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364472);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramdl.a().T = ((TextView)localObject4);
      localObject4 = new TextView(this.mContext);
      ((TextView)localObject4).setId(2131364471);
      ((TextView)localObject4).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject4).setAlpha(0.75F);
      }
      ((TextView)localObject4).setGravity(17);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364474);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramdl.a().U = ((TextView)localObject4);
      localObject4 = new TextView(this.mContext);
      ((TextView)localObject4).setId(2131364476);
      ((TextView)localObject4).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject4).setAlpha(0.75F);
      }
      ((TextView)localObject4).setGravity(17);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364471);
      localLayoutParams.addRule(8, 2131364471);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramdl.a().V = ((TextView)localObject4);
      localObject3 = new ProgressBar(this.mContext, null, 16842872);
      ((ProgressBar)localObject3).setId(2131364475);
      ((ProgressBar)localObject3).setMax(100);
      ((ProgressBar)localObject3).setProgressDrawable(this.mContext.getResources().getDrawable(2130838114));
      localObject4 = new LinearLayout.LayoutParams(-1, wja.dp2px(2.0F, this.mContext.getResources()));
      ((LinearLayout.LayoutParams)localObject4).setMargins(i, j, i, j);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramdl.a().j = ((ProgressBar)localObject3);
      paramdl.a().E = ((View)localObject1);
      paramdl.o.addView((View)localObject1);
      if (paramInt != 18) {
        break label1132;
      }
      a(paramDataLineMsgSet, paramdl);
      b(paramDataLineMsgSet, paramdl);
      return paramDataLineMsgSet;
      paramDataLineMsgSet = (DataLineMsgSet)localObject2;
      if (i != 1) {
        break;
      }
      paramDataLineMsgSet = this.b.getResources().getDrawable(2130845071);
      break;
    }
    label1132:
    b(paramDataLineMsgSet, paramdl);
    return paramDataLineMsgSet;
  }
  
  protected void a(int paramInt, dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    e(paramdl, paramDataLineMsgSet);
    a(paramDataLineMsgSet, paramdl);
    if (ThemeUtil.isInNightMode(this.app))
    {
      afeh localafeh = (afeh)this.b.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361820);
      if (localafeh != null)
      {
        paramInt = wkj.c(localafeh.getBitmap());
        paramdl.a().setTextColor(ColorStateList.valueOf(paramInt));
      }
    }
    if (e(paramDataLineMsgSet.getMsgId()))
    {
      paramDataLineMsgSet = aqmu.a(this.mContext, 3, paramDataLineMsgSet.getTime() * 1000L);
      paramdl.a().setVisibility(0);
      paramdl.a().setText(paramDataLineMsgSet);
      return;
    }
    paramdl.a().setVisibility(8);
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat)
  {
    super.a(paramDataLineMsgRecord, paramView, paramFloat);
    if ((paramDataLineMsgRecord == null) || (paramView == null)) {}
    do
    {
      return;
      float f = paramFloat;
      if (paramFloat < paramDataLineMsgRecord.progress) {
        f = paramDataLineMsgRecord.progress;
      }
      ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131364475);
      if (localProgressBar != null)
      {
        localProgressBar.setVisibility(0);
        localProgressBar.setProgress((int)(100.0F * f));
      }
      paramView = (RelativeLayout)paramView.findViewById(2131367050);
    } while (paramView == null);
    int i = wja.dp2px(14.0F, this.mContext.getResources());
    int j = wja.dp2px(18.0F, this.mContext.getResources());
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(i, i, j, 0);
      return;
    }
    paramView.setPadding(j, i, i, 0);
  }
  
  void a(AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str = ahbj.getExtension(paramDataLineMsgRecord.filename);
    if (TextUtils.isEmpty(str)) {
      paramAsyncImageView.setImageResource(2130845244);
    }
    int i;
    do
    {
      return;
      paramAsyncImageView.setDefaultImage(ahav.r(str));
      if (ahav.getFileType(str) == 0)
      {
        str = paramDataLineMsgRecord.filename;
        if (aqhq.fileExistsAndNotEmpty(paramDataLineMsgRecord.thumbPath)) {
          str = paramDataLineMsgRecord.thumbPath;
        }
        for (;;)
        {
          paramAsyncImageView.setAsyncImage(str);
          return;
          if (aqhq.fileExistsAndNotEmpty(paramDataLineMsgRecord.path)) {
            str = paramDataLineMsgRecord.path;
          }
        }
      }
      i = ahav.r(str);
    } while (i == 0);
    paramAsyncImageView.setImageResource(i);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = super.getItemViewType(paramInt);
    if (i == 10) {
      paramInt = 18;
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (i != 3);
    return 17;
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount() + 2;
  }
  
  protected boolean s(int paramInt)
  {
    return (paramInt == 17) || (paramInt == 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dg
 * JD-Core Version:    0.7.0.1
 */