package com.tencent.mobileqq.activity.aio.helper;

import acfp;
import adph;
import ajlc;
import amdf;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqfx;
import aqha;
import aqhq;
import aqju;
import aqul;
import arhz;
import ausj;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import jof;
import mqq.app.AppActivity;
import wja;
import wki;
import wkj;
import wts;
import wtt;
import wtu;
import wtv;
import wtw;
import wtx;
import wty;
import wtz;
import wua;
import wvm;
import wvs;
import wwf;
import wxk;
import xtm;
import xwn;
import xys;

public class AIOLongShotHelper
  implements wvs, wwf
{
  private CheckBox A;
  private TextView Iv;
  private TextView Iw;
  private TextView Ix;
  private TextView Iy;
  private arhz jdField_a_of_type_Arhz;
  private MergeBitmapTask jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask;
  private int bRC;
  private int bRD;
  private int bRE;
  private int bRF;
  private int bRG;
  private boolean bfV;
  private boolean bfW;
  private boolean bfX;
  private boolean bfY;
  private Set<ChatMessage> bl = new HashSet();
  private BaseChatPie jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ChatXListView jdField_c_of_type_ComTencentMobileqqBubbleChatXListView;
  private wki jdField_c_of_type_Wki;
  private Button dS;
  private Bitmap dY;
  private Bitmap dZ;
  private Runnable el;
  private RelativeLayout hw;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  private Field r;
  private List<ViewGroup> rT = new ArrayList();
  private List<Bitmap> rU = new ArrayList();
  
  public AIOLongShotHelper(wvm paramwvm, BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    paramwvm.a(this);
  }
  
  private Bitmap E(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: drawingCache == null");
      return null;
    }
    if (this.bRE == -1) {}
    Object localObject;
    for (i = this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;; i = this.bRE - this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition())
    {
      if ((i < 0) || (i >= this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())) {
        QLog.e("AIOLongShotHelper", 1, "getCropBitmap: getFirstVisiblePosition=" + this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition() + ", mSelectionPosition=" + this.bRE);
      }
      localObject = this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if (localObject != null) {
        break;
      }
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: selectedView == null");
      return null;
    }
    int j = ((View)localObject).getBottom() - this.bRD;
    if (j <= paramBitmap.getHeight())
    {
      i = j;
      if (j > 0) {}
    }
    else
    {
      i = paramBitmap.getHeight();
      QLog.e("AIOLongShotHelper", 1, "getCropBitmap: invalid height mOverlapY=" + this.bRD + ", getBottom = " + ((View)localObject).getBottom());
    }
    try
    {
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), i);
      paramBitmap = (Bitmap)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AIOLongShotHelper", 1, "getCropBitmap: ", localThrowable);
        try
        {
          paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), i);
        }
        catch (Throwable paramBitmap)
        {
          QLog.e("AIOLongShotHelper", 1, "getCropBitmap: ", paramBitmap);
          paramBitmap = null;
        }
      }
    }
    return paramBitmap;
  }
  
  private void F(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      f(false, false, null);
      return;
    }
    QLog.d("AIOLongShotHelper", 1, "encodeAndWritePNG() called with: bitmap.bytes = [" + paramBitmap.getByteCount() / 1048576L + "MB], width=" + paramBitmap.getWidth() + ", height = " + paramBitmap.getHeight());
    String str = aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/aio_long_shot/");
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    for (;;)
    {
      str = str + System.currentTimeMillis() + ".png";
      aqhq.a(paramBitmap, str, Bitmap.CompressFormat.PNG);
      paramBitmap.recycle();
      f(false, true, str);
      return;
      aqhq.cm(str);
    }
  }
  
  private boolean RR()
  {
    return this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getSharedPreferences("AIOLongShotHelper", 0).getBoolean("KEY_IS_FIRST_USE", true);
  }
  
  private boolean RU()
  {
    int j = this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int i = 0;
    if (i < this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      Object localObject = this.jdField_c_of_type_Wki.getItem(j + i);
      ChatMessage localChatMessage;
      if ((localObject instanceof ChatMessage))
      {
        localObject = (ChatMessage)localObject;
        localChatMessage = a((ChatMessage)localObject);
        if (localChatMessage == null) {}
        do
        {
          return false;
          if (!((ChatMessage)localObject).mNeedTimeStamp) {
            break label135;
          }
          if (!localChatMessage.mNeedTimeStamp) {
            break;
          }
        } while (((ChatMessage)localObject).getViewHeight() != localChatMessage.getViewHeight());
      }
      label135:
      label179:
      do
      {
        int k;
        do
        {
          do
          {
            i += 1;
            break;
            k = p(this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i).findViewById(2131364534));
          } while (((ChatMessage)localObject).getViewHeight() == localChatMessage.getViewHeight() + k);
          return false;
          if (!localChatMessage.mNeedTimeStamp) {
            break label179;
          }
          k = p(this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i).findViewById(2131364534));
        } while (((ChatMessage)localObject).getViewHeight() == localChatMessage.getViewHeight() - k);
        return false;
      } while (((ChatMessage)localObject).getViewHeight() == localChatMessage.getViewHeight());
      return false;
    }
    return true;
  }
  
  public static AIOLongShotHelper a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)localObject).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null)) {
        return (AIOLongShotHelper)((ChatFragment)localObject).a().a(15);
      }
    }
    return null;
  }
  
  private ChatMessage a(ChatMessage paramChatMessage)
  {
    Iterator localIterator = this.bl.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (localChatMessage.uniseq == paramChatMessage.uniseq) {
        return localChatMessage;
      }
    }
    return null;
  }
  
  private static void a(Activity paramActivity, View paramView, int paramInt, ausj paramausj, String paramString, a parama)
  {
    if (paramView == null)
    {
      paramausj.dismiss();
      return;
    }
    String str = paramausj.getContent(paramInt);
    if (str == null)
    {
      paramausj.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      paramausj.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131694752)))
    {
      z(paramActivity, paramString);
      report("0X8009DF1");
    }
    for (;;)
    {
      paramausj.dismiss();
      return;
      if (str.equals(paramView.getResources().getString(2131694767)))
      {
        report("0X800A502");
        if ((paramActivity instanceof SplashActivity))
        {
          paramView = ((AppActivity)paramActivity).getAppRuntime();
          if ((paramView instanceof QQAppInterface))
          {
            paramView = (QQAppInterface)paramView;
            PicShareToWX.a().b(paramActivity, paramView, paramString, 2);
          }
        }
        else
        {
          PicShareToWX.a(paramString, paramActivity, 2);
        }
      }
      else if (str.equals(paramView.getResources().getString(2131694762)))
      {
        paramActivity = new File(paramString);
        paramString = paramActivity.getAbsolutePath();
        xtm.a((Activity)paramView.getContext(), paramActivity, Utils.Crc64String(paramString));
        if (parama != null) {
          parama.cbZ();
        }
        report("0X8009DF2");
      }
      else if (str.equals(paramView.getResources().getString(2131694750)))
      {
        if (parama != null) {
          parama.cca();
        }
        paramActivity.runOnUiThread(new AIOLongShotHelper.4(paramString, paramActivity));
        report("0X8009DF3");
      }
      else if (str.equals(paramView.getResources().getString(2131694185)))
      {
        amdf.o(paramActivity, paramString, 100);
        report("0X800A77C");
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, a parama)
  {
    ausj localausj = ausj.d(paramActivity);
    localausj.addButton(2131694752);
    if ((PicShareToWX.a().isEnable()) && (PicShareToWX.a().nQ(paramString))) {
      localausj.addButton(2131694767);
    }
    localausj.addButton(2131694762);
    localausj.addButton(2131694750);
    localausj.addButton(2131694185);
    localausj.addCancelButton(2131721058);
    localausj.a(new wtw(paramActivity, localausj, paramString, parama));
    localausj.show();
    report("0X8009DF0");
  }
  
  private void a(ChatMessage paramChatMessage, Bitmap paramBitmap)
  {
    this.bfV = true;
    cbP();
    if (paramBitmap == null) {
      cbS();
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.c(paramChatMessage);
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.b.GO(true);
    if (RR())
    {
      za(false);
      asF();
    }
    if ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xwn))
    {
      paramChatMessage = (wxk)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
      if (paramChatMessage != null) {
        paramChatMessage.zl(false);
      }
    }
    if (((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) || ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xys))) {
      this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.aQ.setVisibility(8);
    }
  }
  
  private void aA(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.dZ;
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, paramCanvas.getHeight() - localBitmap.getHeight(), null);
    }
  }
  
  private Drawable aB()
  {
    return ((ViewGroup)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.b.getParent()).getChildAt(0).getBackground();
  }
  
  private List<ChatMessage> aE(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage1 = (ChatMessage)paramList.next();
      ChatMessage localChatMessage2 = b(localChatMessage1);
      if (QLog.isColorLevel())
      {
        QLog.d("AIOLongShotHelper", 2, "copy() called with: cm = [" + localChatMessage1 + "]");
        QLog.d("AIOLongShotHelper", 2, "copy() called with: copyChatMessage = [" + localChatMessage2 + "]");
      }
      if (localChatMessage2 == null)
      {
        QLog.e("AIOLongShotHelper", 1, "copy src message failed. Try to use src message.", new IllegalArgumentException(localChatMessage1.toString()));
        localArrayList.add(localChatMessage1);
      }
      else
      {
        localArrayList.add(localChatMessage2);
      }
    }
    return localArrayList;
  }
  
  private void af(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.dY;
    if (localBitmap != null)
    {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
      localBitmap.recycle();
    }
  }
  
  private Bitmap ak()
  {
    if (this.dY == null)
    {
      QLog.e("AIOLongShotHelper", 1, "mergeBitmaps: mTitleBitmap == null");
      return null;
    }
    if (this.dZ == null)
    {
      QLog.e("AIOLongShotHelper", 1, "mergeBitmaps: mInputBarBitmap == null");
      return null;
    }
    Object localObject1 = this.rU.iterator();
    int i = 0;
    for (int j = 0; ((Iterator)localObject1).hasNext(); j = k)
    {
      localObject2 = (Bitmap)((Iterator)localObject1).next();
      if (localObject2 == null)
      {
        QLog.e("AIOLongShotHelper", 1, "mergeBitmaps: mBitmapList.bm == null");
        return null;
      }
      k = j;
      if (j == 0) {
        k = ((Bitmap)localObject2).getWidth();
      }
      i = ((Bitmap)localObject2).getHeight() + i;
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "mergeBitmaps() listViewHeight = " + i);
      }
    }
    int k = this.dY.getHeight();
    cbY();
    localObject1 = b(j, i, k);
    cbY();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = new Canvas((Bitmap)localObject1);
    ((Canvas)localObject2).setDensity(this.dY.getDensity());
    af((Canvas)localObject2);
    i = ((Canvas)localObject2).save();
    ((Canvas)localObject2).translate(0.0F, k);
    drawBackground((Canvas)localObject2);
    ((Canvas)localObject2).restoreToCount(i);
    i = ((Canvas)localObject2).save();
    ((Canvas)localObject2).translate(0.0F, k);
    az((Canvas)localObject2);
    ((Canvas)localObject2).restoreToCount(i);
    aA((Canvas)localObject2);
    ((Canvas)localObject2).setBitmap(null);
    return localObject1;
  }
  
  private void asF()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    int i = wja.dp2px(248.0F, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getResources());
    int j = (int)(i * 420.0F / 472.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = j;
    localObject = URLDrawable.getDrawable("https://hbd.url.cn/myapp/qq_desk/mobileQQ_screenshoot/mobileQQ_screenshoot.gif", (URLDrawable.URLDrawableOptions)localObject);
    localObject = aqha.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext, 230).setTitle(acfp.m(2131702262)).setMessage(acfp.m(2131702266)).setPreviewImage((Drawable)localObject, true, 0).setPreviewFixDimension(i, j);
    ((aqju)localObject).setPositiveButton(acfp.m(2131702267), new wtx(this));
    ((aqju)localObject).show();
  }
  
  private void az(Canvas paramCanvas)
  {
    int i = 0;
    int j = this.rU.size() - 1;
    if (j >= 0)
    {
      Bitmap localBitmap = (Bitmap)this.rU.get(j);
      if (localBitmap == null) {
        QLog.e("AIOLongShotHelper", 1, "drawListView: mBitmapList.bm == null");
      }
      for (;;)
      {
        j -= 1;
        break;
        paramCanvas.drawBitmap(localBitmap, 0.0F, i, null);
        int k = localBitmap.getHeight();
        localBitmap.recycle();
        i += k;
      }
    }
  }
  
  private Bitmap b(int paramInt1, int paramInt2, int paramInt3)
  {
    i = 0;
    try
    {
      int k = this.dZ.getHeight();
      j = paramInt3 + paramInt2 + k;
      i = j;
      if (!QLog.isColorLevel()) {
        break label255;
      }
      i = j;
      QLog.d("AIOLongShotHelper", 2, "tryCreateBitmap() height = [" + j + "], inputBarBitmapHeight = [" + k + "], listViewHeight = [" + paramInt2 + "], titleBarHeight = [" + paramInt3 + "]");
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        int j;
        Bitmap localBitmap1;
        QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: 1 ", localThrowable1);
        Runtime.getRuntime().gc();
        try
        {
          Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.RGB_565);
          return localBitmap2;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: 2 ", localThrowable2);
          Runtime.getRuntime().gc();
          try
          {
            Bitmap localBitmap3 = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.RGB_565);
            return localBitmap3;
          }
          catch (Throwable localThrowable3)
          {
            QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: 3 ", localThrowable3);
            return null;
          }
        }
        if ((paramInt1 < 30000) && (j < 30000)) {
          if (paramInt1 * j < 200000000) {}
        }
      }
    }
    i = j;
    QLog.e("AIOLongShotHelper", 1, "tryCreateBitmap: size overflow. width = " + paramInt1 + ", height = " + j + ", w*h = " + paramInt1 * j);
    return null;
    i = j;
    localBitmap1 = Bitmap.createBitmap(paramInt1, j, Bitmap.Config.RGB_565);
    return localBitmap1;
  }
  
  private ChatMessage b(ChatMessage paramChatMessage)
  {
    paramChatMessage = (ChatMessage)paramChatMessage.deepCopyByReflect();
    if (paramChatMessage != null)
    {
      if ((paramChatMessage instanceof MessageForArkApp)) {
        ((MessageForArkApp)paramChatMessage).arkContainer = null;
      }
      if ((paramChatMessage instanceof MessageForArkFlashChat)) {
        ((MessageForArkFlashChat)paramChatMessage).arkContainer = null;
      }
      Object localObject;
      if ((paramChatMessage instanceof MessageForArkBabyqReply))
      {
        localObject = (MessageForArkBabyqReply)paramChatMessage;
        if ((((MessageForArkBabyqReply)localObject).mArkBabyqReplyCardList != null) && (((MessageForArkBabyqReply)localObject).mArkBabyqReplyCardList.size() > 0))
        {
          localObject = ((MessageForArkBabyqReply)localObject).mArkBabyqReplyCardList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)((Iterator)localObject).next();
            if (localArkBabyqCardInfo != null) {
              localArkBabyqCardInfo.mArkBabyqContainer = null;
            }
          }
        }
      }
      if ((paramChatMessage instanceof MessageForApollo))
      {
        localObject = ((MessageForApollo)paramChatMessage).mApolloGameArkMsg;
        if (localObject != null) {
          ((MessageForArkApp)localObject).arkContainer = null;
        }
      }
    }
    return paramChatMessage;
  }
  
  private void cbK()
  {
    if (!this.bl.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      this.Iv.setEnabled(bool);
      this.Iw.setEnabled(bool);
      this.A.setEnabled(bool);
      this.Ix.setEnabled(bool);
      this.dS.setEnabled(bool);
      return;
    }
  }
  
  private void cbM()
  {
    if (RR()) {
      ThreadManagerV2.executeOnSubThread(new AIOLongShotHelper.6(this));
    }
  }
  
  private void cbO()
  {
    Object localObject = new ArrayList();
    List localList = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.getList();
    int i = 0;
    while (i < localList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(i);
      if (this.bl.contains(localChatMessage)) {
        ((List)localObject).add(localChatMessage);
      }
      i += 1;
    }
    localObject = aE((List)localObject);
    cbW();
    cbU();
    gj((List)localObject);
    cbQ();
  }
  
  private void cbP()
  {
    this.rU.clear();
    this.bRD = 0;
    this.bRE = -1;
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_c_of_type_Wki = null;
    this.dY = null;
  }
  
  private void cbQ()
  {
    if (this.el == null) {
      this.el = new AIOLongShotHelper.13(this);
    }
    this.mUiHandler.removeCallbacks(this.el);
    int i = 150;
    List localList = this.jdField_c_of_type_Wki.getList();
    int k = localList.size() - 1;
    for (;;)
    {
      int j = i;
      if (k >= 0)
      {
        j = i;
        if (k >= localList.size() - 1 - 10)
        {
          ChatMessage localChatMessage = (ChatMessage)localList.get(k);
          if (!(localChatMessage instanceof MessageForPic))
          {
            j = i;
            if (!(localChatMessage instanceof MessageForScribble)) {}
          }
          else
          {
            j = Math.max(250, i);
          }
          i = j;
          if ((localChatMessage instanceof MessageForShortVideo)) {
            i = Math.max(500, j);
          }
          if ((!(localChatMessage instanceof MessageForArkApp)) && (!(localChatMessage instanceof MessageForApollo))) {
            break label205;
          }
          j = Math.max(750, i);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "scheduleSampleBitmap() called maxDelay = " + j);
      }
      this.mUiHandler.postDelayed(this.el, j);
      return;
      label205:
      k -= 1;
    }
  }
  
  private void cbR()
  {
    if ((!RU()) && (this.bRG < 3))
    {
      QLog.e("AIOLongShotHelper", 1, "sampleBitmap: not rendered now. Try again. mRetryRender = " + this.bRG);
      cbQ();
      this.bRG += 1;
      return;
    }
    this.bRG = 0;
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setDrawingCacheEnabled(true);
    Object localObject = E(this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getDrawingCache());
    this.rU.add(localObject);
    x(this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView, false);
    int i = this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    localObject = this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((i == 0) && (((View)localObject).getTop() >= 0))
    {
      cbU();
      cbV();
      cbT();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask.cancel();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask = new MergeBitmapTask(this);
      ThreadManagerV2.executeOnSubThread(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask);
      return;
    }
    this.bRD = (((View)localObject).getBottom() - this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.getTop());
    if (this.bRD == ((View)localObject).getHeight())
    {
      this.bRE = (i - 1);
      this.bRD = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "scheduleSampleBitmap() called y = " + this.bRD + ", position = " + this.bRE);
      }
      localObject = this.jdField_c_of_type_Wki.getList();
      i = ((List)localObject).size() - 1;
      while (i > this.bRE)
      {
        ((List)localObject).remove(i);
        i -= 1;
      }
      this.bRE = i;
    }
    this.jdField_c_of_type_Wki.notifyDataSetChanged();
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.bRE, -this.bRD);
    cbQ();
  }
  
  private void cbT()
  {
    NavBarAIO localNavBarAIO = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (RT())
    {
      this.rT.clear();
      eY(localNavBarAIO);
    }
    View localView1 = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().findViewById(2131379823);
    View localView2 = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().findViewById(2131378923);
    localView1.setVisibility(0);
    localView2.setVisibility(0);
    localNavBarAIO.setDrawingCacheEnabled(true);
    this.dY = localNavBarAIO.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
    if (this.dY == null) {
      QLog.e("AIOLongShotHelper", 1, "createTitleBitmap: mTitleBitmap == null");
    }
    localNavBarAIO.setDrawingCacheEnabled(false);
    localView1.setVisibility(4);
    localView2.setVisibility(4);
    if (RT())
    {
      eX(localNavBarAIO);
      this.rT.clear();
    }
  }
  
  private void cbU()
  {
    View localView;
    if (this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      localView = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      if ((localView instanceof FrameLayout)) {}
    }
    else
    {
      return;
    }
    ((FrameLayout)localView).removeView(this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView = null;
  }
  
  private void cbV()
  {
    adph.bQg = this.bfY;
  }
  
  private void cbW()
  {
    this.bfY = adph.bQg;
    adph.bQg = true;
  }
  
  private void cbX()
  {
    List localList = ajlc.a().fH();
    if ((localList == null) || (localList.isEmpty())) {
      return;
    }
    ajlc.a().lx(localList);
    this.bl.addAll(localList);
  }
  
  private void cbY()
  {
    Runtime localRuntime = Runtime.getRuntime();
    long l1 = (localRuntime.totalMemory() - localRuntime.freeMemory()) / 1048576L;
    long l2 = localRuntime.maxMemory() / 1048576L;
    QLog.e("AIOLongShotHelper", 1, "printMemoryInfo: maxHeapSizeInMB=" + l2 + "MB, usedMemInMB=" + l1 + "MB, availHeapSizeInMB=" + (l2 - l1) + "MB");
  }
  
  private void complete(String paramString)
  {
    if (paramString == null) {
      return;
    }
    a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mActivity, paramString, new wtv(this));
  }
  
  private void dm(Context paramContext)
  {
    hideProgressDialog();
    this.jdField_a_of_type_Arhz = new arhz(paramContext, paramContext.getResources().getDimensionPixelSize(2131299627));
    this.jdField_a_of_type_Arhz.setMessage(acfp.m(2131702264));
    this.jdField_a_of_type_Arhz.show();
  }
  
  private void drawBackground(Canvas paramCanvas)
  {
    wkj localwkj = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.a;
    Object localObject;
    if (localwkj != null)
    {
      localObject = localwkj.img;
      boolean bool = jof.a().dd(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl);
      QLog.d("AIOLongShotHelper", 1, "drawBackground() called with: isAnonymous = [" + bool + "]");
      if (bool)
      {
        Drawable localDrawable = aB();
        localObject = localDrawable;
        if (localDrawable == null)
        {
          QLog.e("AIOLongShotHelper", 1, "drawBackground: Anonymous bg == null");
          localObject = localwkj.img;
        }
      }
      if (localObject != null) {
        break label190;
      }
      localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130851035);
    }
    label190:
    for (;;)
    {
      if (localObject == null)
      {
        QLog.e("AIOLongShotHelper", 1, "drawBackground: getDefaultThemeDrawable bg == null");
        return;
      }
      int i = paramCanvas.getHeight();
      paramCanvas.save();
      while (i > 0)
      {
        int j = ((Drawable)localObject).getBounds().height();
        i -= j;
        ((Drawable)localObject).draw(paramCanvas);
        paramCanvas.translate(0.0F, j);
      }
      paramCanvas.restore();
      return;
    }
  }
  
  private void eX(View paramView)
  {
    paramView = this.rT.iterator();
    while (paramView.hasNext()) {
      ((ViewGroup)paramView.next()).setClipChildren(false);
    }
  }
  
  private void eY(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      if (!getClipChildren(paramView)) {
        this.rT.add(paramView);
      }
      paramView.setClipChildren(true);
      int i = 0;
      while (i < paramView.getChildCount())
      {
        eY(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  private void eZ(View paramView)
  {
    this.bRC = 2;
    paramView.setEnabled(false);
    dm(paramView.getContext());
    cbO();
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.mUiHandler.post(new AIOLongShotHelper.1(this, paramBoolean1, paramBoolean2, paramString));
  }
  
  private void fa(View paramView)
  {
    this.bRC = 1;
    paramView.setEnabled(false);
    dm(paramView.getContext());
    cbO();
  }
  
  private void fb(View paramView)
  {
    this.bRC = 0;
    paramView.setEnabled(false);
    dm(paramView.getContext());
    this.mUiHandler.post(new AIOLongShotHelper.12(this));
  }
  
  private void fc(View paramView)
  {
    paramView = paramView.getDrawingCache();
    int i = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
    this.dZ = Bitmap.createBitmap(paramView, 0, i, paramView.getWidth(), paramView.getHeight() - i);
    if (this.dZ == null) {
      QLog.e("AIOLongShotHelper", 1, "createInputBarBitmap: mInputBarBitmap == null");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "createInputBarBitmap() mInputBarHeight = [" + this.bRF + "]");
      }
      return;
      this.bRF = this.dZ.getHeight();
    }
  }
  
  private int fg(int paramInt)
  {
    if (this.bl.isEmpty()) {
      return -1;
    }
    List localList = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.getList();
    paramInt -= 1;
    while ((paramInt >= 0) && (paramInt < localList.size()))
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(paramInt);
      if (this.bl.contains(localChatMessage)) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  private int fh(int paramInt)
  {
    if (this.bl.isEmpty()) {
      return -1;
    }
    List localList = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.getList();
    while ((paramInt >= 0) && (paramInt < localList.size()))
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(paramInt);
      if (this.bl.contains(localChatMessage)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private void fz(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "regionCheck() called with: start = [" + paramInt1 + "], end = [" + paramInt2 + "]");
    }
    List localList = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.getList();
    while ((paramInt1 >= 0) && (paramInt1 < localList.size()) && (paramInt1 < paramInt2))
    {
      this.bl.add(localList.get(paramInt1));
      paramInt1 += 1;
    }
  }
  
  private boolean getClipChildren(ViewGroup paramViewGroup)
  {
    try
    {
      if (this.r == null) {
        this.r = ViewGroup.class.getDeclaredField("mGroupFlags");
      }
      this.r.setAccessible(true);
      int i = this.r.getInt(paramViewGroup);
      return (i & 0x1) != 0;
    }
    catch (NoSuchFieldException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
      return true;
    }
    catch (IllegalAccessException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
    return true;
  }
  
  private int getTitleHeight()
  {
    return this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
  }
  
  private void gj(List<ChatMessage> paramList)
  {
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView = new ChatXListView(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setDividerHeight(0);
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setVerticalScrollBarEnabled(false);
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setClipChildren(false);
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setShouldPlayVideo(false);
    this.jdField_c_of_type_Wki = new wki(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mActivity, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_c_of_type_Wki.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.a());
    this.jdField_c_of_type_Wki.a(paramList, null);
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_c_of_type_Wki);
    paramList = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
    if (!(paramList instanceof FrameLayout)) {
      return;
    }
    paramList = (FrameLayout)paramList;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(localLayoutParams);
    paramList.addView(this.jdField_c_of_type_ComTencentMobileqqBubbleChatXListView, 0);
  }
  
  private void hideProgressDialog()
  {
    if (this.jdField_a_of_type_Arhz != null)
    {
      this.jdField_a_of_type_Arhz.dismiss();
      this.jdField_a_of_type_Arhz = null;
    }
  }
  
  private int p(View paramView)
  {
    if (paramView == null) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return 0;
      localLayoutParams = paramView.getLayoutParams();
    } while (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams));
    return ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin + paramView.getHeight() + ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin;
  }
  
  public static void report(String paramString)
  {
    anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private void su()
  {
    if (!this.bl.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      this.Iy.setEnabled(bool);
      return;
    }
  }
  
  private void w(View paramView, boolean paramBoolean)
  {
    this.bfW = paramBoolean;
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.wm(paramBoolean);
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.notifyDataSetChanged();
  }
  
  private int wf()
  {
    Iterator localIterator = this.bl.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((ChatMessage)localIterator.next()).getViewHeight() + i) {}
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "getCheckedMessagesHeight() called height = " + i);
    }
    return i;
  }
  
  private void x(View paramView, boolean paramBoolean)
  {
    paramView.setDrawingCacheEnabled(paramBoolean);
    paramView.destroyDrawingCache();
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      while (i < ((ViewGroup)paramView).getChildCount())
      {
        x(((ViewGroup)paramView).getChildAt(i), paramBoolean);
        i += 1;
      }
    }
  }
  
  private void xH(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "onGenerateFile() called with: path = [" + paramString + "]");
    }
    switch (this.bRC)
    {
    }
    for (;;)
    {
      hideProgressDialog();
      return;
      this.Iv.setEnabled(true);
      xJ(paramString);
      continue;
      this.Iw.setEnabled(true);
      xI(paramString);
      continue;
      this.dS.setEnabled(true);
      complete(paramString);
    }
  }
  
  private void xI(String paramString)
  {
    if (paramString == null) {
      return;
    }
    FragmentActivity localFragmentActivity = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mActivity;
    localFragmentActivity.startActivityForResult(EditPicActivity.a(localFragmentActivity, paramString, true, true, true, true, true, false, false, false, 2, 122, 0, false, null), 18003);
  }
  
  private void xJ(String paramString)
  {
    if (paramString == null) {
      return;
    }
    FragmentActivity localFragmentActivity = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mActivity;
    Intent localIntent = new Intent();
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    localIntent.putExtra("uin", this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl);
    localIntent.putExtra("uintype", this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ);
    localIntent.putExtra("troop_uin", this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.troopUin);
    localIntent.putExtra("uinname", this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTn);
    if ((localFragmentActivity instanceof SplashActivity))
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = wja.a(localIntent, null);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("key_activity_code", ChatActivityUtils.d(localFragmentActivity));
      if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ != 9501) {
        break label411;
      }
      if (!(localFragmentActivity instanceof SplashActivity)) {
        break label394;
      }
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = wja.a(localIntent, null);
      label208:
      localIntent.putExtra(aqfx.REQUEST_CODE, 80);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_OVERLOAD", false);
      localIntent.setClass(localFragmentActivity, NewPhotoPreviewActivity.class);
      localIntent.addFlags(603979776);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
      localIntent.putExtra("enter_from", 42);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(localFragmentActivity, NewPhotoPreviewActivity.class);
      localIntent.addFlags(603979776);
      localFragmentActivity.startActivityForResult(localIntent, 18004);
      this.bfX = true;
      return;
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break;
      label394:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label208;
      label411:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("key_confess_topicid", this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.topicId);
    }
  }
  
  public static void y(Activity paramActivity, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramActivity, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramIntent.getExtras();
    if (localObject != null) {
      localArrayList.add(((Bundle)localObject).getString("forward_filepath"));
    }
    for (;;)
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("PhotoConst.PHOTO_COUNT", localArrayList.size());
      localObject = ForwardUtils.a(paramIntent);
      localIntent.putExtra("uin", ((SessionInfo)localObject).aTl);
      localIntent.putExtra("uintype", ((SessionInfo)localObject).cZ);
      localIntent.putExtra("troop_uin", ((SessionInfo)localObject).troopUin);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("entrance", ((SessionInfo)localObject).entrance);
      localIntent.putExtra("KEY_MSG_FORWARD_ID", paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1));
      if (localArrayList.size() == 1) {
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      }
      paramActivity.startActivityForResult(localIntent, 18002);
      return;
      QLog.e("AIOLongShotHelper", 1, "sendPicToFriend: empty extras");
    }
  }
  
  private static void z(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtras(new Bundle());
    localIntent.putExtra("forward_type", 1);
    localIntent.setData(Uri.parse(paramString));
    paramActivity.startActivityForResult(localIntent, 18001);
  }
  
  private void za(boolean paramBoolean)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getSharedPreferences("AIOLongShotHelper", 0).edit().putBoolean("KEY_IS_FIRST_USE", paramBoolean).apply();
  }
  
  public int[] C()
  {
    return new int[] { 3, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      cbM();
      return;
    }
    cbN();
  }
  
  public boolean RS()
  {
    return this.bfV;
  }
  
  public boolean RT()
  {
    return this.bfW;
  }
  
  public boolean RV()
  {
    return (this.bfV) && (this.bfW);
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    paramLinearLayout.setGravity(16);
    this.Iv = new TextView(paramContext);
    this.Iv.setId(2131364466);
    this.Iv.setText(2131690182);
    this.Iv.setTextSize(1, 14.0F);
    this.Iv.setTextColor(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getResources().getColorStateList(2131165313));
    int i = wja.dp2px(12.0F, paramLinearLayout.getResources());
    this.Iv.setPadding(i, 0, i, 0);
    this.Iv.setGravity(17);
    Object localObject = new LinearLayout.LayoutParams(-2, -1);
    this.Iv.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.enableTalkBack) {
      this.Iv.setContentDescription(this.Iv.getText());
    }
    this.Iv.setOnClickListener(new wty(this));
    paramLinearLayout.addView(this.Iv);
    this.Iw = new TextView(paramContext);
    this.Iw.setId(2131364463);
    this.Iw.setText(2131690180);
    this.Iw.setTextSize(1, 14.0F);
    this.Iw.setTextColor(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getResources().getColorStateList(2131165313));
    this.Iw.setPadding(i, 0, i, 0);
    this.Iw.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.Iw.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.enableTalkBack) {
      this.Iw.setContentDescription(this.Iw.getText());
    }
    this.Iw.setOnClickListener(new wtz(this));
    paramLinearLayout.addView(this.Iw);
    this.A = new CheckBox(paramContext);
    this.A.setId(2131364465);
    this.A.setBackgroundDrawable(null);
    this.A.setButtonDrawable(2130838172);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = i;
    this.A.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.enableTalkBack) {
      this.A.setContentDescription(this.A.getText());
    }
    this.A.setOnCheckedChangeListener(new wua(this));
    paramLinearLayout.addView(this.A);
    this.Ix = new TextView(paramContext);
    this.Ix.setId(2131364464);
    this.Ix.setText(2131690181);
    this.Ix.setTextSize(1, 14.0F);
    this.Ix.setTextColor(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getResources().getColorStateList(2131165313));
    this.Ix.setPadding(wja.dp2px(3.0F, paramContext.getResources()), 0, i, 0);
    this.Ix.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.Ix.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (AppSetting.enableTalkBack) {
      this.Ix.setContentDescription(this.Ix.getText());
    }
    this.Ix.setOnClickListener(new wts(this));
    paramLinearLayout.addView(this.Ix);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setId(2131364467);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    paramLinearLayout.addView((View)localObject);
    this.dS = new Button(paramContext);
    this.dS.setId(2131364462);
    this.dS.setText(2131690179);
    this.dS.setTextColor(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext.getResources().getColorStateList(2131165313));
    this.dS.setPadding(i, 0, i, 0);
    this.dS.setTypeface(this.dS.getTypeface(), 1);
    this.dS.setBackgroundResource(2130838048);
    if (AppSetting.enableTalkBack) {
      this.dS.setContentDescription(this.dS.getText());
    }
    this.dS.setOnClickListener(new wtt(this));
    paramLinearLayout.addView(this.dS);
  }
  
  public void a(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "onCheckedChanged() called with: message = [" + paramChatMessage + "], buttonView = [" + paramCompoundButton + "], isCheck = [" + paramBoolean + "]");
    }
    paramCompoundButton = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.b;
    paramCompoundButton = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki;
    Object localObject = paramCompoundButton.getList();
    int k;
    if (paramChatMessage != null)
    {
      k = ((List)localObject).indexOf(paramChatMessage);
      if (k >= 0) {}
    }
    else
    {
      return;
    }
    int m;
    int n;
    if (paramBoolean)
    {
      localObject = new ArrayList(this.bl.size());
      ((ArrayList)localObject).addAll(this.bl);
      m = fg(k);
      n = fh(k);
      if (m < 0) {
        break label613;
      }
    }
    label606:
    label613:
    for (int i = k - m;; i = -1)
    {
      if (n >= 0) {
        j = n - k;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOLongShotHelper", 2, "onCheckedChanged() isCheck = [" + paramBoolean + "], left=[" + m + "],leftDistance=[" + i + "],position=[" + k + "], rightCheckedPosition=[" + n + "], rightDistance=[" + j + "]");
      }
      if (i > 0) {
        if (j > 0) {
          if (i <= j)
          {
            fz(m, k);
            this.bl.add(paramChatMessage);
            paramChatMessage = new Point();
            this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindowManager().getDefaultDisplay().getSize(paramChatMessage);
            i = wf();
            j = getTitleHeight() + i + this.bRF;
            if (QLog.isColorLevel()) {
              QLog.d("AIOLongShotHelper", 2, "onCheckedChanged() totalHeight = " + j + ", title height = " + getTitleHeight() + ", input bar height = " + this.bRF + ", 10 * outSize.y = [" + paramChatMessage.y * 10 + "], outSize.x * outSize.y = [" + paramChatMessage.x * paramChatMessage.y + "]");
            }
            if ((j <= paramChatMessage.y * 10) && (i < 30000))
            {
              i = paramChatMessage.x;
              if (paramChatMessage.y * i < 200000000) {}
            }
            else
            {
              this.bl.clear();
              this.bl.addAll((Collection)localObject);
              QQToast.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext, acfp.m(2131702265), 0).show();
            }
          }
        }
      }
      for (;;)
      {
        cbK();
        su();
        paramCompoundButton.notifyDataSetChanged();
        if (!paramBoolean) {
          break label606;
        }
        report("0X8009DEA");
        return;
        fz(k, n);
        break;
        fz(m, k);
        break;
        if (j <= 0) {
          break;
        }
        fz(k, n);
        break;
        this.bl.remove(paramChatMessage);
      }
      report("0X8009DEB");
      return;
    }
  }
  
  public void cbL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOLongShotHelper", 2, "clearCheckedItems() called");
    }
    this.bl.clear();
  }
  
  public void cbN()
  {
    if (!this.bfV) {}
    wxk localwxk;
    do
    {
      do
      {
        return;
        this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.cL.removeView(this.hw);
        cbL();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOLongShotHelper$MergeBitmapTask.cancel();
        }
        this.mUiHandler.removeCallbacksAndMessages(null);
        this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.b.GO(false);
        this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
        cbK();
        this.bfV = false;
        w(null, false);
        cbU();
      } while (!(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie instanceof xwn));
      localwxk = (wxk)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
    } while (localwxk == null);
    localwxk.zl(true);
  }
  
  public void cbS()
  {
    View localView = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mAIORootView.findViewById(2131364469);
    if (localView == null)
    {
      QLog.e("AIOLongShotHelper", 1, "preLoadInputBarBitmap: chatContent == null, I'm in multi forward activity ?");
      return;
    }
    localView.setDrawingCacheEnabled(true);
    try
    {
      fc(localView);
      return;
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("AIOLongShotHelper", 1, "preLoadInputBarBitmap: error. try again.", localThrowable1);
      try
      {
        fc(localView);
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.e("AIOLongShotHelper", 1, "preLoadInputBarBitmap: try failed", localThrowable2);
        }
      }
    }
    finally
    {
      localView.setDrawingCacheEnabled(false);
    }
  }
  
  public void fd(View paramView)
  {
    cbL();
    cbX();
    ajlc.a().dyd();
    a(null, this.dZ);
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.notifyDataSetChanged();
    cbK();
    paramView = "0";
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ == 1) {
      paramView = "2";
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 3, 0, paramView, "", "", "");
      return;
      if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ == 0) {
        paramView = "1";
      }
    }
  }
  
  public void fe(View paramView)
  {
    cbL();
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Wki.notifyDataSetChanged();
    cbK();
    su();
  }
  
  public boolean n(ChatMessage paramChatMessage)
  {
    return this.bl.contains(paramChatMessage);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18001) {
      if (paramInt2 == -1) {
        if (paramIntent != null) {
          y(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mActivity, paramIntent);
        }
      }
    }
    label27:
    do
    {
      do
      {
        do
        {
          do
          {
            break label27;
            break label27;
            do
            {
              return;
            } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)));
            cbN();
            return;
            if (paramInt1 != 18002) {
              break;
            }
          } while (paramInt2 != -1);
          cbN();
          return;
          if (paramInt1 != 18004) {
            break;
          }
        } while ((paramInt2 != -1) || (!this.bfX));
        this.bfX = false;
        cbN();
        return;
        if (paramInt1 != 18003) {
          break;
        }
      } while (paramInt2 != -1);
      cbN();
      return;
    } while ((paramInt1 != 100) || (paramInt2 != -1));
    cbN();
  }
  
  public void showTitleBar()
  {
    this.hw = ((RelativeLayout)LayoutInflater.from(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext).inflate(2131558670, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.cL, false));
    this.Iy = ((TextView)this.hw.findViewById(2131370912));
    this.Iy.setOnClickListener(new wtu(this));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.hw.getLayoutParams();
    localLayoutParams.addRule(6, 2131377546);
    this.hw.setLayoutParams(localLayoutParams);
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.cL.addView(this.hw);
  }
  
  public void t(ChatMessage paramChatMessage)
  {
    a(paramChatMessage, null);
  }
  
  static class MergeBitmapTask
    implements Runnable
  {
    private AIOLongShotHelper a;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    
    public MergeBitmapTask(AIOLongShotHelper paramAIOLongShotHelper)
    {
      this.a = paramAIOLongShotHelper;
    }
    
    public void cancel()
    {
      this.mCancelled.set(true);
    }
    
    public boolean isCanceled()
    {
      return this.mCancelled.get();
    }
    
    public void run()
    {
      if (isCanceled())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOLongShotHelper", 2, "run() isCanceled before mergeBitmaps");
        }
        AIOLongShotHelper.c(this.a);
        AIOLongShotHelper.a(this.a, true, false, null);
        return;
      }
      Bitmap localBitmap = AIOLongShotHelper.a(this.a);
      AIOLongShotHelper.c(this.a);
      if (isCanceled())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOLongShotHelper", 2, "run() isCanceled before encodeAndWritePNG");
        }
        AIOLongShotHelper.a(this.a, true, false, null);
        return;
      }
      AIOLongShotHelper.a(this.a, localBitmap);
    }
  }
  
  public static abstract interface a
  {
    public abstract void cbZ();
    
    public abstract void cca();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper
 * JD-Core Version:    0.7.0.1
 */