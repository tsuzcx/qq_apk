package com.tencent.biz.qqstory.storyHome.messagenotify;

import acfp;
import anbk;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import aofk;
import aofr;
import aofy;
import aqbn;
import aqgq;
import aqgv;
import aqha;
import aqju;
import aqoa;
import auvd.a;
import auvd.b;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelAllMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ReqDelOneMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqStoryMessageList;
import com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jnm;
import jnm.b;
import jnp;
import ppf;
import psx;
import ptc.a;
import ptf;
import pxs;
import pxs.b;
import qea;
import qem;
import qgg;
import qrx;
import quo;
import qup;
import quq;
import qur;
import qus;
import qut;
import quu;
import quv;
import ram;
import rar;
import rpq;
import rsy;

public class StoryMessageListActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, AdapterView.c, AdapterView.d
{
  protected long Bq = -1L;
  protected int Qa = 4;
  protected aqoa a;
  protected c a;
  protected jnm.b a;
  protected boolean aFE;
  protected boolean aFF;
  protected boolean aFG = true;
  protected String ayU;
  protected jnm.b b = new quq(this);
  protected jnm.b c = new qur(this);
  protected SwipListView e;
  protected View gh;
  protected BubblePopupWindow i;
  protected QQAppInterface mApp;
  protected ArrayList<quo> mData = new ArrayList();
  protected aqju mDialog;
  protected int mSource = 0;
  protected int mStartTime;
  protected View ov;
  protected TextView xQ;
  
  public StoryMessageListActivity()
  {
    this.jdField_a_of_type_Jnm$b = new qup(this);
  }
  
  @NonNull
  public static Intent b(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, StoryMessageListActivity.class);
    paramContext.putExtra("qqstory_message_list_source", paramInt);
    paramContext.putExtra("qqstory_jump_source", paramString);
    return paramContext;
  }
  
  public void O(@NonNull Map<Subscriber, String> paramMap)
  {
    super.O(paramMap);
    paramMap.put(new f(this), "");
    paramMap.put(new e(this), "");
  }
  
  protected CharSequence a(quo paramquo)
  {
    if (paramquo.type == 2) {}
    Object localObject;
    for (paramquo = paramquo.commentContent;; paramquo = (quo)localObject)
    {
      localObject = paramquo;
      if (aofy.Z(paramquo.toString())) {
        localObject = new aofk(anbk.nn(paramquo.toString()), 3, 14);
      }
      return localObject;
      localObject = new SpannableStringBuilder(acfp.m(2131714929));
      int j = ((SpannableStringBuilder)localObject).length();
      ((SpannableStringBuilder)localObject).append(qem.getNickName(paramquo.ayJ));
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131167304)), j, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append(':').append(paramquo.commentContent);
    }
  }
  
  protected void a(quo paramquo, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "click item type=" + paramquo.type);
    }
    switch (paramquo.type)
    {
    default: 
    case 4: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 2: 
    case 3: 
    case 1: 
    case 11: 
    case 13: 
    case 16: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (paramquo.deleted)
                    {
                      paramquo = new Intent(this, QQStoryWarningActivity.class);
                      paramquo.putExtra("tipsResource", acfp.m(2131714934));
                      startActivity(paramquo);
                      return;
                    }
                    qgg.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramquo.mFeedId, paramquo.vid), 29).b(), null);
                    return;
                    if (paramquo.url_type != 0) {
                      break;
                    }
                    paramView = new Intent(this, QQBrowserActivity.class);
                    paramView.putExtra("url", paramquo.jump_url);
                    startActivity(paramView);
                  } while (!QLog.isColorLevel());
                  QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open webview!");
                  return;
                  if (paramquo.url_type != 1) {
                    break;
                  }
                  paramView = new Intent(this, JumpActivity.class);
                  paramView.setData(Uri.parse(paramquo.jump_url));
                  startActivity(paramView);
                } while (!QLog.isColorLevel());
                QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_OFFICIAL open jumpActivity!");
                return;
              } while (!QLog.isColorLevel());
              QLog.e("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() unknow url_type = " + paramquo.url_type);
              return;
              QQStoryShareGroupProfileActivity.a(this, 2, paramquo.ayN, null, 7, 0);
              return;
              paramquo = ((ptf)psx.a(2)).a();
              if (paramquo != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("Q.qqstory.msgList", 2, "self user item == null");
            return;
            paramquo = paramquo.getUserIconJumpURL();
            if (!TextUtils.isEmpty(paramquo)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("Q.qqstory.msgList", 2, "jumpUrl is empty");
          return;
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", paramquo);
          startActivity(paramView);
          return;
          StoryDetailActivity.a(this, paramquo.mFeedId, 23, paramquo.commentId, 0, paramquo.category);
          return;
          StoryDetailActivity.a(this, paramquo.mFeedId, 23, 0, paramquo.category);
          return;
          QQToast.a(this, -1, acfp.m(2131714940), 0).show();
          return;
          paramView = new StringBuilder("https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
          paramView.append("&vid=").append(paramquo.vid);
          ram.b("Q.qqstory.msgList", "go to story vote detail web. url = %s.", paramView.toString());
          paramquo = new Intent(this, QQBrowserActivity.class);
          paramquo.putExtra("url", paramView.toString());
          startActivity(paramquo);
        } while (!QLog.isColorLevel());
        QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_VOTE open webview!");
        return;
        paramView = new StringBuilder("https://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
        paramView.append("&vid=").append(paramquo.vid);
        ram.b("Q.qqstory.msgList", "go to story grade detail web. url = %s.", paramView.toString());
        paramquo = new Intent(this, QQBrowserActivity.class);
        paramquo.putExtra("url", paramView.toString());
        paramquo.putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity(paramquo);
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgList", 2, "StoryMessageListActivity#onItemClick() TYPE_ANSWER_MY_GRADE open webview!");
      return;
    case 18: 
      qgg.a(this, new OpenPlayerBuilder(new VidListPlayInfo(paramquo.feedId, paramquo.vid), 126).b(), null);
      return;
    }
    qgg.c(this, paramquo.vid, paramquo.ayT, 29);
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c.eJ(paramInt))
    {
      if ((this.i != null) && (this.i.isShowing())) {
        this.i.dismiss();
      }
      paramView.setSelected(true);
      if (this.jdField_a_of_type_Aqoa == null)
      {
        this.jdField_a_of_type_Aqoa = new aqoa();
        this.jdField_a_of_type_Aqoa.dV(2131375114, acfp.m(2131714941));
      }
      this.i = aqgq.a(paramView, this.jdField_a_of_type_Aqoa, new quu(this, paramInt), new quv(this, paramView));
      return true;
    }
    return false;
  }
  
  protected CharSequence b(quo paramquo)
  {
    return acfp.m(2131714933) + paramquo.commentContent;
  }
  
  protected void bqX()
  {
    if (this.Qa == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList", 2, "already loading");
      }
      return;
    }
    this.Qa = 1;
    qqstory_710_message.ReqStoryMessageList localReqStoryMessageList = new qqstory_710_message.ReqStoryMessageList();
    localReqStoryMessageList.num.set(20);
    localReqStoryMessageList.start_time.set(this.mStartTime);
    localReqStoryMessageList.source.set(this.mSource);
    localReqStoryMessageList.version_ctrl.set(775);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "fetch message list, start=" + this.mStartTime);
    }
    jnm.a(this.mApp, this.c, localReqStoryMessageList.toByteArray(), ppf.fQ("StorySvc.get_710_message_list"));
  }
  
  protected void bqY()
  {
    if (this.aFE) {}
    do
    {
      return;
      this.aFE = true;
      int j;
      if (this.Bq != -1L)
      {
        j = (int)(this.Bq / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "clearUnread by msg time, time=" + j);
        }
        ((jnp)this.mApp.getBusinessHandler(43)).cg(j, this.mSource);
        return;
      }
      if (this.Qa == 2)
      {
        j = (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "clearUnread by svr time, time=" + j);
        }
        ((jnp)this.mApp.getBusinessHandler(43)).cg(j, this.mSource);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.msgList", 2, "nothing to clear");
  }
  
  public void bqZ()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      QQToast.a(getApplicationContext(), 1, acfp.m(2131714936), 0).show();
    }
    do
    {
      return;
      if (this.Bq != -1L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.qqstory.msgList", 2, "doDeleteAllMessage but newest timestamp not set");
    return;
    int j = (int)(this.Bq / 1000L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgList", 2, "doDeleteAllMessage time=" + j);
    }
    qqstory_710_del_message.ReqDelAllMessage localReqDelAllMessage = new qqstory_710_del_message.ReqDelAllMessage();
    localReqDelAllMessage.start_time.set(j);
    jnm.a(this.mApp, this.jdField_a_of_type_Jnm$b, localReqDelAllMessage.toByteArray(), ppf.fQ("StorySvc.del_710_all_message"));
    this.mData.clear();
    this.aFG = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c.notifyDataSetChanged();
    this.gh.setVisibility(8);
    this.xQ.setText(2131696333);
    this.xQ.setCompoundDrawablesWithIntrinsicBounds(0, 2130842216, 0, 0);
    this.xQ.setClickable(false);
    this.xQ.setVisibility(0);
    this.ov.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  protected CharSequence c(quo paramquo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(acfp.m(2131714944));
    int j = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramquo.ayQ);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.app.getApp().getResources().getColor(2131167304)), j, localSpannableStringBuilder.length(), 33);
    ram.d("Q.qqstory.msgList", "get vote publish string : %s, voteQuestion : %s.", localSpannableStringBuilder, paramquo.ayQ);
    paramquo = localSpannableStringBuilder;
    if (aofy.Z(localSpannableStringBuilder.toString())) {
      paramquo = new aofk(anbk.nn(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramquo;
  }
  
  protected CharSequence d(quo paramquo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramquo.ayR);
    localSpannableStringBuilder.append("\n");
    localSpannableStringBuilder.append("投票：");
    localSpannableStringBuilder.append(paramquo.ayQ);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 0, localSpannableStringBuilder.length(), 33);
    ram.b("Q.qqstory.msgList", "get answer vote string : %s, voteQuestion : %s, voteAnswer : %s.", localSpannableStringBuilder, paramquo.ayQ, paramquo.ayR);
    paramquo = localSpannableStringBuilder;
    if (aofy.Z(localSpannableStringBuilder.toString())) {
      paramquo = new aofk(anbk.nn(localSpannableStringBuilder.toString()), 3, 14);
    }
    return paramquo;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561897);
    super.findViewById(2131365322).setBackgroundColor(getResources().getColor(2131167363));
    this.ov = super.findViewById(2131375095);
    this.gh = super.findViewById(2131375183);
    this.xQ = ((TextView)super.findViewById(2131366403));
    this.e = ((SwipListView)super.findViewById(2131370573));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c = new c();
    this.e.setDragEnable(true);
    this.e.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c);
    setRightButton(2131691523, this);
    setRightViewTextDisable(0);
    paramBundle = getAppInterface();
    int j;
    if ((paramBundle instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)paramBundle);
      paramBundle = getIntent();
      if (paramBundle != null) {
        break label228;
      }
      j = 0;
      label158:
      this.mSource = j;
      if (paramBundle != null) {
        break label239;
      }
      paramBundle = "0";
      label171:
      this.ayU = paramBundle;
      if (this.mSource != 2) {
        break label249;
      }
      super.setTitle(acfp.m(2131714932));
    }
    for (;;)
    {
      bqX();
      paramBundle = qea.a();
      paramBundle.T(this, 2);
      paramBundle.T(this, 4);
      return true;
      QLog.e("Q.qqstory.msgList", 1, "cannot get QQAppInterface");
      break;
      label228:
      j = paramBundle.getIntExtra("qqstory_message_list_source", 0);
      break label158;
      label239:
      paramBundle = paramBundle.getStringExtra("qqstory_jump_source");
      break label171;
      label249:
      super.setTitle(acfp.m(2131714927));
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.mDialog != null) && (this.mDialog.isShowing())) {
      this.mDialog.dismiss();
    }
    super.doOnDestroy();
  }
  
  protected CharSequence e(quo paramquo)
  {
    if (aofy.Z(paramquo.ayS)) {
      return new aofk(anbk.nn(paramquo.ayS), 3, 14);
    }
    return paramquo.ayS;
  }
  
  public void eC(List<quo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      ptf localptf = (ptf)psx.a(2);
      localArrayList = new ArrayList();
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        quo localquo = (quo)paramList.next();
        String[] arrayOfString = new String[3];
        arrayOfString[0] = localquo.ayI;
        arrayOfString[1] = localquo.ownerUnionId;
        arrayOfString[2] = localquo.ayJ;
        int k = arrayOfString.length;
        int j = 0;
        while (j < k)
        {
          localquo = arrayOfString[j];
          if (!TextUtils.isEmpty(localquo))
          {
            QQUserUIItem localQQUserUIItem = localptf.b(localquo);
            if (((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) && (!localHashSet.contains(localquo)))
            {
              localArrayList.add(new QQUserUIItem.a("", localquo));
              localHashSet.add(localquo);
            }
          }
          j += 1;
        }
      }
      localHashSet.clear();
    } while (localArrayList.isEmpty());
    new pxs().B(1, localArrayList);
  }
  
  protected CharSequence f(quo paramquo)
  {
    Object localObject = acfp.m(2131714947);
    String str;
    if (aofy.Z(paramquo.ayS)) {
      str = anbk.nn(paramquo.ayS);
    }
    int j;
    for (localObject = new SpannableStringBuilder("A" + "\n" + (String)localObject + str);; localObject = new aofr("A" + "\n" + (String)localObject + str, 3, 14))
    {
      j = "A".length();
      switch (paramquo.bok)
      {
      default: 
        return localObject;
        str = paramquo.ayS;
      }
    }
    qrx.a((SpannableStringBuilder)localObject, 0, j, 2130845459, 50, 22, 1);
    return localObject;
    qrx.a((SpannableStringBuilder)localObject, 0, j, 2130845461, 50, 22, 1);
    return localObject;
    qrx.a((SpannableStringBuilder)localObject, 0, j, 2130845460, 50, 22, 1);
    return localObject;
    qrx.a((SpannableStringBuilder)localObject, 0, j, 2130845458, 50, 22, 1);
    return localObject;
    qrx.a((SpannableStringBuilder)localObject, 0, j, 2130845457, 50, 22, 1);
    return localObject;
  }
  
  public void finish()
  {
    bqY();
    super.finish();
  }
  
  protected void g(List<quo> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "onUpdate size=" + paramList.size() + ", end=" + paramBoolean1);
    }
    Object localObject;
    int j;
    if (this.mData.size() == 0)
    {
      if (paramList.size() > 0)
      {
        this.Bq = ((quo)paramList.get(0)).Bn;
        this.ov.setVisibility(8);
        localObject = ((ptf)psx.a(2)).b(QQStoryContext.a().getCurrentUid());
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label364;
        }
        j = 1;
        label126:
        if (this.mSource != 0) {
          break label376;
        }
        if (j == 0) {
          break label370;
        }
        j = 1;
        label141:
        rar.a("play_video", "exp_notice", j, 0, new String[] { "1", "", "", "" });
      }
    }
    else
    {
      label178:
      eC(paramList);
      this.mData.addAll(paramList);
      j = paramList.size();
      if ((!paramBoolean1) && (j != 0)) {
        break label444;
      }
      this.Qa = 2;
      bqY();
    }
    for (;;)
    {
      if (j > 0)
      {
        this.mStartTime = ((int)(((quo)this.mData.get(this.mData.size() - 1)).Bn / 1000L) - 1);
        setRightViewTextDisable(1);
      }
      this.aFG = paramBoolean2;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c.notifyDataSetChanged();
      return;
      if (((this.mSource == 0) || (this.mSource == 2)) && (paramBoolean2))
      {
        this.ov.setVisibility(8);
        break;
      }
      this.gh.setVisibility(8);
      this.xQ.setText(2131696333);
      this.xQ.setCompoundDrawablesWithIntrinsicBounds(0, 2130842216, 0, 0);
      this.xQ.setClickable(false);
      this.xQ.setVisibility(0);
      this.ov.setVisibility(0);
      break;
      label364:
      j = 0;
      break label126;
      label370:
      j = 2;
      break label141;
      label376:
      if (this.mSource != 1) {
        break label178;
      }
      if (paramList.size() > 0) {}
      for (localObject = "2";; localObject = "1")
      {
        rar.a("memory", "exp_msg", 0, 0, new String[] { localObject, "", "", "" });
        break;
      }
      label444:
      this.Qa = 4;
    }
  }
  
  public String mO()
  {
    if (this.mSource == 0) {
      return "play_video";
    }
    if (this.mSource == 1) {
      return "memory";
    }
    return "";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.Qa == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "click retry first page");
        }
        this.gh.setVisibility(0);
        this.xQ.setVisibility(8);
        this.ov.setVisibility(0);
        bqX();
        continue;
        rar.a(mO(), "clear_msg", 0, 0, new String[] { "", "", "", "" });
        if ((this.mDialog != null) && (this.mDialog.isShowing())) {
          this.mDialog.dismiss();
        }
        this.mDialog = aqha.a(this, 230).setMessage(acfp.m(2131714922)).setNegativeButton(2131721058, new qut(this)).setPositiveButton(2131691523, new qus(this));
        this.mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.mDialog.show();
        rar.a(mO(), "exp_sure", 0, 0, new String[] { "", "", "", "" });
      }
    }
  }
  
  protected void onError()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList", 2, "onError");
    }
    this.Qa = 3;
    if (this.mData.size() == 0)
    {
      this.gh.setVisibility(8);
      this.xQ.setText(acfp.m(2131714928));
      this.xQ.setCompoundDrawablesWithIntrinsicBounds(0, 2130847495, 0, 0);
      this.xQ.setOnClickListener(this);
      this.xQ.setVisibility(0);
      this.ov.setVisibility(0);
      if (this.mSource == 0)
      {
        QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).b(QQStoryContext.a().getCurrentUid());
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip)) {
          break label180;
        }
        j = 1;
        if (j == 0) {
          break label185;
        }
      }
    }
    label180:
    label185:
    for (int j = 1;; j = 2)
    {
      rar.a("play_video", "exp_notice", j, 0, new String[] { "2", "", "", "" });
      wD(this.mData.size());
      return;
      j = 0;
      break;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c.eJ(paramInt))
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c.a(paramInt);
      if (localObject == null) {
        return;
      }
      a((quo)localObject, paramView);
      switch (((quo)localObject).dV)
      {
      default: 
        paramInt = 0;
        switch (((quo)localObject).type)
        {
        default: 
          paramAdapterView = "";
          label155:
          if (!((quo)localObject).deleted) {}
          break;
        }
        break;
      }
    }
    for (paramView = "4";; paramView = "1")
    {
      localObject = ((ptf)psx.a(2)).b(QQStoryContext.a().getCurrentUid());
      if ((localObject != null) && (((QQUserUIItem)localObject).isVip))
      {
        j = 1;
        label201:
        if (j == 0) {
          break label473;
        }
      }
      label473:
      for (int j = 1;; j = 2)
      {
        rar.a("play_video", "clk_msg", j, paramInt, new String[] { paramAdapterView, paramView, this.ayU, "" });
        return;
        paramAdapterView = ((ptf)psx.a(2)).b(((quo)localObject).ayI);
        if ((paramAdapterView != null) && (paramAdapterView.isFriend()))
        {
          paramInt = 1;
          break;
        }
        if ((paramAdapterView != null) && (paramAdapterView.isSubscribe()))
        {
          paramInt = 2;
          break;
        }
        paramInt = 4;
        break;
        paramInt = 3;
        break;
        if (((quo)localObject).boj == 0) {}
        for (paramInt = 6;; paramInt = 5) {
          break;
        }
        paramInt = 7;
        break;
        paramInt = 8;
        break;
        paramInt = 9;
        break;
        if (QQStoryContext.a().eU(((quo)localObject).ownerUnionId)) {}
        for (paramAdapterView = "2";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().eU(((quo)localObject).ownerUnionId)) {}
        for (paramAdapterView = "1";; paramAdapterView = "4") {
          break;
        }
        if (QQStoryContext.a().eU(((quo)localObject).ayJ)) {}
        for (paramAdapterView = "3";; paramAdapterView = "4") {
          break;
        }
        paramAdapterView = "6";
        break label155;
        paramAdapterView = "7";
        break label155;
        paramAdapterView = "8";
        break label155;
        paramAdapterView = "9";
        break label155;
        paramAdapterView = "10";
        break label155;
        paramAdapterView = "11";
        break label155;
        j = 0;
        break label201;
      }
      if (this.Qa == 3) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "click retry");
        }
      }
      while (this.Qa != 2)
      {
        this.aFF = true;
        wD(this.mData.size());
        return;
      }
      if (this.mSource == 2) {}
      for (this.mSource = 3;; this.mSource = 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "convert to list");
        }
        rar.a("play_video", "clk_more", 0, 0, new String[] { "", "", "", "" });
        break;
      }
    }
  }
  
  public void refreshData()
  {
    runOnUiThread(new StoryMessageListActivity.8(this));
  }
  
  public void wC(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      QQToast.a(getApplicationContext(), 1, acfp.m(2131714935), 0).show();
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c.eJ(paramInt));
      quo localquo = (quo)this.mData.remove(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgList", 2, "doDeleteMessage pos=" + paramInt + " vid=" + localquo.vid + " type=" + localquo.type + " cid=" + localquo.commentId);
      }
      qqstory_710_del_message.ReqDelOneMessage localReqDelOneMessage = new qqstory_710_del_message.ReqDelOneMessage();
      localReqDelOneMessage.feed_id.set(ByteStringMicro.copyFromUtf8(localquo.mFeedId));
      localReqDelOneMessage.message_id.set(localquo.boh);
      jnm.a(this.mApp, this.b, localReqDelOneMessage.toByteArray(), ppf.fQ("StorySvc.del_710_one_message"));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c.notifyDataSetChanged();
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c.getCount() != 0);
    this.gh.setVisibility(8);
    this.xQ.setText(2131696333);
    this.xQ.setCompoundDrawablesWithIntrinsicBounds(0, 2130842216, 0, 0);
    this.xQ.setClickable(false);
    this.xQ.setVisibility(0);
    this.ov.setVisibility(0);
    setRightViewTextDisable(0);
  }
  
  protected void wD(int paramInt)
  {
    int j = this.e.getFirstVisiblePosition();
    int k = this.e.getLastVisiblePosition();
    if ((paramInt >= j) && (paramInt <= k))
    {
      View localView = this.e.getChildAt(paramInt - j);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$c.getView(paramInt, localView, this.e);
    }
  }
  
  public class a
    implements View.OnClickListener, View.OnLongClickListener
  {
    View iD;
    ImageView mY;
    TextView ny;
    View ow;
    int position;
    
    public a(View paramView)
    {
      this.ow = paramView.findViewById(2131370787);
      this.ny = ((TextView)paramView.findViewById(2131370815));
      this.iD = paramView.findViewById(2131371954);
      this.mY = ((ImageView)paramView.findViewById(2131371943));
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
    }
    
    public void onClick(View paramView)
    {
      StoryMessageListActivity.this.onItemClick(StoryMessageListActivity.this.e, paramView, this.position, this.position);
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public boolean onLongClick(View paramView)
    {
      return StoryMessageListActivity.this.a(StoryMessageListActivity.this.e, paramView, this.position, this.position);
    }
    
    public void update(int paramInt)
    {
      this.position = paramInt;
    }
  }
  
  public class b
    extends auvd.a
    implements View.OnClickListener, View.OnLongClickListener
  {
    ImageView avatar;
    StoryCoverView b;
    View gk;
    String mUnionId;
    View ox;
    int position;
    String thumbUrl;
    TextView time;
    TextView xR;
    TextView xS;
    TextView xT;
    TextView xU;
    TextView xV;
    
    public b(View paramView)
    {
      this.avatar = ((ImageView)paramView.findViewById(2131363175));
      this.b = ((StoryCoverView)paramView.findViewById(2131379638));
      this.xR = ((TextView)paramView.findViewById(2131372361));
      this.xS = ((TextView)paramView.findViewById(2131364968));
      this.xT = ((TextView)paramView.findViewById(2131372482));
      this.ox = paramView.findViewById(2131370443);
      this.time = ((TextView)paramView.findViewById(2131379700));
      this.xU = ((TextView)paramView.findViewById(2131381595));
      this.xV = ((TextView)paramView.findViewById(2131381596));
      this.gk = paramView.findViewById(2131370458);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
    }
    
    public void onClick(View paramView)
    {
      StoryMessageListActivity.this.onItemClick(StoryMessageListActivity.this.e, paramView, this.position, this.position);
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public boolean onLongClick(View paramView)
    {
      return StoryMessageListActivity.this.a(StoryMessageListActivity.this.e, paramView, this.position, this.position);
    }
    
    public void update(int paramInt)
    {
      this.position = paramInt;
    }
  }
  
  public class c
    extends BaseAdapter
    implements View.OnClickListener
  {
    StoryMessageListActivity.d a = new StoryMessageListActivity.d();
    int[] dR = aqbn.d(rpq.dip2px(StoryMessageListActivity.this.getApplicationContext(), 50.0F), rpq.dip2px(StoryMessageListActivity.this.getApplicationContext(), 70.0F), rpq.dip2px(StoryMessageListActivity.this.getApplicationContext(), 3.0F));
    LayoutInflater mInflater = LayoutInflater.from(BaseApplication.getContext());
    
    protected c() {}
    
    public quo a(int paramInt)
    {
      if (eJ(paramInt)) {
        return (quo)StoryMessageListActivity.this.mData.get(paramInt);
      }
      return null;
    }
    
    public boolean eJ(int paramInt)
    {
      return paramInt < StoryMessageListActivity.this.mData.size();
    }
    
    public int getCount()
    {
      int i = StoryMessageListActivity.this.mData.size();
      if ((StoryMessageListActivity.this.mSource == 1) || (StoryMessageListActivity.this.mSource == 3))
      {
        if ((i != 0) && (StoryMessageListActivity.this.Qa != 2)) {}
      }
      else {
        while (((StoryMessageListActivity.this.mSource == 0) || (StoryMessageListActivity.this.mSource == 2)) && (((i == 0) && (StoryMessageListActivity.this.Qa != 2)) || ((!StoryMessageListActivity.this.aFG) && (StoryMessageListActivity.this.Qa == 2)))) {
          return i;
        }
      }
      return i + 1;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (eJ(paramInt)) {
        return 0;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      Object localObject2;
      label109:
      boolean bool;
      label227:
      label239:
      int i;
      if (eJ(paramInt))
      {
        quo localquo;
        if (paramView == null)
        {
          localObject1 = this.mInflater.inflate(2131561898, paramViewGroup, false);
          localObject2 = new StoryMessageListActivity.b(StoryMessageListActivity.this, (View)localObject1);
          localObject1 = this.a.a(StoryMessageListActivity.this, (View)localObject1, (auvd.a)localObject2, -1);
          ((View)localObject1).setTag(localObject2);
          localquo = a(paramInt);
          if (localquo != null) {
            break label109;
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localObject1;
          localObject2 = (StoryMessageListActivity.b)paramView.getTag();
          localObject1 = paramView;
          break;
          Object localObject3 = localquo.ayI;
          Object localObject4;
          if ((localObject3 != null) && (!((String)localObject3).equals(((StoryMessageListActivity.b)localObject2).mUnionId)))
          {
            localObject4 = ((ptf)psx.a(2)).b((String)localObject3);
            if (localObject4 != null)
            {
              ((StoryMessageListActivity.b)localObject2).mUnionId = ((String)localObject3);
              if (((localquo.type == 14) || (localquo.type == 13) || (localquo.type == 16) || (localquo.type == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localquo.Bo)))) {
                ((QQUserUIItem)localObject4).qq = String.valueOf(localquo.Bo);
              }
              if (localquo.dV != 4) {
                break label677;
              }
              bool = true;
              Resources localResources = StoryMessageListActivity.this.getResources();
              ImageView localImageView = ((StoryMessageListActivity.b)localObject2).avatar;
              float f1 = 50;
              TextView localTextView = ((StoryMessageListActivity.b)localObject2).xR;
              float f2 = 13;
              float f3 = 5;
              if (!bool) {
                break label683;
              }
              localObject3 = String.valueOf(localquo.Bo);
              label291:
              qem.a(localResources, (QQUserUIItem)localObject4, localImageView, f1, localTextView, f2, f3, bool, (String)localObject3);
            }
          }
          else
          {
            if (localquo.type != 1) {
              break label689;
            }
            ((StoryMessageListActivity.b)localObject2).xS.setVisibility(8);
            ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
            ((StoryMessageListActivity.b)localObject2).ox.setVisibility(0);
            label350:
            ((StoryMessageListActivity.b)localObject2).time.setText(localquo.getTime());
            if (localquo.dV != 4) {
              break label1996;
            }
            localObject3 = aqgv.a(StoryMessageListActivity.this.app, String.valueOf(localquo.Bo), true);
            ((StoryMessageListActivity.b)localObject2).xU.setText((CharSequence)localObject3);
            ((StoryMessageListActivity.b)localObject2).xU.setVisibility(0);
            ((StoryMessageListActivity.b)localObject2).xV.setVisibility(8);
            label422:
            if ((!TextUtils.isEmpty(localquo.mN())) && (!localquo.mN().equals(((StoryMessageListActivity.b)localObject2).thumbUrl)))
            {
              ((StoryMessageListActivity.b)localObject2).thumbUrl = localquo.mN();
              localObject3 = StoryMessageListActivity.this.getResources().getDrawable(2130847768);
            }
          }
          try
          {
            localObject4 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
            ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "story_message";
            localObject4 = URLDrawable.getDrawable(localquo.mN(), (URLDrawable.URLDrawableOptions)localObject4);
            ((URLDrawable)localObject4).setTag(this.dR);
            ((URLDrawable)localObject4).setDecodeHandler(aqbn.a);
            ((StoryMessageListActivity.b)localObject2).b.setImageDrawable((Drawable)localObject4);
            if (localquo.c != null) {
              ((StoryMessageListActivity.b)localObject2).b.setPollLayout(localquo.c, -1, null);
            }
            if (localquo.b != null) {
              ((StoryMessageListActivity.b)localObject2).b.setRateLayout(localquo.b, -1, -1L, -1);
            }
            localObject3 = ((StoryMessageListActivity.b)localObject2).gk;
            if (paramInt == StoryMessageListActivity.this.mData.size() - 1) {
              if (getCount() == StoryMessageListActivity.this.mData.size())
              {
                i = 0;
                ((View)localObject3).setVisibility(i);
                this.a.a(StoryMessageListActivity.this, (View)localObject1, paramInt, localquo, (auvd.a)localObject2, this);
                ((StoryMessageListActivity.b)localObject2).update(paramInt);
                continue;
                ((StoryMessageListActivity.b)localObject2).mUnionId = null;
                break label227;
                label677:
                bool = false;
                break label239;
                label683:
                localObject3 = null;
                break label291;
                label689:
                if ((localquo.type == 2) || (localquo.type == 3))
                {
                  if (localquo.deleted)
                  {
                    ((StoryMessageListActivity.b)localObject2).xS.setVisibility(8);
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(0);
                    ((StoryMessageListActivity.b)localObject2).xT.setText(acfp.m(2131714945));
                    ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                    break label350;
                  }
                  ((StoryMessageListActivity.b)localObject2).xS.setText(StoryMessageListActivity.this.a(localquo));
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                  break label350;
                }
                if (localquo.type == 4)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(acfp.m(2131714937));
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  if (localquo.deleted)
                  {
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(0);
                    ((StoryMessageListActivity.b)localObject2).xT.setText(acfp.m(2131714923));
                  }
                  for (;;)
                  {
                    ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                    break;
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  }
                }
                if (localquo.type == 12)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(StoryMessageListActivity.this.c(localquo));
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  if (localquo.deleted)
                  {
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(0);
                    ((StoryMessageListActivity.b)localObject2).xT.setText(acfp.m(2131714924));
                  }
                  for (;;)
                  {
                    ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                    break;
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  }
                }
                if ((localquo.type == 14) || (localquo.type == 13))
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(StoryMessageListActivity.this.d(localquo));
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  if (localquo.deleted)
                  {
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(0);
                    ((StoryMessageListActivity.b)localObject2).xT.setText(acfp.m(2131714925));
                  }
                  for (;;)
                  {
                    ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                    break;
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  }
                }
                if (localquo.type == 15)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(StoryMessageListActivity.this.e(localquo));
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  if (localquo.deleted)
                  {
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(0);
                    ((StoryMessageListActivity.b)localObject2).xT.setText(acfp.m(2131714946));
                  }
                  for (;;)
                  {
                    ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                    break;
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  }
                }
                if ((localquo.type == 16) || (localquo.type == 17))
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(StoryMessageListActivity.this.f(localquo));
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  if (localquo.deleted)
                  {
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(0);
                    ((StoryMessageListActivity.b)localObject2).xT.setText(acfp.m(2131714943));
                  }
                  for (;;)
                  {
                    ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                    break;
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  }
                }
                if (localquo.type == 5)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(localquo.content);
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                  break label350;
                }
                if (localquo.type == 6)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(localquo.commentContent);
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                  break label350;
                }
                if (localquo.type == 7)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(localquo.commentContent);
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                  break label350;
                }
                if (localquo.type == 8)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(2131701952);
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                  break label350;
                }
                if (localquo.type == 9)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(localquo.commentContent);
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                  break label350;
                }
                if (localquo.type == 10)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(localquo.commentContent);
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                  break label350;
                }
                if (localquo.type == 11)
                {
                  ((StoryMessageListActivity.b)localObject2).xS.setText(localquo.commentContent);
                  ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                  ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                  ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                  break label350;
                }
                if (localquo.type == 18)
                {
                  i = localquo.boi;
                  localObject3 = null;
                  if (i > 0) {
                    localObject3 = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
                  }
                  if (TextUtils.isEmpty((CharSequence)localObject3)) {}
                  for (localObject3 = acfp.m(2131714942);; localObject3 = "@" + (String)localObject3 + acfp.m(2131714939))
                  {
                    ((StoryMessageListActivity.b)localObject2).xS.setText((CharSequence)localObject3);
                    ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                    ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                    break;
                  }
                }
                if (localquo.type == 19)
                {
                  if (localquo.aFD)
                  {
                    ((StoryMessageListActivity.b)localObject2).xS.setVisibility(8);
                    ((StoryMessageListActivity.b)localObject2).xT.setVisibility(0);
                    ((StoryMessageListActivity.b)localObject2).xT.setText(acfp.m(2131714938));
                  }
                  for (;;)
                  {
                    ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                    break;
                    if (localquo.aFC)
                    {
                      ((StoryMessageListActivity.b)localObject2).xS.setVisibility(8);
                      ((StoryMessageListActivity.b)localObject2).xT.setVisibility(0);
                      ((StoryMessageListActivity.b)localObject2).xT.setText(acfp.m(2131714930));
                    }
                    else
                    {
                      ((StoryMessageListActivity.b)localObject2).xS.setText(StoryMessageListActivity.this.b(localquo));
                      ((StoryMessageListActivity.b)localObject2).xS.setVisibility(0);
                      ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                    }
                  }
                }
                ((StoryMessageListActivity.b)localObject2).xS.setVisibility(8);
                ((StoryMessageListActivity.b)localObject2).xT.setVisibility(8);
                ((StoryMessageListActivity.b)localObject2).ox.setVisibility(8);
                break label350;
                label1996:
                if (((localquo.dV == 99) || (localquo.dV == 104)) && (localquo.type != 6) && (localquo.type != 9))
                {
                  ((StoryMessageListActivity.b)localObject2).xU.setText(localquo.axW);
                  ((StoryMessageListActivity.b)localObject2).xU.setVisibility(0);
                  ((StoryMessageListActivity.b)localObject2).xV.setVisibility(8);
                  break label422;
                }
                if (((localquo.type == 13) || (localquo.type == 14) || (localquo.type == 16) || (localquo.type == 17)) && (!TextUtils.isEmpty(localquo.nickPostfix)))
                {
                  if ("QQ好友".equals(localquo.nickPostfix)) {
                    ((StoryMessageListActivity.b)localObject2).xU.setVisibility(8);
                  }
                  for (;;)
                  {
                    ((StoryMessageListActivity.b)localObject2).xV.setVisibility(8);
                    break;
                    ((StoryMessageListActivity.b)localObject2).xU.setText(localquo.nickPostfix);
                    ((StoryMessageListActivity.b)localObject2).xU.setVisibility(0);
                  }
                }
                ((StoryMessageListActivity.b)localObject2).xU.setVisibility(8);
                ((StoryMessageListActivity.b)localObject2).xV.setVisibility(8);
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ((StoryMessageListActivity.b)localObject2).b.setImageDrawable((Drawable)localObject3);
              continue;
              i = 8;
              continue;
              i = 0;
            }
          }
        }
      }
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(2131561899, paramViewGroup, false);
        localObject1 = new StoryMessageListActivity.a(StoryMessageListActivity.this, paramView);
        paramView.setTag(localObject1);
        label2272:
        switch (StoryMessageListActivity.this.Qa)
        {
        }
      }
      for (;;)
      {
        ((StoryMessageListActivity.a)localObject1).update(paramInt);
        localObject1 = paramView;
        break;
        localObject1 = (StoryMessageListActivity.a)paramView.getTag();
        break label2272;
        if (StoryMessageListActivity.this.aFF)
        {
          StoryMessageListActivity.this.aFF = false;
          ((StoryMessageListActivity.a)localObject1).iD.setVisibility(8);
          ((StoryMessageListActivity.a)localObject1).ow.setVisibility(0);
          ((StoryMessageListActivity.a)localObject1).ny.setVisibility(0);
          ((StoryMessageListActivity.a)localObject1).ny.setText(2131701937);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.msgList", 2, "list - load more");
          }
          StoryMessageListActivity.this.bqX();
        }
        else
        {
          ((StoryMessageListActivity.a)localObject1).ow.setVisibility(8);
          ((StoryMessageListActivity.a)localObject1).ny.setVisibility(8);
          ((StoryMessageListActivity.a)localObject1).iD.setVisibility(0);
          QQStoryContext.a();
          bool = ThemeUtil.isInNightMode(QQStoryContext.c());
          localObject2 = ((StoryMessageListActivity.a)localObject1).mY;
          if (bool) {}
          for (i = 2130847379;; i = 2130847378)
          {
            ((ImageView)localObject2).setImageResource(i);
            break;
          }
          ((StoryMessageListActivity.a)localObject1).ow.setVisibility(0);
          ((StoryMessageListActivity.a)localObject1).ny.setText(2131701937);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.msgList", 2, "pull to load more");
          }
          StoryMessageListActivity.this.bqX();
          continue;
          if (StoryMessageListActivity.this.aFF)
          {
            StoryMessageListActivity.this.aFF = false;
            ((StoryMessageListActivity.a)localObject1).ow.setVisibility(0);
            ((StoryMessageListActivity.a)localObject1).ny.setText(2131701937);
            StoryMessageListActivity.this.bqX();
          }
          else
          {
            ((StoryMessageListActivity.a)localObject1).ow.setVisibility(8);
            ((StoryMessageListActivity.a)localObject1).ny.setText(acfp.m(2131714926));
            continue;
            ((StoryMessageListActivity.a)localObject1).ow.setVisibility(0);
            ((StoryMessageListActivity.a)localObject1).ny.setText(2131701937);
          }
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public void onClick(View paramView)
    {
      try
      {
        i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
        if (i == -1)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqstory.msgList", 2, localException, new Object[0]);
          }
          int i = -1;
          continue;
          switch (paramView.getId())
          {
          default: 
            break;
          case 2131371284: 
            StoryMessageListActivity.this.wC(i);
            rar.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
          }
        }
      }
    }
  }
  
  static class d
    extends rsy
  {
    private static final int[] an = { 2131692505 };
    private static final int[] ao = { 2131165745 };
    private static final int[] ap = { 2131371284 };
    private static int[] aq = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299501) };
    
    public d()
    {
      super(1, aq, -1, ap, an, ao);
    }
    
    public void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb)
    {
      paramArrayOfb[0].dOe = 0;
      paramArrayOfb[0].dOf = 0;
    }
  }
  
  static class e
    extends QQUIEventReceiver<StoryMessageListActivity, ptc.a>
  {
    public e(@NonNull StoryMessageListActivity paramStoryMessageListActivity)
    {
      super();
    }
    
    public void a(@NonNull StoryMessageListActivity paramStoryMessageListActivity, @NonNull ptc.a parama)
    {
      if (parama.b.isSuccess())
      {
        if (QLog.isDevelopLevel()) {
          QLog.i(this.TAG, 2, "TroopNickNameUpdateEvent");
        }
        paramStoryMessageListActivity.refreshData();
      }
    }
    
    public Class acceptEventClass()
    {
      return ptc.a.class;
    }
  }
  
  static class f
    extends QQUIEventReceiver<StoryMessageListActivity, pxs.b>
  {
    public f(@NonNull StoryMessageListActivity paramStoryMessageListActivity)
    {
      super();
    }
    
    public void a(@NonNull StoryMessageListActivity paramStoryMessageListActivity, @NonNull pxs.b paramb)
    {
      if (paramb.b.isSuccess())
      {
        if (QLog.isDevelopLevel()) {
          QLog.i(this.TAG, 2, "get userinfo come back. >>>>>> " + paramb.mX);
        }
        paramStoryMessageListActivity.refreshData();
      }
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity
 * JD-Core Version:    0.7.0.1
 */