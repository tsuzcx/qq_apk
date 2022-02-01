import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class afoc
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener
{
  public static Rect tmp = new Rect();
  private List<Emoticon> Ae = new ArrayList();
  public List<Emoticon> Af = new ArrayList();
  private List<Emoticon> Ag = new ArrayList();
  private int adw;
  private int adx;
  private QQAppInterface app;
  URLDrawable.URLDrawableListener d = new afoe(this);
  private List<Emoticon> data;
  private float density;
  URLDrawableDownListener e = new afod(this);
  private List<EmotionKeyword> exposedList;
  private ajdg f;
  private ColorDrawable i = new ColorDrawable();
  private int imgHeight;
  private int imgWidth;
  EditText input;
  private String keyword;
  BaseChatPie mBaseChatPie;
  private Context mContext;
  ArrayList<URLDrawable> qV = new ArrayList(5);
  private SessionInfo sessionInfo;
  
  public afoc(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText, BaseChatPie paramBaseChatPie)
  {
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.input = paramEditText;
    this.data = new ArrayList();
    this.exposedList = new ArrayList();
    this.density = this.mContext.getResources().getDisplayMetrics().density;
    this.adw = ((int)(this.density * 77.0F));
    this.adx = ((int)(this.density * 80.0F));
    this.imgWidth = ((int)(this.density * 65.0F));
    this.imgHeight = ((int)(this.density * 65.0F));
    this.f = ((ajdg)paramQQAppInterface.getManager(14));
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  private int Dn()
  {
    int j = 1;
    int k = aqiw.getSystemNetwork(BaseApplication.getContext());
    if (k == 1) {
      j = 0;
    }
    while (k == 4) {
      return j;
    }
    if (k == 3) {
      return 2;
    }
    if (k == 2) {
      return 3;
    }
    return -1;
  }
  
  private boolean ajF()
  {
    ArrayList localArrayList = new ArrayList(this.Ae);
    int k = this.Af.size();
    if (k > 0)
    {
      int j = 0;
      while (j < k)
      {
        if (localArrayList.contains(this.Af.get(j))) {
          localArrayList.remove(this.Af.get(j));
        }
        j += 1;
      }
    }
    if ((localArrayList.size() > 0) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isShowEmotionKeywordLayout not finishData:");
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)localIterator.next();
        if (localEmoticon != null) {
          localStringBuilder.append("eid=").append(localEmoticon.eId).append(",");
        }
      }
      QLog.d("EmotionKeywordAdapter", 2, localStringBuilder.toString());
    }
    if (localArrayList.size() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "isShowEmotionKeywordLayout showLayout = " + bool + ",keyword = " + this.keyword);
      }
      return bool;
    }
  }
  
  private void daW()
  {
    if ((this.data == null) || (this.data.size() < 1)) {
      QLog.e("EmotionKeywordAdapter", 1, "getFirstSreenData data error, keyword = " + this.keyword);
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      return;
      if (this.data.size() < 5) {}
      for (this.Ae = new ArrayList(this.data); QLog.isColorLevel(); this.Ae = new ArrayList(this.data.subList(0, 5)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFirstScreenData: keyword = ").append(this.keyword).append(":");
        Iterator localIterator = this.Ae.iterator();
        while (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          if (localEmoticon != null) {
            localStringBuilder.append("eid=").append(localEmoticon.eId).append(",");
          }
        }
      }
    }
    QLog.d("EmotionKeywordAdapter", 2, localStringBuilder.toString());
  }
  
  private void daX()
  {
    if ((this.Ae == null) || (this.Ae.size() < 1)) {
      QLog.e("EmotionKeywordAdapter", 1, "downloadFirstScreenDrawable data error keyword = " + this.keyword);
    }
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadFirstScreenDrawable : local success , keyword = " + this.keyword + ":");
      this.qV.clear();
      Iterator localIterator = this.Ae.iterator();
      while (localIterator.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)localIterator.next();
        if ((localEmoticon != null) && (!"NONE".equals(localEmoticon.epId))) {
          try
          {
            URL localURL = new URL("emotion_pic", "fromAIO", localEmoticon.epId + "_" + localEmoticon.eId);
            if (localURL == null) {
              QLog.e("EmotionKeywordAdapter", 1, "downloadFirstScreenDrawable url = null");
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              QLog.e("EmotionKeywordAdapter", 1, "downloadFirstScreenDrawable url exception e = " + localMalformedURLException.getMessage());
              localObject = null;
            }
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mLoadingDrawable = this.i;
            localURLDrawableOptions.mFailedDrawable = this.i;
            localURLDrawableOptions.mPlayGifImage = true;
            Object localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
            ((URLDrawable)localObject).setURLDrawableListener(this.d);
            ((URLDrawable)localObject).setTag(localEmoticon);
            if (((URLDrawable)localObject).getStatus() != 1)
            {
              this.qV.add(localObject);
              ((URLDrawable)localObject).addHeader("my_uin", this.app.getAccount());
              ((URLDrawable)localObject).addHeader("emo_big", "true");
              ((URLDrawable)localObject).startDownload();
            }
            else
            {
              if (!this.Af.contains(localEmoticon)) {
                this.Af.add(localEmoticon);
              }
              localStringBuilder.append(";epId = ").append(localEmoticon.epId).append(",eid = ").append(localEmoticon.eId);
            }
          }
        }
      }
      cik();
    } while (!QLog.isColorLevel());
    QLog.d("EmotionKeywordAdapter", 2, localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(this.keyword)) || (!this.keyword.equals(paramString))) {}
    while (!paramBoolean) {
      return;
    }
    ThreadManager.post(new EmotionKeywordAdapter.3(this, paramEmoticonResp, paramString), 5, null, true);
  }
  
  public void cik()
  {
    if ((ajF()) && (this.keyword.equals(this.input.getText().toString())))
    {
      MqqHandler localMqqHandler = this.app.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(69));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "showEmotionKeywordLayout isshow = " + bool + ",keyword = " + this.keyword + ",inputstring = " + this.input.getText().toString());
      }
      return;
    }
  }
  
  public void daY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "resetExposeList");
    }
    this.exposedList.clear();
  }
  
  public void daZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "resetLoadFinishData");
    }
    this.Af.clear();
  }
  
  public void dba()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "reportExposeData, keyword = " + this.keyword);
    }
    int m = this.Ag.size();
    if (m > 0)
    {
      int j;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      StringBuilder localStringBuilder3;
      StringBuilder localStringBuilder4;
      int k;
      label94:
      Emoticon localEmoticon;
      if (m > 5)
      {
        j = 5;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder3 = new StringBuilder();
        localStringBuilder4 = new StringBuilder();
        k = 0;
        if (k >= m) {
          break label228;
        }
        localEmoticon = (Emoticon)this.Ag.get(k);
        if (k >= j) {
          break label178;
        }
        localStringBuilder1.append(localEmoticon.eId);
        localStringBuilder2.append(localEmoticon.epId);
        if (k < j - 1)
        {
          localStringBuilder1.append("_");
          localStringBuilder2.append("_");
        }
      }
      for (;;)
      {
        k += 1;
        break label94;
        j = m;
        break;
        label178:
        localStringBuilder3.append(localEmoticon.eId);
        localStringBuilder4.append(localEmoticon.epId);
        if (k < m - 1)
        {
          localStringBuilder3.append("_");
          localStringBuilder4.append("_");
        }
      }
      label228:
      anot.a(this.app, "CliOper", "", "", "ep_mall", "View_associate", 0, 0, Dn() + "", "", localStringBuilder1.toString(), this.keyword);
      anot.a(this.app, "CliOper", "", "", "ep_mall", "View_associate_2", 0, 0, Dn() + "", "", localStringBuilder2.toString(), this.keyword);
      if (localStringBuilder3.length() > 0)
      {
        anot.a(this.app, "CliOper", "", "", "ep_mall", "View_associate", 0, 0, Dn() + "", "", localStringBuilder3.toString(), this.keyword);
        anot.a(this.app, "CliOper", "", "", "ep_mall", "View_associate_2", 0, 0, Dn() + "", "", localStringBuilder4.toString(), this.keyword);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "reportExposeData : keyword = " + this.keyword + "fistReportItem = " + localStringBuilder1.toString() + ";secondReportItem = " + localStringBuilder3 + ";fistEpReportItem = " + localStringBuilder2.toString() + ";secondEpReportItem = " + localStringBuilder4);
      }
      this.Ag.clear();
    }
  }
  
  public int getCount()
  {
    if (this.data == null) {
      return 0;
    }
    return this.data.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.data.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.data.size())
    {
      QLog.e("EmotionKeywordAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.data.size());
      localObject1 = paramView;
      paramView = null;
    }
    Emoticon localEmoticon;
    label357:
    Object localObject3;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (paramView == null)
      {
        localObject1 = new afoc.a(null);
        ((afoc.a)localObject1).hA = new EmojiStickerManager.EmotionKeywordLayout(this.mContext, this.mBaseChatPie);
        paramView = new ViewGroup.LayoutParams(this.adw, this.adx);
        ((afoc.a)localObject1).hA.setLayoutParams(paramView);
        ((afoc.a)localObject1).aw = new URLImageView(this.mContext);
        paramView = new RelativeLayout.LayoutParams(this.imgWidth, this.imgHeight);
        paramView.addRule(13, -1);
        ((afoc.a)localObject1).hA.addView(((afoc.a)localObject1).aw, paramView);
        ((afoc.a)localObject1).progressBar = new ProgressBar(this.mContext);
        ((afoc.a)localObject1).progressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(2130839651));
        paramView = new RelativeLayout.LayoutParams((int)(this.density * 30.0F), (int)(this.density * 30.0F));
        paramView.addRule(13, -1);
        ((afoc.a)localObject1).hA.addView(((afoc.a)localObject1).progressBar, paramView);
        paramView = ((afoc.a)localObject1).hA;
        paramView.setTag(localObject1);
      }
      for (;;)
      {
        localEmoticon = (Emoticon)this.data.get(paramInt);
        if (localEmoticon != null) {
          break label357;
        }
        QLog.e("EmotionKeywordAdapter", 1, "getView emoticon empty position = " + paramInt);
        localObject2 = null;
        localObject1 = paramView;
        paramView = (View)localObject2;
        break;
        localObject1 = (afoc.a)paramView.getTag();
      }
      ((afoc.a)localObject1).e = localEmoticon;
      ((afoc.a)localObject1).progressBar.setVisibility(0);
      if (((afoc.a)localObject1).e.epId.equals("NONE")) {
        break label851;
      }
      Object localObject2 = new EmotionKeyword();
      ((EmotionKeyword)localObject2).epId = localEmoticon.epId;
      ((EmotionKeyword)localObject2).eId = localEmoticon.eId;
      ((EmotionKeyword)localObject2).keyword = this.keyword;
      if (!this.exposedList.contains(localObject2))
      {
        this.f.b((EmotionKeyword)localObject2, false);
        this.f.a((EmotionKeyword)localObject2, false);
        this.exposedList.add(localObject2);
      }
      if (!this.Ag.contains(localEmoticon)) {
        this.Ag.add(localEmoticon);
      }
      try
      {
        localObject2 = new URL("emotion_pic", "fromAIO", localEmoticon.epId + "_" + localEmoticon.eId);
        if (localObject2 == null)
        {
          QLog.e("EmotionKeywordAdapter", 1, "getView url = null");
          localObject2 = null;
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("EmotionKeywordAdapter", 1, "getView url exception e = " + localMalformedURLException.getMessage());
          localObject3 = null;
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = this.i;
        localURLDrawableOptions.mFailedDrawable = this.i;
        localURLDrawableOptions.mPlayGifImage = true;
        if (localEmoticon.isAPNG)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionKeywordAdapter", 2, "getView: APNG so loaded use apng image");
          }
          localURLDrawableOptions.mUseApngImage = true;
          localURLDrawableOptions.mPlayGifImage = false;
          localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
        }
        localObject3 = URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions);
        if (((URLDrawable)localObject3).getStatus() == 1) {
          break label839;
        }
      }
    }
    ((URLDrawable)localObject3).setTag(localEmoticon);
    ((URLDrawable)localObject3).addHeader("my_uin", this.app.getAccount());
    ((URLDrawable)localObject3).addHeader("emo_big", "true");
    if ((((URLDrawable)localObject3).getStatus() == 2) || (((URLDrawable)localObject3).getStatus() == 3)) {
      ((URLDrawable)localObject3).restartDownload();
    }
    label757:
    ((afoc.a)localObject1).aw.setImageDrawable((Drawable)localObject3);
    ((afoc.a)localObject1).aw.setURLDrawableDownListener(this.e);
    ((afoc.a)localObject1).aw.setTag(((afoc.a)localObject1).progressBar);
    ((afoc.a)localObject1).aw.setFocusable(true);
    ((afoc.a)localObject1).aw.setFocusableInTouchMode(true);
    ((afoc.a)localObject1).aw.setContentDescription(localEmoticon.name);
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
    for (;;)
    {
      localObject1 = paramView;
      break;
      label839:
      ((afoc.a)localObject1).progressBar.setVisibility(4);
      break label757;
      label851:
      ((afoc.a)localObject1).aw.setImageDrawable(this.i);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof afoc.a))) {}
    for (localObject = (afoc.a)localObject;; localObject = null)
    {
      if (localObject == null) {}
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject = ((afoc.a)localObject).e;
        } while ((localObject == null) || (((Emoticon)localObject).epId.equals("NONE")));
        EmotionKeyword localEmotionKeyword = new EmotionKeyword();
        localEmotionKeyword.epId = ((Emoticon)localObject).epId;
        localEmotionKeyword.eId = ((Emoticon)localObject).eId;
        localEmotionKeyword.keyword = this.keyword;
        this.f.b(localEmotionKeyword, true);
        this.f.a(localEmotionKeyword, true);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionKeywordAdapter", 2, "onClick , " + localEmotionKeyword);
        }
        int j = this.data.indexOf(localObject) + 1;
        anot.a(this.app, "CliOper", "", "", "ep_mall", "Clk_associate", 0, 0, Dn() + "", ((Emoticon)localObject).epId, ((Emoticon)localObject).eId + "_" + j, this.keyword);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionKeywordAdapter", 2, "onclick report log : keyword" + this.keyword + "epId = " + ((Emoticon)localObject).epId + ",eid = " + ((Emoticon)localObject).eId + ",index = " + j);
        }
      } while (this.sessionInfo.cZ == 9501);
      if (this.input != null)
      {
        this.input.getEditableText().clear();
        this.input.setText("");
      }
      for (;;)
      {
        ujt.a(this.app, this.mContext, this.sessionInfo, (Emoticon)localObject);
        break;
        QLog.e("EmotionKeywordAdapter", 1, "onClick input == null");
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.mBaseChatPie.mAIORootView != null) && (EmojiStickerManager.bYE))
    {
      if ((paramView instanceof EmojiStickerManager.EmotionKeywordLayout)) {
        ((EmojiStickerManager.EmotionKeywordLayout)paramView).bYJ = true;
      }
      paramView.getGlobalVisibleRect(tmp);
      float f1 = this.mContext.getResources().getDisplayMetrics().density;
      EmojiStickerManager.StickerFrameLayout localStickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(this.mContext);
      localStickerFrameLayout.setId(2131374755);
      URLImageView localURLImageView = new URLImageView(this.mContext);
      localURLImageView.setAdjustViewBounds(false);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      if ((paramView.getTag() instanceof afoc.a))
      {
        paramView = ((afoc.a)paramView.getTag()).e;
        localURLImageView.setImageDrawable(EmojiStickerManager.a().a(this.mContext, paramView));
        localStickerFrameLayout.setTag(paramView);
      }
      localStickerFrameLayout.addView(localURLImageView);
      paramView = new ImageView(this.mContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 20.0F), (int)(this.density * 20.0F));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localStickerFrameLayout.addView(paramView, localLayoutParams);
      paramView.setImageDrawable(this.mContext.getResources().getDrawable(2130848038));
      paramView.setVisibility(4);
      paramView = new ImageView(this.mContext);
      localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 20.0F), (int)(this.density * 20.0F));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(12);
      localStickerFrameLayout.addView(paramView, localLayoutParams);
      paramView.setVisibility(4);
      paramView.setImageDrawable(this.mContext.getResources().getDrawable(2130849428));
      int m = (int)(5.0F * f1);
      int j = (int)(110.0F * f1);
      int k = (int)(110.0F * f1);
      paramView = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      localStickerFrameLayout.setPadding(m, m, m, m);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f1));
      paramView.height = ((int)(f1 * 100.0F));
      paramView = new RelativeLayout.LayoutParams(j, k);
      paramView.leftMargin = (tmp.left - (j - tmp.width()) / 2);
      m = this.mContext.getResources().getDisplayMetrics().widthPixels;
      if (paramView.leftMargin + j > m) {
        paramView.leftMargin = (m - j);
      }
      paramView.topMargin = (tmp.top - (k - tmp.height()) / 2 - (int)(15.0F * this.density));
      paramView.width = j;
      paramView.height = k;
      this.mBaseChatPie.mAIORootView.addView(localStickerFrameLayout, paramView);
      j = paramView.leftMargin;
      k = paramView.topMargin;
      m = paramView.leftMargin;
      int n = paramView.width;
      int i1 = paramView.topMargin;
      localStickerFrameLayout.layout(j, k, m + n, paramView.height + i1);
      localStickerFrameLayout.requestLayout();
      this.mBaseChatPie.bIU();
    }
    return true;
  }
  
  public void setData(List<Emoticon> paramList)
  {
    this.data.clear();
    this.data.addAll(paramList);
    this.Ae.clear();
    daW();
    daX();
    notifyDataSetChanged();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setData:");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)paramList.next();
        if (localEmoticon != null) {
          localStringBuilder.append("eid=").append(localEmoticon.eId).append(",");
        }
      }
      QLog.d("EmotionKeywordAdapter", 2, localStringBuilder.toString());
    }
  }
  
  public void setKeyword(String paramString)
  {
    this.keyword = paramString;
  }
  
  static class a
  {
    URLImageView aw;
    Emoticon e;
    RelativeLayout hA;
    ProgressBar progressBar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afoc
 * JD-Core Version:    0.7.0.1
 */