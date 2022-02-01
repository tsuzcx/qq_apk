import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.ImgUpdateListener.1;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class ygr
  extends BaseAdapter
  implements View.OnClickListener
{
  private long JU;
  private yhf a;
  private HashSet<String> aF = new HashSet();
  private String aXF;
  private URLDrawable.URLDrawableListener jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableListener = new ygt(this);
  private EmotionKeywordHorizonListView jdField_b_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private int bYV;
  private int bYW = 0;
  private boolean bmC;
  private Drawable dZ;
  private int defaultWidth;
  private float density;
  private URLDrawableDownListener e = new ygs(this);
  private int imgHeight;
  EditText input;
  private QQAppInterface k;
  private String keyword;
  private BaseActivity mActivity;
  BaseChatPie mBaseChatPie;
  private List<ygl> mData;
  private SessionInfo mSessionInfo;
  private int paddingBottom;
  private int paddingLeft;
  private int paddingRight;
  private int paddingTop;
  private ArrayList<URLDrawable> qV = new ArrayList(5);
  private List<StickerRecCacheEntity> sx = new ArrayList();
  private List<yhl> sy = new ArrayList();
  private String title;
  
  public ygr(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText, BaseChatPie paramBaseChatPie, EmotionKeywordHorizonListView paramEmotionKeywordHorizonListView)
  {
    this.mActivity = paramBaseActivity;
    this.k = paramQQAppInterface;
    this.mSessionInfo = paramSessionInfo;
    this.input = paramEditText;
    this.mData = new ArrayList();
    this.density = this.mActivity.getResources().getDisplayMetrics().density;
    this.paddingRight = ((int)(this.density * 7.0F));
    this.paddingLeft = ((int)(this.density * 7.0F));
    this.paddingTop = ((int)(this.density * 9.0F));
    this.paddingBottom = ((int)(this.density * 8.0F));
    this.imgHeight = ((int)(this.density * 64.0F));
    this.defaultWidth = ((int)(this.density * 64.0F));
    this.bYV = ((int)(this.density * 6.0F));
    this.mBaseChatPie = paramBaseChatPie;
    this.dZ = paramBaseActivity.getResources().getDrawable(2130838388);
    this.a = yhf.a(paramQQAppInterface);
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = paramEmotionKeywordHorizonListView;
  }
  
  private int a(ygl paramygl)
  {
    int i;
    if (paramygl == null) {
      i = this.defaultWidth;
    }
    int j;
    do
    {
      return i;
      if (yhf.a(paramygl)) {
        return this.defaultWidth;
      }
      if (!yhf.b(paramygl)) {
        return this.defaultWidth;
      }
      paramygl = (ygz)paramygl;
      float f1 = paramygl.getWidth();
      float f2 = paramygl.getHeight();
      float f3 = f1 / f2;
      if ((f3 > 1.777778F) || (f3 < 0.5625F)) {
        return this.defaultWidth;
      }
      j = (int)(f1 * this.imgHeight / f2);
      i = j;
    } while (j != 0);
    return this.defaultWidth;
  }
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(ygl paramygl)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramygl.a();
    paramygl = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramygl = URLDrawable.URLDrawableOptions.obtain();
    }
    paramygl.mLoadingDrawable = this.dZ;
    paramygl.mFailedDrawable = this.dZ;
    paramygl.mPlayGifImage = true;
    paramygl.mGifRoundCorner = this.bYV;
    return paramygl;
  }
  
  private void a(URLDrawable paramURLDrawable, long paramLong)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (!this.bmC) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("first_sticker", String.valueOf(bool));
      paramURLDrawable = paramURLDrawable.getURL();
      if (paramURLDrawable != null) {
        localHashMap.put("sticker_url", paramURLDrawable.toString());
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", true, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(ygl paramygl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "sendPic");
    }
    if (paramygl == null) {}
    do
    {
      return;
      localObject2 = this.keyword;
      localObject1 = localObject2;
      if (this.bYW == 1)
      {
        yho localyho = ScenesRecommendManager.a(this.k).a(this.keyword);
        localObject1 = localObject2;
        if (localyho != null) {
          localObject1 = localyho.getName();
        }
      }
      yhf.a(this.k).yG((String)localObject1);
      if (!yhf.a(paramygl)) {
        break;
      }
      paramygl.e(this.k, this.mBaseChatPie.mContext, this.mBaseChatPie.sessionInfo);
      paramygl = this.k.getHandler(ChatActivity.class);
    } while (paramygl == null);
    paramygl.sendMessage(paramygl.obtainMessage(92));
    return;
    Object localObject1 = (ygz)paramygl;
    Object localObject2 = new Intent();
    paramygl = new ArrayList();
    paramygl.add(((ygz)localObject1).getFilePath());
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramygl);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("uin", this.mSessionInfo.aTl);
    ((Intent)localObject2).putExtra("uintype", this.mSessionInfo.cZ);
    ((Intent)localObject2).putExtra("troop_uin", this.mSessionInfo.troopUin);
    ((Intent)localObject2).putExtra("key_confess_topicid", this.mSessionInfo.topicId);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    ((Intent)localObject2).putExtra("send_in_background", true);
    ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramygl);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("quick_send_original_md5", ((ygz)localObject1).pz());
    ((Intent)localObject2).putExtra("quick_send_original_size", ((ygz)localObject1).es());
    ((Intent)localObject2).putExtra("quick_send_thumb_md5", ((ygz)localObject1).pB());
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    ((Intent)localObject2).putExtra("HOT_PIC_HAS_EXTRA", true);
    int i;
    if ((TextUtils.isEmpty(((ygz)localObject1).getWebUrl())) || (((ygz)localObject1).getWebUrl().length() <= 100))
    {
      i = 1;
      label377:
      if (i == 0) {
        break label711;
      }
      ((Intent)localObject2).putExtra("key_emotion_source_from", ((ygz)localObject1).sZ());
      ((Intent)localObject2).putExtra("key_emotion_source_info", ((ygz)localObject1).getSource());
      ((Intent)localObject2).putExtra("key_emotion_source_weburl", ((ygz)localObject1).getWebUrl());
      ((Intent)localObject2).putExtra("key_emotion_source_iconurl", "");
      ((Intent)localObject2).putExtra("key_emotion_source_packagename", ((ygz)localObject1).getPackageName());
      ((Intent)localObject2).putExtra("key_emotion_source_epid", ((ygz)localObject1).wL());
      label458:
      if (QLog.isColorLevel()) {
        QLog.i("StickerRecBarAdapter", 2, "md5:" + ((ygz)localObject1).pz() + "srcfrom:" + ((ygz)localObject1).sZ() + ", desc:" + ((ygz)localObject1).getSource() + ", webUrl:" + ((ygz)localObject1).getWebUrl() + ", pack:" + ((ygz)localObject1).getPackageName() + ", epid:" + ((ygz)localObject1).wL());
      }
      if (!((wwz)this.mBaseChatPie.a(41)).Sf()) {
        break label763;
      }
      localObject1 = this.mBaseChatPie.a.getEditableText();
      localObject2 = apuh.a((Editable)localObject1);
      ((ajcy)this.k.getManager(174)).a(this.k, this.mSessionInfo.aTl, this.mSessionInfo.cZ, paramygl, false, (String)((Pair)localObject2).first, (ArrayList)((Pair)localObject2).second, this.mBaseChatPie.mSourceMsgInfo);
      xqh.b(this.k, localObject1.toString(), (ArrayList)((Pair)localObject2).second, this.mSessionInfo.aTl);
    }
    for (;;)
    {
      paramygl = this.k.getHandler(ChatActivity.class);
      if (paramygl == null) {
        break;
      }
      paramygl.sendMessage(paramygl.obtainMessage(92));
      return;
      i = 0;
      break label377;
      label711:
      anot.a(null, "dc00898", "", "", "0X800A7EA", "0X800A7EA", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break label458;
      }
      QLog.i("StickerRecBarAdapter", 2, "sendPic over limited!");
      break label458;
      label763:
      ThreadManager.post(new SendPhotoTask(this.mActivity, (Intent)localObject2, null), 8, null, false);
    }
  }
  
  private void cij()
  {
    int j = 0;
    this.JU = System.currentTimeMillis();
    if (this.mData.size() < 5) {}
    for (int i = this.mData.size();; i = 5)
    {
      this.qV.clear();
      this.bmC = false;
      if (j < i)
      {
        Object localObject = (ygl)this.mData.get(j);
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          localObject = ((ygl)localObject).a(((ygl)localObject).e(), a((ygl)localObject));
          if (localObject != null)
          {
            ((URLDrawable)localObject).setDecodeHandler(aqbn.a);
            ((URLDrawable)localObject).setURLDrawableListener(this.jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableListener);
            if (((URLDrawable)localObject).getStatus() != 1)
            {
              this.qV.add(localObject);
              ((URLDrawable)localObject).addHeader("my_uin", this.k.getAccount());
              ((URLDrawable)localObject).addHeader("emo_big", "true");
              ((URLDrawable)localObject).startDownload();
            }
            else
            {
              this.bmC = true;
            }
          }
        }
      }
      cik();
      return;
    }
  }
  
  private void cil()
  {
    if (this.mData.size() > 0)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = this.mData.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ygl localygl = (ygl)((Iterator)localObject).next();
        if (localygl.TA()) {
          localArrayList1.add(localygl);
        } else {
          localArrayList2.add(localygl);
        }
      }
      localObject = new yhl();
      ((yhl)localObject).keyword = this.keyword;
      ((yhl)localObject).aXF = this.aXF;
      ((yhl)localObject).exposedList = localArrayList1;
      ((yhl)localObject).sE = localArrayList2;
      ((yhl)localObject).recommendType = this.bYW;
      this.sy.add(localObject);
    }
  }
  
  private void j(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramURLDrawable = paramURLDrawable.getURL();
    if (paramURLDrawable != null) {
      localHashMap.put("sticker_url", paramURLDrawable.toString());
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", false, 0L, 0L, localHashMap, "");
  }
  
  public void DU(int paramInt)
  {
    this.bYW = paramInt;
  }
  
  public void aMX()
  {
    try
    {
      cil();
      ArrayList localArrayList1 = new ArrayList(this.sy);
      ArrayList localArrayList2 = new ArrayList(this.sx);
      ThreadManager.getFileThreadHandler().post(new StickerRecBarAdapter.3(this, localArrayList1, localArrayList2));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("StickerRecBarAdapter", 1, "reportData:", localThrowable);
      return;
    }
    finally
    {
      this.sy.clear();
      this.mData.clear();
    }
  }
  
  public void cik()
  {
    boolean bool2 = true;
    if (((wxa)this.mBaseChatPie.a(14)).Sh()) {
      return;
    }
    boolean bool1;
    label34:
    Object localObject;
    if (this.bYW == 1)
    {
      bool1 = this.bmC;
      if (bool1)
      {
        localObject = this.k.getHandler(ChatActivity.class);
        bool1 = bool2;
        if (localObject != null)
        {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(69, this.title));
          bool1 = bool2;
        }
        label72:
        if (!QLog.isColorLevel()) {
          break label183;
        }
        QLog.d("StickerRecBarAdapter", 2, "showEmotionKeywordLayout isshow = " + bool1);
      }
    }
    else
    {
      localObject = this.a.hD(this.input.getText().toString());
      String str = ((wwz)this.mBaseChatPie.a(41)).pq();
      if (TextUtils.isEmpty(str)) {
        break label185;
      }
      localObject = str;
    }
    label183:
    label185:
    for (;;)
    {
      if ((this.bmC) && (this.keyword.equalsIgnoreCase((String)localObject)))
      {
        bool1 = true;
        break label34;
      }
      bool1 = false;
      break label34;
      bool1 = false;
      break label72;
      break;
    }
  }
  
  public int getCount()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.mData.size())
    {
      QLog.e("StickerRecBarAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.mData.size());
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    Object localObject2 = (ygl)this.mData.get(paramInt);
    label514:
    label558:
    label575:
    boolean bool;
    if (paramView == null)
    {
      localObject1 = new ygr.b(null);
      ((ygr.b)localObject1).hA = new EmojiStickerManager.EmotionKeywordLayout(this.mActivity, this.mBaseChatPie);
      paramView = new ViewGroup.LayoutParams(-2, -2);
      ((ygr.b)localObject1).hA.setLayoutParams(paramView);
      ((ygr.b)localObject1).hA.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, this.paddingBottom);
      ((ygr.b)localObject1).aw = new URLImageView(this.mActivity);
      ((ygr.b)localObject1).aw.setScaleType(ImageView.ScaleType.FIT_XY);
      ((ygr.b)localObject1).aw.setId(2131368962);
      paramView = new RelativeLayout.LayoutParams(a((ygl)localObject2), this.imgHeight);
      paramView.addRule(13, -1);
      ((ygr.b)localObject1).hA.addView(((ygr.b)localObject1).aw, paramView);
      ((ygr.b)localObject1).KK = new TextView(this.mActivity);
      ((ygr.b)localObject1).KK.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130838087));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368962);
      paramView.addRule(8, 2131368962);
      ((ygr.b)localObject1).KK.setText(2131693042);
      ((ygr.b)localObject1).KK.setTextColor(this.mActivity.getResources().getColor(2131167461));
      ((ygr.b)localObject1).KK.setTextSize(1, 12.0F);
      ((ygr.b)localObject1).hA.addView(((ygr.b)localObject1).KK, paramView);
      ((ygr.b)localObject1).uh = new ImageView(this.mActivity);
      ((ygr.b)localObject1).uh.setImageDrawable(this.mActivity.getResources().getDrawable(2130838382));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368962);
      paramView.addRule(8, 2131368962);
      ((ygr.b)localObject1).hA.addView(((ygr.b)localObject1).uh, paramView);
      ((ygr.b)localObject1).uh.setVisibility(8);
      paramView = ObjectAnimator.ofFloat(((ygr.b)localObject1).aw, "alpha", new float[] { 0.0F, 1.0F });
      paramView.setDuration(300L);
      ((ygr.b)localObject1).g = paramView;
      paramView = ((ygr.b)localObject1).hA;
      paramView.setTag(localObject1);
      if (localObject2 != null) {
        break label676;
      }
      QLog.e("StickerRecBarAdapter", 1, "getView stickerRec empty position = " + paramInt);
      ((ygr.b)localObject1).aw.setImageDrawable(this.dZ);
      if (!(localObject2 instanceof ygu)) {
        break label1017;
      }
      ((ygr.b)localObject1).KK.setVisibility(0);
      if (!(localObject2 instanceof yhd)) {
        break label1030;
      }
      bool = ((yhd)localObject2).isNewVoiceType();
    }
    for (;;)
    {
      label593:
      localObject2 = ((ygr.b)localObject1).uh;
      if (bool) {}
      for (int i = 0;; i = 8)
      {
        ((ImageView)localObject2).setVisibility(i);
        if (!TextUtils.isEmpty(this.keyword)) {
          ((ygr.b)localObject1).aw.setContentDescription(this.keyword);
        }
        localObject1 = paramView;
        break;
        localObject1 = (ygr.b)paramView.getTag();
        i = a((ygl)localObject2);
        ((ygr.b)localObject1).aw.getLayoutParams().width = i;
        break label514;
        label676:
        ((ygr.b)localObject1).a = ((ygl)localObject2);
        Object localObject3 = ((ygl)localObject2).e();
        if (localObject3 == null)
        {
          ((ygr.b)localObject1).aw.setImageDrawable(this.dZ);
          break label558;
        }
        localObject3 = ((ygl)localObject2).a((URL)localObject3, a((ygl)localObject2));
        ((URLDrawable)localObject3).setDecodeHandler(aqbn.a);
        ((ygr.b)localObject1).aw.setTag(localObject2);
        if (((URLDrawable)localObject3).getStatus() != 1)
        {
          ((URLDrawable)localObject3).addHeader("my_uin", this.k.getAccount());
          ((URLDrawable)localObject3).addHeader("emo_big", "true");
          ((URLDrawable)localObject3).addHeader("report_key_start_download", String.valueOf(System.currentTimeMillis()));
          if ((((URLDrawable)localObject3).getStatus() == 2) || (((URLDrawable)localObject3).getStatus() == 3)) {
            ((URLDrawable)localObject3).restartDownload();
          }
        }
        for (;;)
        {
          ((ygr.b)localObject1).aw.setImageDrawable((Drawable)localObject3);
          ((ygr.b)localObject1).aw.setURLDrawableDownListener(this.e);
          ((ygr.b)localObject1).aw.setFocusable(true);
          ((ygr.b)localObject1).aw.setFocusableInTouchMode(true);
          if (yhf.b((ygl)localObject2))
          {
            ((ygz)localObject2).zX(true);
            if (QLog.isColorLevel()) {
              QLog.e("StickerRecBarAdapter", 2, "md5:" + ((ygz)localObject2).pz());
            }
          }
          paramView.setOnClickListener(this);
          ((ygr.b)localObject1).g.start();
          break;
          if ((yhf.b((ygl)localObject2)) && (!this.aF.contains(((ygz)localObject2).getMd5())))
          {
            this.aF.add(((ygz)localObject2).getMd5());
            String str = ((ygz)localObject2).getFilePath();
            this.sx.add(new StickerRecCacheEntity(str, System.currentTimeMillis(), ((ygz)localObject2).getMd5()));
          }
        }
        label1017:
        ((ygr.b)localObject1).KK.setVisibility(8);
        break label575;
        label1030:
        if (!(localObject2 instanceof yhb)) {
          break label1058;
        }
        bool = ((yhb)localObject2).isNewVoiceType();
        break label593;
      }
      label1058:
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "onClick");
    }
    Object localObject = paramView.getTag();
    ygr.b localb = null;
    if ((localObject instanceof ygr.b)) {
      localb = (ygr.b)localObject;
    }
    if (localb == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.mSessionInfo.cZ != 9501) && ((localb.aw.getDrawable() instanceof URLDrawable))) {
        if (((URLDrawable)localb.aw.getDrawable()).getStatus() == 1)
        {
          if (this.input != null)
          {
            a(localb.a);
            this.input.getEditableText().clear();
            this.input.setText("");
            if (yhf.b(localb.a)) {
              ((ygz)localb.a).setClicked(true);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("StickerRecBarAdapter", 2, "onClick input == null");
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.e("StickerRecBarAdapter", 2, "onClick:URLDrawable status != successed");
        }
      }
    }
  }
  
  public void setData(List<ygl> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      QLog.e("StickerRecBarAdapter", 1, "setData data is null or empty");
    }
    do
    {
      return;
      ((wxa)this.mBaseChatPie.a(14)).ccT();
      QLog.e("StickerRecBarAdapter", 1, "setData");
      this.mData.clear();
      this.aF.clear();
      this.sx.clear();
      this.mData.addAll(paramList);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.resetCurrentX(0);
      cij();
      notifyDataSetChanged();
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setData:");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ygl localygl = (ygl)paramList.next();
      if (yhf.b(localygl)) {
        localStringBuilder.append("thumb=").append(((ygz)localygl).getThumbUrl()).append(",");
      }
    }
    QLog.d("StickerRecBarAdapter", 2, localStringBuilder.toString());
  }
  
  public void setKeyword(String paramString)
  {
    this.keyword = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void yD(String paramString)
  {
    this.aXF = paramString;
  }
  
  public static class a
    implements yhf.a
  {
    public ygr b;
    
    public a(ygr paramygr)
    {
      this.b = paramygr;
    }
    
    public void a(List<ygl> paramList, String paramString1, String paramString2, int paramInt, String paramString3)
    {
      if (this.b != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecBarAdapter", 2, "data=" + paramList.size());
        }
        ygr.a(this.b);
        ThreadManager.getUIHandler().post(new StickerRecBarAdapter.ImgUpdateListener.1(this, paramInt, paramString3, paramString1, paramList, paramString2));
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("StickerRecBarAdapter", 2, "mAdapter is null");
    }
  }
  
  static class b
  {
    TextView KK;
    ygl a;
    URLImageView aw;
    Animator g;
    RelativeLayout hA;
    ImageView uh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygr
 * JD-Core Version:    0.7.0.1
 */