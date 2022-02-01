import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.2;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.4;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.8;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.9;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(11)
public class adxq
  extends AIOAnimationConatiner.a
{
  public BubbleManager b;
  public String bwd = "";
  public int cKS;
  public ConcurrentHashMap<Long, adxq.b> eP = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Bitmap> eQ = new ConcurrentHashMap();
  public Handler mAnimHandler = new adxr(this, Looper.getMainLooper());
  public int mMinHeight;
  public int mMinWidth;
  public List<View> yx = new ArrayList();
  public List<AnimatorSet> yy = new ArrayList();
  
  public adxq(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.cKS = wja.dp2px(12.0F, paramListView.getContext().getResources());
    this.mMinWidth = wja.dp2px(50.0F, paramListView.getContext().getResources());
    this.mMinHeight = wja.dp2px(45.0F, paramListView.getContext().getResources());
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramSessionInfo.cZ == 0) || (paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000)) {}
    for (String str = q(paramMessageRecord);; str = null)
    {
      BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(44);
      adxm localadxm = localBubbleManager.a((int)paramMessageRecord.vipBubbleID, false);
      long l3;
      if ((localadxm == null) || (localadxm.jO == null))
      {
        l3 = -1L;
        return l3;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "bubble config mInterActivePackageID: " + localadxm.cKM + ", bubble mInterActiveType: " + localadxm.cKN);
      }
      long l4 = -1L;
      long l2 = -1L;
      int j;
      Object localObject1;
      long l6;
      long l5;
      label272:
      int i;
      label308:
      label326:
      Object localObject2;
      label423:
      int m;
      if (!TextUtils.isEmpty(str))
      {
        j = 0;
        l1 = l4;
        l3 = l2;
        if (paramAIOAnimationConatiner.b() == null) {
          break label1028;
        }
        l1 = l4;
        l3 = l2;
        if (paramAIOAnimationConatiner.b().getAdapter() == null) {
          break label1028;
        }
        ListAdapter localListAdapter = paramAIOAnimationConatiner.b().getAdapter();
        int n = paramAIOAnimationConatiner.b().getFirstVisiblePosition();
        int k = paramAIOAnimationConatiner.b().getLastVisiblePosition();
        l1 = l4;
        l3 = l2;
        if (k < n) {
          break label1028;
        }
        localObject1 = localListAdapter.getItem(k);
        l6 = l4;
        l5 = l2;
        if (!(localObject1 instanceof ChatMessage)) {
          break label1006;
        }
        paramQQAppInterface = wja.a(wja.a(paramAIOAnimationConatiner.b(), k));
        if ((paramQQAppInterface instanceof BaseBubbleBuilder.e))
        {
          paramQQAppInterface = (BaseBubbleBuilder.e)paramQQAppInterface;
          localObject1 = (ChatMessage)localObject1;
          if (j != 0) {
            break label326;
          }
          l6 = l4;
          l5 = l2;
          if (((ChatMessage)localObject1).uniseq != paramMessageRecord.uniseq) {
            break label1006;
          }
        }
        for (i = 1;; i = j)
        {
          k -= 1;
          j = i;
          break;
          paramQQAppInterface = null;
          break label272;
          l6 = l4;
          l5 = l2;
          if (paramQQAppInterface == null) {
            break label1006;
          }
          l6 = l4;
          l5 = l2;
          if (paramQQAppInterface.b == null) {
            break label1006;
          }
          paramQQAppInterface = q((MessageRecord)localObject1);
          localObject2 = localBubbleManager.a((int)((ChatMessage)localObject1).vipBubbleID, false);
          if ((localObject2 != null) && (((adxm)localObject2).jO != null)) {
            break label423;
          }
          QLog.e("BubbleInterActiveAnim", 1, "get bubbleConfig is null: " + (int)((ChatMessage)localObject1).vipBubbleID);
        }
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "record seq: " + ((ChatMessage)localObject1).uniseq + ", other bubble config mInterActivePackageID: " + ((adxm)localObject2).cKM + ", other bubble config mInterActiveType: " + ((adxm)localObject2).cKN);
        }
        m = 0;
        if (paramSessionInfo.cZ == 0)
        {
          i = 1;
          label497:
          l1 = l4;
          l3 = l2;
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            l1 = l4;
            l3 = l2;
            if (!str.equals(paramQQAppInterface))
            {
              l1 = l4;
              l3 = l2;
              if (i != 0)
              {
                if (l4 != -1L) {
                  break label1021;
                }
                l1 = ((ChatMessage)localObject1).uniseq;
                label558:
                if (paramSessionInfo.cZ != 0) {
                  break label843;
                }
                l3 = l1;
              }
            }
          }
          label569:
          l6 = l1;
          l5 = l3;
          if (l1 == -1L) {
            break label1006;
          }
          l6 = l1;
          l5 = l3;
          if (l3 == -1L) {
            break label1006;
          }
          l2 = l1;
        }
      }
      for (long l1 = l3;; l1 = l3)
      {
        if (l1 != -1L)
        {
          l3 = l1;
          if (a(paramAIOAnimationConatiner, l1)) {
            break;
          }
        }
        if ((l2 != -1L) && (a(paramAIOAnimationConatiner, l2)))
        {
          return l2;
          i = m;
          if (localadxm.cKM == -1) {
            break label497;
          }
          i = m;
          if (((adxm)localObject2).cKM == -1) {
            break label497;
          }
          if (localadxm.cKN == 3)
          {
            if ((((adxm)localObject2).cKN == 2) && (((adxm)localObject2).cKM != localadxm.cKM))
            {
              i = 1;
              break label497;
            }
            i = m;
            if (((adxm)localObject2).cKN != 3) {
              break label497;
            }
            i = 1;
            break label497;
          }
          if (localadxm.cKN == 1)
          {
            if ((localadxm.cKM == ((adxm)localObject2).cKM) && (localadxm.cKN == ((adxm)localObject2).cKN))
            {
              i = 1;
              break label497;
            }
            i = 0;
            break label497;
          }
          i = m;
          if (localadxm.cKN != 2) {
            break label497;
          }
          if (((adxm)localObject2).cKN != 2)
          {
            i = m;
            if (((adxm)localObject2).cKN != 3) {
              break label497;
            }
          }
          if (((adxm)localObject2).cKM != localadxm.cKM)
          {
            i = 1;
            break label497;
          }
          i = 0;
          break label497;
          label843:
          if ((paramMessageRecord.atInfoTempList != null) && (paramMessageRecord.atInfoTempList.size() > 0))
          {
            localObject2 = paramMessageRecord.atInfoTempList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (paramQQAppInterface.equals(String.valueOf(((MessageForText.AtTroopMemberInfo)((Iterator)localObject2).next()).uin))) {
                l2 = ((ChatMessage)localObject1).uniseq;
              }
            }
            l3 = l2;
            break label569;
          }
          if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
          {
            localObject2 = paramMessageRecord.atInfoList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (paramQQAppInterface.equals(String.valueOf(((MessageForText.AtTroopMemberInfo)((Iterator)localObject2).next()).uin))) {
                l2 = ((ChatMessage)localObject1).uniseq;
              }
            }
            l3 = l2;
            break label569;
          }
          l3 = l1;
          break label569;
        }
        return -1L;
        label1006:
        i = j;
        l4 = l6;
        l2 = l5;
        break label308;
        label1021:
        l1 = l4;
        break label558;
        label1028:
        l2 = l1;
      }
    }
  }
  
  public static boolean a(AIOAnimationConatiner paramAIOAnimationConatiner, long paramLong)
  {
    boolean bool2 = false;
    ListAdapter localListAdapter = paramAIOAnimationConatiner.b().getAdapter();
    int j;
    int i;
    if (paramAIOAnimationConatiner.b().getChildCount() > 0) {
      if ((localListAdapter instanceof auts))
      {
        j = paramAIOAnimationConatiner.b().getFirstVisiblePosition();
        i = paramAIOAnimationConatiner.b().getLastVisiblePosition();
        if ((j < 0) || (j >= localListAdapter.getCount())) {
          break label167;
        }
        label64:
        if ((i < 0) || (i >= localListAdapter.getCount())) {
          break label173;
        }
      }
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (i >= j)
      {
        paramAIOAnimationConatiner = localListAdapter.getItem(i);
        if (((paramAIOAnimationConatiner instanceof MessageRecord)) && (((MessageRecord)paramAIOAnimationConatiner).uniseq == paramLong)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
        if (!(localListAdapter instanceof wki)) {
          break label185;
        }
        j = paramAIOAnimationConatiner.b().getFirstVisiblePosition() - paramAIOAnimationConatiner.b().getHeaderViewsCount();
        i = paramAIOAnimationConatiner.b().getLastVisiblePosition() - paramAIOAnimationConatiner.b().getFooterViewsCount();
        break;
        label167:
        j = 0;
        break label64;
        label173:
        i = 0;
        continue;
      }
      i -= 1;
      continue;
      label185:
      i = 0;
      j = 0;
      break;
      i = 0;
      j = 0;
    }
  }
  
  public static String q(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004)) {
      return paramMessageRecord.frienduin;
    }
    return paramMessageRecord.senderuin;
  }
  
  public void Cp(int paramInt)
  {
    Iterator localIterator = this.eP.values().iterator();
    while (localIterator.hasNext())
    {
      adxq.b localb = (adxq.b)localIterator.next();
      if ((localb != null) && (localb.sq != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "add delta " + paramInt + " for seq: " + localb.VK);
        }
        localb.sq.setTranslationY(localb.sq.getTranslationY() + paramInt);
      }
    }
  }
  
  public adxq.b a(long paramLong1, long paramLong2)
  {
    Object localObject1 = wja.a(wja.a(this.l, wja.a(paramLong1, this.l.getAdapter())));
    if ((localObject1 instanceof BaseBubbleBuilder.e)) {}
    for (localObject1 = (BaseBubbleBuilder.e)localObject1;; localObject1 = null)
    {
      Object localObject2 = wja.a(wja.a(this.l, wja.a(paramLong2, this.l.getAdapter())));
      if ((localObject2 instanceof BaseBubbleBuilder.e)) {}
      for (localObject2 = (BaseBubbleBuilder.e)localObject2;; localObject2 = null)
      {
        if ((localObject1 == null) || (localObject2 == null) || (((BaseBubbleBuilder.e)localObject1).b == null) || (((BaseBubbleBuilder.e)localObject2).b == null)) {}
        adxm localadxm;
        do
        {
          return null;
          i = ((BaseBubbleBuilder.e)localObject1).b.bubbleId;
          int j = ((BaseBubbleBuilder.e)localObject2).b.bubbleId;
          localadxm = this.b.a(i, false);
          localObject3 = this.b.a(j, false);
        } while ((localadxm == null) || (localObject3 == null) || (localadxm.jO == null) || (((adxm)localObject3).jO == null));
        adyc localadyc1 = (adyc)localadxm.jO.get("animation_start");
        adyc localadyc2 = (adyc)((adxm)localObject3).jO.get("passive_animation");
        if (localadyc1 == null)
        {
          QLog.e("BubbleInterActiveAnim", 1, "can't find mInterActiveAnims from bubbleId: " + i);
          return null;
        }
        Object localObject3 = new adxq.b();
        ((adxq.b)localObject3).j = ((BaseBubbleBuilder.e)localObject1).mMessage;
        ((adxq.b)localObject3).u = ((BaseBubbleBuilder.e)localObject2).mMessage;
        ((adxq.b)localObject3).jQ = new HashMap(localadxm.jO);
        ((adxq.b)localObject3).jQ.put("passive_animation", localadyc2);
        ((adxq.b)localObject3).sq = new ImageView(this.l.getContext());
        ((adxq.b)localObject3).sq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ((adxq.b)localObject3).sq.layout(0, 0, localadyc1.bl.right, localadyc1.bl.bottom);
        ((adxq.b)localObject3).sq.setVisibility(4);
        ((adxq.b)localObject3).bL = a((BaseBubbleBuilder.e)localObject1, paramLong1, this.l);
        ((adxq.b)localObject3).bM = a((BaseBubbleBuilder.e)localObject2, paramLong2, this.l);
        localObject2 = (View)((BaseBubbleBuilder.e)localObject2).E.getParent();
        int i = ((View)((BaseBubbleBuilder.e)localObject1).E.getParent()).getTop() - ((View)localObject2).getTop();
        localObject2 = ((adxq.b)localObject3).bM;
        ((Rect)localObject2).top -= i;
        localObject2 = ((adxq.b)localObject3).bM;
        ((Rect)localObject2).bottom -= i;
        ((adxq.b)localObject3).wS = ((BaseBubbleBuilder.e)localObject1).E;
        this.eP.put(Long.valueOf(paramLong1), localObject3);
        this.c.addView(((adxq.b)localObject3).sq);
        ((adxq.b)localObject3).VK = paramLong1;
        ((adxq.b)localObject3).VL = paramLong2;
        return localObject3;
      }
    }
  }
  
  public ObjectAnimator a(adxq.b paramb)
  {
    adyc.a locala = (adyc.a)paramb.jQ.get("animation_start");
    ObjectAnimator localObjectAnimator = a(paramb, paramb.bL, locala);
    localObjectAnimator.setRepeatCount(locala.repeatCount - 1);
    Object localObject1;
    long l;
    if (((adyc.a)paramb.jQ.get("animation_running")).bRM)
    {
      Object localObject2 = (adyc.a)paramb.jQ.get("animation_end");
      localObject1 = a(paramb.bL, locala.bl, locala.bvU, paramb.j.isSend());
      localObject2 = a(paramb.bM, ((adyc.a)localObject2).bl, ((adyc.a)localObject2).bvU, paramb.u.isSend());
      int i = ((Integer)((Pair)localObject1).first).intValue();
      int j = ((Integer)((Pair)localObject1).second).intValue();
      int k = ((Integer)((Pair)localObject2).first).intValue();
      double d1 = Math.abs(((Integer)((Pair)localObject2).second).intValue() - j);
      double d2 = Math.abs(k - i);
      float f2 = 0.0F;
      double d3 = Math.pow(d1, 2.0D);
      d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
      float f1 = f2;
      if (d2 != 0.0D)
      {
        f1 = f2;
        if (d1 != 0.0D)
        {
          f2 = (float)Math.toDegrees(Math.asin(d1 / d2));
          f1 = f2;
          if (!paramb.j.isSend()) {
            f1 = -f2;
          }
        }
      }
      localObject1 = ObjectAnimator.ofFloat(paramb.sq, "rotation", new float[] { 0.0F, f1 });
      i = locala.repeatCount - 1;
      if (i > 0)
      {
        l = i * localObjectAnimator.getDuration();
        ((ObjectAnimator)localObject1).setDuration(l);
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "start animation, rotate view: " + f1 + ", duration: " + l);
        }
      }
    }
    for (;;)
    {
      localObjectAnimator.addListener(new adxt(this, (ObjectAnimator)localObject1, paramb));
      return localObjectAnimator;
      l = localObjectAnimator.getDuration();
      break;
      localObject1 = null;
    }
  }
  
  public ObjectAnimator a(adxq.b paramb, adyc.a parama)
  {
    if ((!TextUtils.isEmpty(parama.bwh)) && (parama.bQ != null))
    {
      localObject1 = a(paramb.bL, parama.bQ, parama.bwh, paramb.j.isSend());
      if ((TextUtils.isEmpty(parama.bwi)) || (parama.bR == null)) {
        break label150;
      }
    }
    for (Object localObject2 = a(paramb.bM, parama.bR, parama.bwi, paramb.u.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label204;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + parama.bwh + ", startRect: " + parama.bQ);
      }
      localObject1 = null;
      break;
      label150:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + parama.bwi + ", endRect: " + parama.bR);
      }
    }
    label204:
    int j = ((Integer)((Pair)localObject1).first).intValue();
    int k = ((Integer)((Pair)localObject1).second).intValue();
    int m = ((Integer)((Pair)localObject2).first).intValue();
    int n = ((Integer)((Pair)localObject2).second).intValue();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(adyi.b(j, k));
    ((ArrayList)localObject1).add(adyi.a(m, n));
    localObject2 = new adxq.d();
    adxq.a[] arrayOfa = new adxq.a[((ArrayList)localObject1).size()];
    int i = 0;
    if (i < arrayOfa.length)
    {
      adxq.a locala = new adxq.a();
      locala.b = paramb;
      locala.a = ((adyi)((ArrayList)localObject1).get(i));
      if (parama.bRL) {
        if (paramb.j.isSend()) {
          break label425;
        }
      }
      label425:
      for (boolean bool = true;; bool = false)
      {
        locala.at = Boolean.valueOf(bool);
        locala.bRI = paramb.j.isSend();
        locala.bRJ = parama.bRM;
        locala.rect = parama.bl;
        arrayOfa[i] = locala;
        i += 1;
        break;
      }
    }
    paramb = ObjectAnimator.ofObject(this, "pathLocation", (TypeEvaluator)localObject2, arrayOfa);
    paramb.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.mMinWidth * (float)parama.duration));
    return paramb;
  }
  
  public ObjectAnimator a(adxq.b paramb, Rect paramRect, adyc.a parama)
  {
    File localFile = null;
    if (parama == null) {
      return null;
    }
    Object localObject = localFile;
    boolean bool;
    if (paramRect != null)
    {
      localObject = localFile;
      if (parama.cLc == -1)
      {
        if (paramRect != paramb.bL) {
          break label326;
        }
        bool = paramb.j.isSend();
        paramRect = a(paramRect, parama.bl, parama.bvU, bool);
        localObject = new adyi(-1, ((Integer)paramRect.first).intValue(), ((Integer)paramRect.second).intValue());
      }
    }
    localFile = new File(this.b.a(parama.bubbleId, false), parama.zipName);
    paramRect = new ArrayList();
    int i = 0;
    label130:
    if (i < parama.cLb)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + parama.bwg + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
      adxq.a locala = new adxq.a();
      locala.filePath = str;
      locala.cacheKey = (parama.key + str);
      locala.b = paramb;
      locala.rect = parama.bl;
      if (parama.bRL) {
        if (paramb.j.isSend()) {
          break label338;
        }
      }
      label326:
      label338:
      for (bool = true;; bool = false)
      {
        locala.at = Boolean.valueOf(bool);
        locala.bRI = paramb.j.isSend();
        if (parama.cLc == -1) {
          locala.a = ((adyi)localObject);
        }
        paramRect.add(locala);
        i += 1;
        break label130;
        bool = paramb.u.isSend();
        break;
      }
    }
    paramb = new Keyframe[paramRect.size() + 1];
    float f = 1.0F / paramRect.size();
    paramb[0] = Keyframe.ofObject(0.0F, paramRect.get(0));
    i = 0;
    if (i < paramRect.size())
    {
      if (i != paramRect.size() - 1) {
        paramb[(i + 1)] = Keyframe.ofObject((i + 1) * f, paramRect.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        paramb[(i + 1)] = Keyframe.ofObject(1.0F, paramRect.get(i));
      }
    }
    paramb = PropertyValuesHolder.ofKeyframe("bitmapData", paramb);
    paramb.setEvaluator(new adxq.c());
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { paramb }).setDuration(paramRect.size() * parama.duration);
  }
  
  public Rect a(BaseBubbleBuilder.e parame, long paramLong, ListView paramListView)
  {
    int i = parame.b.bubbleId;
    paramListView = this.b.a(i, false);
    if (paramListView == null) {
      return null;
    }
    if ((adyc)paramListView.jO.get("animation_start") == null)
    {
      paramListView = paramListView.jO.values().iterator();
      while ((paramListView.hasNext()) && ((adyc)paramListView.next() == null)) {}
    }
    paramListView = parame.E;
    int j = paramListView.getLeft();
    i = paramListView.getTop();
    parame = (View)paramListView.getParent();
    for (;;)
    {
      if ((parame == null) || ((parame instanceof BaseChatItemLayout)))
      {
        parame = new Rect();
        parame.left = (BaseChatItemLayout.bNX + j);
        parame.right = (paramListView.getRight() - paramListView.getLeft() + j - BaseChatItemLayout.bNX);
        parame.top = (BaseChatItemLayout.bNV + i);
        parame.bottom = (paramListView.getBottom() - paramListView.getTop() + i - BaseChatItemLayout.bNW);
        return parame;
      }
      j += parame.getLeft();
      i += parame.getTop();
      parame = parame.getParent();
      if ((parame instanceof View)) {
        parame = (View)parame;
      } else {
        parame = null;
      }
    }
  }
  
  public Pair<Integer, Integer> a(Rect paramRect1, Rect paramRect2, String paramString, boolean paramBoolean)
  {
    int i = 0;
    int j;
    int k;
    int m;
    switch (paramString.charAt(0))
    {
    default: 
      j = 0;
      k = paramRect2.top;
      m = paramString.charAt(1);
      if (paramBoolean) {
        switch (m)
        {
        }
      }
      break;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(i + paramRect2.left), Integer.valueOf(j + k));
      j = paramRect1.top;
      break;
      j = (paramRect1.bottom - paramRect1.top) / 2;
      break;
      j = paramRect1.bottom;
      break;
      i = paramRect1.left;
      continue;
      i = (paramRect1.right - paramRect1.left) / 2;
      continue;
      i = paramRect1.right;
      continue;
      int n = paramRect2.left + paramRect2.right;
      switch (m)
      {
      default: 
        break;
      case 67: 
        i = (paramRect1.right - paramRect1.left) / 2 - n - paramRect2.left;
        break;
      case 76: 
        i = paramRect1.right - n - paramRect2.left;
        break;
      case 82: 
        i = paramRect1.left - n - paramRect2.left;
      }
    }
  }
  
  public void a(adxq.b paramb)
  {
    paramb.sq.setVisibility(8);
    this.c.removeView(paramb.sq);
    this.eP.remove(Long.valueOf(paramb.VK));
    if (this.eP.size() == 0) {
      bZL();
    }
  }
  
  public void a(adyc paramadyc, int paramInt)
  {
    File localFile = new File(this.b.a(paramInt, false), paramadyc.zipName);
    paramInt = 0;
    if (paramInt < paramadyc.cLb)
    {
      Object localObject1 = localFile.getAbsolutePath() + File.separatorChar + paramadyc.bwg + String.format("%04d.png", new Object[] { Integer.valueOf(paramInt + 1) });
      String str = paramadyc.key + (String)localObject1;
      if (!this.eQ.containsKey(str))
      {
        Object localObject3 = BaseApplicationImpl.sImageCache.get(str);
        if ((localObject3 != null) && ((localObject3 instanceof Bitmap))) {
          localObject1 = (Bitmap)localObject3;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          BaseApplicationImpl.sImageCache.put(str, localObject1);
          this.eQ.put(str, localObject1);
        }
        paramInt += 1;
        break;
        try
        {
          localObject1 = BubbleManager.decodeFile((String)localObject1, null);
        }
        catch (Exception localException)
        {
          QLog.e("BubbleNewAIOAnim", 1, "decode error!", localException);
          Object localObject2 = null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.e("BubbleNewAIOAnim", 1, "decode error!", localOutOfMemoryError);
          localBitmap = null;
        }
        continue;
        Bitmap localBitmap = (Bitmap)this.eQ.get(str);
      }
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.eP.values().iterator();
    while (localIterator.hasNext())
    {
      adxq.b localb = (adxq.b)localIterator.next();
      if ((localb != null) && (localb.wS != null))
      {
        paramInt1 = wja.a(localb.VK, this.l.getAdapter());
        paramInt2 = wja.a(localb.VL, this.l.getAdapter());
        Object localObject2 = wja.a(wja.a(this.l, paramInt1));
        Object localObject1 = wja.a(wja.a(this.l, paramInt2));
        if ((localObject2 != null) && ((localObject2 instanceof BaseBubbleBuilder.e)))
        {
          localObject2 = (BaseBubbleBuilder.e)localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localb.VK + " 's bubbleView");
          }
          localb.wS = ((BaseBubbleBuilder.e)localObject2).E;
          localb.j = ((BaseBubbleBuilder.e)localObject2).mMessage;
        }
        for (;;)
        {
          if ((localObject1 == null) || (!(localObject1 instanceof BaseBubbleBuilder.e))) {
            break label311;
          }
          localObject1 = (BaseBubbleBuilder.e)localObject1;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localb.VL + " 's bubbleView");
          }
          localb.u = ((BaseBubbleBuilder.e)localObject1).mMessage;
          break;
          if (QLog.isColorLevel()) {
            QLog.w("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localb.VK);
          }
          localb.z.cancel();
        }
        label311:
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localb.VL);
        }
        localb.z.cancel();
      }
    }
    return false;
  }
  
  public void an(long paramLong1, long paramLong2)
  {
    ThreadManager.post(new BubbleInterActiveAnim.2(this, paramLong1, paramLong2), 5, null, true);
  }
  
  public void ao(long paramLong1, long paramLong2)
  {
    adxq.b localb = a(paramLong1, paramLong2);
    ObjectAnimator localObjectAnimator1;
    if (localb != null)
    {
      localObjectAnimator1 = a(localb);
      if (localObjectAnimator1 == null) {
        QLog.e("BubbleInterActiveAnim", 1, "startAnimator is null");
      }
    }
    else
    {
      return;
    }
    ObjectAnimator localObjectAnimator2 = b(localb);
    if (localObjectAnimator2 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "runningAnimator is null");
      return;
    }
    Object localObject = (adyc.a)localb.jQ.get("animation_end");
    ObjectAnimator localObjectAnimator3 = a(localb, localb.bM, (adyc.a)localObject);
    if (localObjectAnimator3 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "endAnimator is null");
      return;
    }
    localObjectAnimator3.setRepeatCount(((adyc.a)localObject).repeatCount - 1);
    localObject = c(localb);
    if (localObject == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return;
    }
    localb.z.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObject });
    localb.z.addListener(new adxs(this, localb));
    this.mAnimHandler.post(new BubbleInterActiveAnim.4(this, localb));
    this.eP.put(Long.valueOf(paramLong1), localb);
  }
  
  public ObjectAnimator b(adxq.b paramb)
  {
    Object localObject1 = (adyc)paramb.jQ.get("animation_running");
    if (!(localObject1 instanceof adyc.a)) {
      return null;
    }
    Object localObject2 = (adyc.a)localObject1;
    if (((adyc.a)localObject2).cLc == -1) {
      return null;
    }
    if (((adyc.a)localObject2).cLc == 0) {}
    for (localObject1 = a(paramb, (adyc.a)localObject2);; localObject1 = b(paramb, (adyc.a)localObject2))
    {
      localObject2 = a(paramb, paramb.bL, (adyc.a)localObject2);
      if ((localObject1 != null) && (localObject2 != null)) {
        break;
      }
      return null;
    }
    ((ObjectAnimator)localObject2).setDuration(((ObjectAnimator)localObject2).getDuration() / 2L);
    ((ObjectAnimator)localObject2).setRepeatCount(-1);
    ((ObjectAnimator)localObject1).addListener(new adxu(this, paramb, (ObjectAnimator)localObject2));
    return localObject1;
  }
  
  public ObjectAnimator b(adxq.b paramb, adyc.a parama)
  {
    float f4 = 0.0F;
    Object localObject1;
    if ((!TextUtils.isEmpty(parama.bwh)) && (parama.bQ != null))
    {
      localObject1 = a(paramb.bL, parama.bQ, parama.bwh, paramb.j.isSend());
      if ((TextUtils.isEmpty(parama.bwi)) || (parama.bR == null)) {
        break label153;
      }
    }
    for (Object localObject2 = a(paramb.bM, parama.bR, parama.bwi, paramb.u.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label207;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + parama.bwh + ", startRect: " + parama.bQ);
      }
      localObject1 = null;
      break;
      label153:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + parama.bwi + ", endRect: " + parama.bR);
      }
    }
    label207:
    int j = ((Integer)((Pair)localObject1).first).intValue();
    int k = ((Integer)((Pair)localObject1).second).intValue();
    int m = ((Integer)((Pair)localObject2).first).intValue();
    int n = ((Integer)((Pair)localObject2).second).intValue();
    float f1;
    float f2;
    float f3;
    if (parama.cLc == 1)
    {
      f1 = (m - j) * 0.25F + j;
      f2 = (n - k) * 0.1F + k;
      f3 = (m - j) * 0.25F + j;
      f4 = (n - k) * 1.0F + k;
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(adyi.b(j, k));
      ((ArrayList)localObject1).add(adyi.a(f1, f2, f3, f4, m, n));
      localObject2 = new adxq.a[((ArrayList)localObject1).size()];
      int i = 0;
      label387:
      if (i < localObject2.length)
      {
        adxq.a locala = new adxq.a();
        locala.b = paramb;
        locala.a = ((adyi)((ArrayList)localObject1).get(i));
        if (parama.bRL) {
          if (paramb.j.isSend()) {
            break label573;
          }
        }
        label573:
        for (boolean bool = true;; bool = false)
        {
          locala.at = Boolean.valueOf(bool);
          locala.bRI = paramb.j.isSend();
          locala.rect = parama.bl;
          locala.bRJ = parama.bRM;
          localObject2[i] = locala;
          i += 1;
          break label387;
          if (parama.cLc != 2) {
            break label645;
          }
          f1 = (m - j) * 0.1F + j;
          f2 = (n - k) * 0.25F + k;
          f3 = (m - j) * 1.0F + j;
          f4 = (n - k) * 0.25F + k;
          break;
        }
      }
      paramb = ObjectAnimator.ofObject(this, "pathLocation", new adxq.d(), (Object[])localObject2);
      paramb.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.mMinWidth * (float)parama.duration * 3.141592653589793D * 0.6000000238418579D));
      return paramb;
      label645:
      f3 = 0.0F;
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public ObjectAnimator c(adxq.b paramb)
  {
    adyc.a locala = (adyc.a)paramb.jQ.get("passive_animation");
    ObjectAnimator localObjectAnimator = a(paramb, paramb.bM, locala);
    if (localObjectAnimator == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return null;
    }
    localObjectAnimator.setRepeatCount(locala.repeatCount - 1);
    localObjectAnimator.addListener(new adxv(this, paramb));
    return localObjectAnimator;
  }
  
  public boolean c(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof Integer))
    {
      if (((Integer)paramVarArgs[0]).intValue() != 8) {
        return false;
      }
    }
    else {
      return false;
    }
    long l1 = ((Long)paramVarArgs[1]).longValue();
    int i;
    Object localObject;
    if ((this.l != null) && (this.l.getAdapter() != null) && (l1 > 0L))
    {
      ListAdapter localListAdapter = this.l.getAdapter();
      i = localListAdapter.getCount() - 1;
      if (i < 0) {
        break label285;
      }
      localObject = localListAdapter.getItem(i);
      if ((localObject instanceof ChatMessage))
      {
        localObject = (ChatMessage)localObject;
        if (((ChatMessage)localObject).uniseq != l1) {}
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = EmojiStickerManager.a().c((MessageRecord)localObject);
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, " contain sticker ,so stop bubble animation!");
          }
          return false;
          i -= 1;
          break;
        }
      }
      long l2 = ((Long)paramVarArgs[2]).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("BubbleInterActiveAnim", 1, "start InterActive Anim, originalSeq：" + l1 + ", targetSeq: " + l2);
      }
      if (this.b == null)
      {
        paramVarArgs = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramVarArgs instanceof QQAppInterface)) {}
        for (paramVarArgs = (QQAppInterface)paramVarArgs; paramVarArgs == null; paramVarArgs = null) {
          return false;
        }
        this.b = ((BubbleManager)paramVarArgs.getManager(44));
      }
      an(l1, l2);
      return true;
      label285:
      localObject = null;
    }
  }
  
  public boolean gp(int paramInt)
  {
    return true;
  }
  
  public void setBitmapData(adxq.a parama)
  {
    if ((parama == null) || (parama.b == null)) {}
    do
    {
      do
      {
        return;
        if ((parama.a != null) && (parama.a.mOperation == -1)) {
          setPathLocation(parama);
        }
        float f = parama.b.sq.getTranslationY();
        if ((f < this.c.getTop()) || (f > this.c.getBottom() + this.mMinHeight))
        {
          QLog.w("BubbleInterActiveAnim", 1, String.format("setBitmapData: now scroll over screen, stop bubble animator set!, y: %d, up: %d, download: %d", new Object[] { Integer.valueOf((int)f), Integer.valueOf(this.c.getTop()), Integer.valueOf(this.c.getBottom() + this.mMinHeight) }));
          this.mAnimHandler.post(new BubbleInterActiveAnim.8(this, parama));
          return;
        }
      } while (this.bwd.equalsIgnoreCase(parama.cacheKey));
      if (parama.bitmap != null)
      {
        localObject = new adxl(parama.bitmap);
        ((adxl)localObject).bRE = parama.at.booleanValue();
        parama.b.sq.setBackgroundDrawable((Drawable)localObject);
        this.bwd = parama.cacheKey;
        parama.b.sq.invalidate();
        return;
      }
      if (!this.eQ.containsKey(parama.cacheKey)) {
        break;
      }
      localObject = (Bitmap)this.eQ.get(parama.cacheKey);
    } while (localObject == null);
    Object localObject = new adxl((Bitmap)localObject);
    ((adxl)localObject).bRE = parama.at.booleanValue();
    parama.b.sq.setBackgroundDrawable((Drawable)localObject);
    this.bwd = parama.cacheKey;
    parama.b.sq.invalidate();
    return;
    QLog.e("BubbleInterActiveAnim", 1, "can't find bitmap, path: " + parama.cacheKey);
  }
  
  public void setPathLocation(adxq.a parama)
  {
    if ((parama == null) || (parama.b == null) || (parama.b.sq == null)) {
      return;
    }
    if ((parama.rect != null) && (parama.rect.right != 0) && (parama.rect.bottom != 0) && ((parama.b.sq.getWidth() != parama.rect.right) || (parama.b.sq.getHeight() != parama.rect.bottom)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "change anim view size:  to " + parama.rect.right + "-" + parama.rect.bottom + ", view width-height: " + parama.b.sq.getWidth() + "-" + parama.b.sq.getHeight());
      }
      parama.b.sq.layout(0, 0, parama.rect.right, parama.rect.bottom);
    }
    if (parama.a.mOperation != -1)
    {
      if (parama.a.rotate != 360.0F) {
        break label456;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "reset animView rotate to 0!");
      }
      parama.b.sq.setRotation(0.0F);
    }
    int i;
    int j;
    float f1;
    float f3;
    float f2;
    for (;;)
    {
      localObject = (View)parama.b.wS.getParent();
      i = 0;
      j = 0;
      if ((localObject != null) && (((View)localObject).getParent() != this.c.getParent())) {
        break;
      }
      this.c.getWidth();
      f1 = parama.a.mX;
      f3 = parama.a.mY;
      float f4 = this.l.getScrollY();
      f2 = i;
      f3 = j + (f3 - f4);
      if ((f3 >= this.c.getTop()) && (f3 <= this.c.getBottom() + this.mMinHeight)) {
        break label585;
      }
      QLog.w("BubbleInterActiveAnim", 1, String.format("setPathLocation: now scroll over screen, stop bubble animator set!, y: %d, up: %d, down: %d", new Object[] { Integer.valueOf((int)f3), Integer.valueOf(this.c.getTop()), Integer.valueOf(this.c.getBottom() + this.mMinHeight) }));
      this.mAnimHandler.post(new BubbleInterActiveAnim.9(this, parama));
      return;
      label456:
      if (parama.a.rotate != 0.0F)
      {
        parama.b.sq.setRotation(parama.a.rotate);
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "set animView rotate to " + parama.a.rotate);
        }
      }
    }
    int k = ((View)localObject).getLeft();
    int m = ((View)localObject).getTop();
    Object localObject = ((View)localObject).getParent();
    if ((localObject instanceof View)) {}
    for (localObject = (View)localObject;; localObject = null)
    {
      j = m + j;
      i = k + i;
      break;
    }
    label585:
    parama.b.sq.setTranslationX(f2 + f1);
    parama.b.sq.setTranslationY(f3);
  }
  
  public void stop()
  {
    Iterator localIterator = this.eP.values().iterator();
    while (localIterator.hasNext())
    {
      adxq.b localb = (adxq.b)localIterator.next();
      if ((localb != null) && (localb.sq != null)) {
        localb.z.cancel();
      }
    }
  }
  
  public static class a
  {
    public adyi a;
    public Boolean at = Boolean.valueOf(false);
    public adxq.b b;
    public boolean bRI = true;
    public boolean bRJ;
    public Bitmap bitmap;
    public String cacheKey = "";
    public String filePath = "";
    public int lastX;
    public int lastY;
    public int percent;
    public Rect rect = new Rect();
  }
  
  public static class b
  {
    public long VK;
    public long VL;
    public Rect bL;
    public Rect bM;
    public MessageRecord j;
    public HashMap<String, adyc> jQ = new HashMap();
    public ImageView sq;
    public MessageRecord u;
    public View wS;
    public AnimatorSet z = new AnimatorSet();
  }
  
  @TargetApi(11)
  public class c
    implements TypeEvaluator<adxq.a>
  {
    public c() {}
    
    public adxq.a a(float paramFloat, adxq.a parama1, adxq.a parama2)
    {
      return parama2;
    }
  }
  
  @TargetApi(11)
  public static class d
    implements TypeEvaluator<adxq.a>
  {
    public adxq.a a(float paramFloat, adxq.a parama1, adxq.a parama2)
    {
      long l = System.currentTimeMillis();
      float f1;
      float f2;
      adyi localadyi;
      adxq.a locala;
      if (parama2.a.mOperation == 2)
      {
        f1 = 1.0F - paramFloat;
        f2 = f1 * f1 * f1 * parama1.a.mX + 3.0F * f1 * f1 * paramFloat * parama2.a.vz + 3.0F * f1 * paramFloat * paramFloat * parama2.a.vB + paramFloat * paramFloat * paramFloat * parama2.a.mX;
        float f3 = parama1.a.mY;
        float f4 = parama2.a.vA;
        f1 = f1 * 3.0F * paramFloat * paramFloat * parama2.a.vC + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * parama2.a.mY;
        localadyi = adyi.b(f2, f1);
        locala = new adxq.a();
        localadyi.alpha = (parama1.a.alpha + (parama2.a.alpha - parama1.a.alpha) * paramFloat);
        locala.a = localadyi;
        locala.b = parama2.b;
        locala.bitmap = parama2.bitmap;
        locala.cacheKey = parama2.cacheKey;
        locala.filePath = parama2.filePath;
        locala.at = parama2.at;
        locala.bRI = parama2.bRI;
        locala.rect = parama2.rect;
        if (parama1.bRJ) {
          if (paramFloat < 1.0D) {
            break label758;
          }
        }
      }
      label758:
      for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
      {
        locala.percent = i;
        if ((locala.percent - parama2.percent >= 5) || (parama2.percent == 0))
        {
          if ((parama2.lastX == 0) || (parama2.lastY == 0))
          {
            parama2.lastX = ((int)parama1.a.mX);
            parama2.lastY = ((int)parama1.a.mY);
          }
          double d1 = Math.abs(f1 - parama2.lastY);
          double d2 = Math.abs(f2 - parama2.lastX);
          double d3 = Math.pow(d1, 2.0D);
          d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
          if ((d2 != 0.0D) && (d1 != 0.0D))
          {
            localadyi.rotate = ((float)Math.toDegrees(Math.asin(d1 / d2)));
            if (!parama2.bRI) {
              localadyi.rotate = (-localadyi.rotate);
            }
          }
          if (Math.abs(localadyi.rotate) > 90.0F)
          {
            if (QLog.isColorLevel()) {
              QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localadyi.rotate + ", reset to 0!");
            }
            localadyi.rotate = 0.0F;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localadyi.rotate + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
            QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
          }
          parama2.percent = locala.percent;
        }
        if (paramFloat == 1.0F) {
          localadyi.rotate = 360.0F;
        }
        parama2.lastX = ((int)f2);
        parama2.lastY = ((int)f1);
        return locala;
        if (parama2.a.mOperation == 1)
        {
          f1 = parama1.a.mX;
          f2 = (parama2.a.mX - parama1.a.mX) * paramFloat + f1;
          f1 = parama1.a.mY + (parama2.a.mY - parama1.a.mY) * paramFloat;
          break;
        }
        f2 = parama2.a.mX;
        f1 = parama2.a.mY;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxq
 * JD-Core Version:    0.7.0.1
 */