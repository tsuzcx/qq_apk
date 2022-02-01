import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class mxi
  implements View.OnClickListener
{
  private static final String TAG = "Q.readinjoy.video." + mxi.class.getSimpleName();
  private Set<String> J = new HashSet();
  private mxh a;
  private final int aUB;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private lae jdField_b_of_type_Lae;
  private mtg jdField_b_of_type_Mtg;
  private VideoInfo.ECommerceEntranceInfo c;
  private SparseBooleanArray i;
  private Activity mActivity;
  private boolean mIsClicked;
  private boolean mIsShowing;
  
  public mxi(QQAppInterface paramQQAppInterface, Activity paramActivity, mtg parammtg)
  {
    this.a = new mxh(paramQQAppInterface);
    this.aUB = aqcx.dip2px(paramActivity, 3.0F);
    this.jdField_b_of_type_Mtg = parammtg;
    this.mActivity = paramActivity;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, mtg.l paraml, VideoInfo paramVideoInfo)
  {
    this.mIsShowing = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.c = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.style == 0)
    {
      if ((paraml.bu == null) && ((paraml instanceof mtg.k)))
      {
        paraml.bu = ((ViewGroup)((ViewStub)paraml.bt.findViewById(2131381702)).inflate());
        paraml.A = ((URLImageView)paraml.bu.findViewById(2131378324));
        paraml.rT = ((TextView)paraml.bu.findViewById(2131378325));
      }
      if (paraml.bu != null)
      {
        paraml.bu.setVisibility(0);
        if (TextUtils.isEmpty(paramECommerceEntranceInfo.WU)) {}
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = aqnm.dip2px(32.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = aqnm.dip2px(32.0F);
        localObject1 = URLDrawable.getDrawable(paramECommerceEntranceInfo.WU, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, this.aUB, 3 });
        ((URLDrawable)localObject1).setDecodeHandler(aqbn.j);
        paraml.A.setImageDrawable((Drawable)localObject1);
        paraml.rT.setText(paramECommerceEntranceInfo.title);
        muj.a(paraml.bu, 200);
        paraml.bu.setTag(paraml);
        paraml.bu.setOnClickListener(this);
        kbp.a(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new nce.a(null, null, null, paramVideoInfo.Wz).Q(paramECommerceEntranceInfo.style).a(paramECommerceEntranceInfo.WT).e(paramVideoInfo.algorithmID).h(paramVideoInfo.Wz).f(paramECommerceEntranceInfo.aHm).a().toJsonString(), false);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "后台下发的url格式有问题：" + paramECommerceEntranceInfo.WU);
        continue;
      }
      if (paramECommerceEntranceInfo.style == 1)
      {
        if ((paraml.bw == null) && (paraml.p != null))
        {
          paraml.p.inflate();
          paraml.bw = ((ViewGroup)paraml.rootView.findViewById(2131374339));
          paraml.C = ((URLImageView)paraml.rootView.findViewById(2131378822));
          paraml.rY = ((TextView)paraml.rootView.findViewById(2131378821));
          paraml.lR = paraml.rootView.findViewById(2131378819);
          paraml.rZ = ((TextView)paraml.rootView.findViewById(2131378823));
          paraml.sa = ((TextView)paraml.rootView.findViewById(2131378820));
          paraml.lR.setTag(paraml);
          paraml.lR.setOnClickListener(this);
          paraml.rY.setTag(paraml);
          paraml.rY.setOnClickListener(this);
        }
        muj.H(paraml.bw, 0);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.WU, (URLDrawable.URLDrawableOptions)localObject2);
        paraml.C.setImageDrawable((Drawable)localObject2);
        int j;
        if ((paramECommerceEntranceInfo.b != null) && (aqiz.isAppInstalled(this.mActivity, paramECommerceEntranceInfo.b.aiM)))
        {
          j = 1;
          label592:
          if (j == 0) {
            break label666;
          }
          paraml.rY.setText(paramECommerceEntranceInfo.WR);
        }
        for (;;)
        {
          paraml.rZ.setText(paramECommerceEntranceInfo.title);
          paraml.sa.setText(paramECommerceEntranceInfo.subTitle);
          paraml.titleTextView.setVisibility(8);
          paraml.jdField_a_of_type_Mrx.nW(false);
          this.jdField_b_of_type_Mtg.om(false);
          break;
          j = 0;
          break label592;
          label666:
          paraml.rY.setText(paramECommerceEntranceInfo.WQ);
        }
      }
      if (paramECommerceEntranceInfo.style == 2) {
        b(paramECommerceEntranceInfo, paraml, paramVideoInfo);
      }
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, int paramInt1, int paramInt2)
  {
    if ((paramECommerceEntranceInfo.playTime >= 0) && (paramInt1 >= paramECommerceEntranceInfo.playTime)) {}
    while ((paramECommerceEntranceInfo.aHm >= 0) && (paramInt1 / paramInt2 * 100.0F >= paramECommerceEntranceInfo.aHm)) {
      return true;
    }
    return false;
  }
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, mtg.l paraml, VideoInfo paramVideoInfo)
  {
    if ((paraml.bx == null) && (paraml.q != null))
    {
      paraml.q.inflate();
      paraml.bx = ((ViewGroup)paraml.rootView.findViewById(2131374335));
      paraml.sb = ((TextView)paraml.bx.findViewById(2131374336));
      paraml.R = ((KandianUrlImageView)paraml.bx.findViewById(2131381678));
      int j = (int)(muj.c(this.mActivity)[1] * 0.45F);
      ((ViewGroup.MarginLayoutParams)paraml.bx.findViewById(2131381684).getLayoutParams()).topMargin = j;
      this.jdField_b_of_type_Lae = lae.a("https://kd.qpic.cn/viola/test/lottie_d5d5ea43.zip");
      paraml.R.setVisibilityChangedListener(new mxj(this, paraml));
      paraml.bx.setOnClickListener(new mxk(this));
    }
    this.jdField_b_of_type_Lae.removeAllAnimatorListeners();
    this.jdField_b_of_type_Lae.addAnimatorListener(new mxl(this, paraml));
    paraml.bx.setVisibility(8);
    muj.H(paraml.bx, 0);
    paraml.R.setImageDrawable(this.jdField_b_of_type_Lae);
    paraml.sb.setText(paramECommerceEntranceInfo.title);
    this.jdField_b_of_type_Lae.playAnimation();
  }
  
  private boolean b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo.style == 2) {
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.title)) {}
    }
    while ((this.a.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.title)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.subTitle))))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) {
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    }
    if ((this.i == null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "play by positions, position to play is: " + Arrays.toString(paramECommerceEntranceInfo.da) + ", play time is:" + paramECommerceEntranceInfo.playTime + ", play percent :" + paramECommerceEntranceInfo.aHm);
      }
      this.i = new SparseBooleanArray();
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.da != null)
      {
        int j = 0;
        while (j < this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.da.length)
        {
          this.i.put(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.da[j] - 1, true);
          j += 1;
        }
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo, mtg.l paraml, int paramInt1, int paramInt2)
  {
    if (paraml.itemType != 2) {}
    label8:
    do
    {
      do
      {
        int j;
        do
        {
          do
          {
            do
            {
              break label8;
              break label8;
              break label8;
              do
              {
                return;
              } while (paraml.be.getVisibility() == 0);
              if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
                break;
              }
            } while ((!a(paramVideoInfo.a, paramInt1, paramInt2)) || (this.mIsClicked) || (this.mIsShowing) || (!b(paramVideoInfo.a)));
            a(paramVideoInfo.a, paraml, paramVideoInfo);
            this.J.add(paramVideoInfo.vid);
          } while (!QLog.isColorLevel());
          QLog.d(TAG, 2, "show shunt bar!!!");
          return;
          if ((paramVideoInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
          j = paraml.aUv;
          if ((this.i.get(j)) && (paramVideoInfo.isAD))
          {
            this.i.put(j + 1, true);
            return;
          }
        } while ((!this.i.get(j)) || (this.mIsClicked) || (!a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.mIsShowing) || (!b(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paraml, paramVideoInfo);
        this.J.add(paramVideoInfo.vid);
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "show shunt bar!!!");
      return;
    } while ((paraml.bu == null) || (paraml.bu.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "默认不显示引流条");
    }
    paraml.bu.setVisibility(8);
  }
  
  public void doOnDestory()
  {
    this.a.aTu();
    this.mActivity = null;
  }
  
  public void h(mtg.l paraml)
  {
    this.mIsShowing = false;
    this.mIsClicked = false;
    i(paraml);
  }
  
  public void i(mtg.l paraml)
  {
    if ((paraml == null) || (this.c == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paraml.itemType != 2);
        if (this.c.style != 0) {
          break;
        }
      } while (paraml.bu == null);
      paraml.bu.setVisibility(8);
      return;
      if (this.c.style == 1)
      {
        if (paraml.bw != null) {
          paraml.bw.setVisibility(8);
        }
        paraml.titleTextView.setVisibility(0);
        paraml.jdField_a_of_type_Mrx.nW(true);
        this.jdField_b_of_type_Mtg.om(true);
        return;
      }
    } while ((this.c.style != 2) || (paraml.bx == null));
    muj.H(paraml.bx, 8);
  }
  
  public boolean isShowing()
  {
    return this.mIsShowing;
  }
  
  public void j(mtg.l paraml)
  {
    if (this.c == null) {
      return;
    }
    this.mIsClicked = true;
    this.mIsShowing = false;
    label79:
    Object localObject;
    if (this.c.style == 0) {
      if (!TextUtils.isEmpty(this.c.jumpUrl))
      {
        kxm.aJ(this.mActivity, this.c.jumpUrl);
        i(paraml);
        if ((paraml == null) || (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null)) {
          break label247;
        }
        paraml = paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
        if (paraml == null) {
          break label252;
        }
        localObject = paraml.Wz;
        label88:
        nce.a locala = new nce.a(null, null, null, (String)localObject).Q(this.c.style).f(this.c.aHm).a(this.c.WT);
        if (paraml == null) {
          break label257;
        }
        localObject = paraml.Wz;
        label139:
        localObject = locala.h((String)localObject);
        if (paraml == null) {
          break label262;
        }
      }
    }
    label257:
    label262:
    for (paraml = Long.valueOf(paraml.algorithmID);; paraml = null)
    {
      kbp.a(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((nce.a)localObject).e(paraml.longValue()).a().toJsonString(), false);
      return;
      if (this.c.b == null) {
        break;
      }
      muj.a(this.mActivity, this.c.b);
      break;
      if (this.c.style != 1) {
        break;
      }
      muj.a(this.mActivity, this.c.b);
      break;
      label247:
      paraml = null;
      break label79;
      label252:
      localObject = null;
      break label88;
      localObject = null;
      break label139;
    }
  }
  
  public void onClick(View paramView)
  {
    mtg.e locale = (mtg.e)paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      j((mtg.l)locale);
      continue;
      i((mtg.l)locale);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxi
 * JD-Core Version:    0.7.0.1
 */