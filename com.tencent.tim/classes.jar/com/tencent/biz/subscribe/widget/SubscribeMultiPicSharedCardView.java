package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import acfp;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import ankt;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import java.util.ArrayList;
import org.json.JSONObject;
import san;

public class SubscribeMultiPicSharedCardView
  extends AbsSubscribeShareCardView
{
  protected CornerImageView a;
  protected FrameLayout aL;
  private AsyncRichTextView d;
  protected SquareImageView m;
  private ImageView oh;
  private TextView zW;
  
  public SubscribeMultiPicSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubscribeMultiPicSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubscribeMultiPicSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(san paramsan, Bitmap paramBitmap, AbsSubscribeShareCardView.a parama)
  {
    super.a(paramsan, paramBitmap, parama);
    CertifiedAccountMeta.StFeed localStFeed = paramsan.a();
    String str;
    if (localStFeed != null)
    {
      this.zW.setText(this.b.nt());
      paramsan = this.b.a().title.get();
      localObject = paramsan;
      if (TextUtils.isEmpty(paramsan)) {
        localObject = this.b.a().content.get();
      }
      paramsan = (san)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        str = this.b.a().ext.get();
        paramsan = (san)localObject;
      }
    }
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        paramsan = (san)localObject;
        if (JSONUtil.isJson(str)) {
          paramsan = new JSONObject(str).optString("title");
        }
      }
    }
    catch (Exception paramsan)
    {
      for (;;)
      {
        int i;
        int j;
        paramsan = "";
      }
    }
    Object localObject = paramsan;
    if (TextUtils.isEmpty(paramsan)) {
      localObject = acfp.m(2131720647);
    }
    this.d.setText((CharSequence)localObject);
    if (paramBitmap != null) {
      this.oh.setImageBitmap(paramBitmap);
    }
    if (localStFeed.images.size() > 0)
    {
      i = ((CertifiedAccountMeta.StImage)localStFeed.images.get(0)).width.get();
      j = ((CertifiedAccountMeta.StImage)localStFeed.images.get(0)).height.get();
      a(this.aL, i, j);
      this.a.getLayoutParams().width = this.a.getWidth();
      this.a.getLayoutParams().height = this.a.getHeight();
      this.nZ.add(((CertifiedAccountMeta.StImage)localStFeed.images.get(0)).url.get());
      this.oa.add(this.a);
      this.nZ.add(localStFeed.poster.icon.get());
      this.oa.add(this.m);
      a(this.nZ, this.oa, parama);
    }
  }
  
  protected URLImageView b()
  {
    return this.a;
  }
  
  public int getLayoutId()
  {
    return 2131558871;
  }
  
  public void u(View paramView)
  {
    this.pZ = paramView.findViewById(2131364405);
    this.a = ((CornerImageView)paramView.findViewById(2131364409));
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.a.setBackgroundColor(-1);
    this.a.setRadius(ankt.dip2px(2.0F));
    this.m = ((SquareImageView)paramView.findViewById(2131364403));
    this.zW = ((TextView)paramView.findViewById(2131364406));
    this.d = ((AsyncRichTextView)paramView.findViewById(2131364407));
    this.oh = ((ImageView)paramView.findViewById(2131378210));
    this.oh.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.aL = ((FrameLayout)findViewById(2131364404));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeMultiPicSharedCardView
 * JD-Core Version:    0.7.0.1
 */