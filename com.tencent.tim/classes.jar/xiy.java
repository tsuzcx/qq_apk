import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.LimitChatTopicItemBuilder.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.LabelTextView;
import com.tencent.mobileqq.limitchat.TopicTextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class xiy
  extends wjd
  implements View.OnClickListener
{
  private HashSet<Long> aD = new HashSet(10);
  
  public xiy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private int a(int paramInt, LinearLayout paramLinearLayout, List<xiy.a> paramList)
  {
    paramLinearLayout.removeAllViews();
    int j = aqnm.dpToPx(12.0F);
    int k = aqnm.dpToPx(1.0F);
    int m = aqnm.dpToPx(8.0F);
    int n = aqnm.dpToPx(6.0F);
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(aqnm.dpToPx(12));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = paramList.size();
    int i = 0;
    xiy.a locala;
    if (i < i1)
    {
      locala = (xiy.a)paramList.get(i);
      if (TextUtils.isEmpty(locala.J)) {
        break label307;
      }
      int i2 = (int)(((Paint)localObject).measureText(locala.J.toString()) + m * 2);
      if (paramInt >= i2 + n)
      {
        localArrayList.add(locala);
        paramInt = paramInt - i2 - n;
      }
    }
    label307:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(locala);
      }
      i = localArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (xiy.a)localArrayList.get(paramInt);
        paramList = new LabelTextView(this.mContext);
        paramList.setParam(((xiy.a)localObject).bgColor, ((xiy.a)localObject).textColor, j);
        paramList.setTextSize(12);
        paramList.setText(((xiy.a)localObject).J);
        paramList.setPadding(m, k, m, k);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        if (paramInt != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = n;
        }
        paramLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
        paramInt += 1;
      }
      return localArrayList.size();
    }
  }
  
  @NotNull
  private String a(xiy.b paramb, JSONObject paramJSONObject)
  {
    int j = paramJSONObject.optInt("matchTagId");
    String str = "";
    if (ExtendFriendUserInfo.isTagIdFromSignalBomb(j))
    {
      str = this.mContext.getString(2131701201);
      if (TextUtils.isEmpty(paramb.tagName)) {
        paramb.tagName = str;
      }
      return str;
    }
    if (paramb.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) {}
    for (int i = paramb.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.fromType;; i = 3)
    {
      if (i == 1)
      {
        str = this.mContext.getString(2131701097);
        break;
      }
      if (i == 2)
      {
        str = this.mContext.getString(2131701100);
        break;
      }
      if (i != 3) {
        break;
      }
      if (j > 1)
      {
        str = this.mContext.getString(2131701163);
        paramb.tagName = paramJSONObject.optString("matchTagName");
        break;
      }
      str = this.mContext.getString(2131701164);
      break;
    }
  }
  
  private void a(xiy.b paramb, String paramString)
  {
    Object localObject;
    Bitmap localBitmap;
    if ((this.adapter instanceof wki))
    {
      localObject = ((wki)this.adapter).a;
      if (localObject != null)
      {
        localBitmap = ((aqdf)localObject).b(1, paramString, 6);
        if (localBitmap == null)
        {
          if (((aqdf)localObject).isPausing()) {
            break label112;
          }
          ((aqdf)localObject).i(paramString, 1, true);
          paramString = null;
        }
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = aqhu.at();
      }
      paramb.tc.setImageDrawable((Drawable)localObject);
      paramb.tc.setContentDescription(this.mContext.getString(2131693350));
      return;
      paramString = new BitmapDrawable(this.mContext.getResources(), localBitmap);
      continue;
      label112:
      paramString = null;
    }
  }
  
  private void a(xiy.b paramb, ArrayList<xiy.a> paramArrayList, JSONArray paramJSONArray)
  {
    int i = 0;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0)) {
      paramArrayList.addAll(afxu.a(this.mContext, paramJSONArray));
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      int j = aqnm.getScreenWidth() - this.mContext.getResources().getDimensionPixelSize(2131298627) * 2 - this.mContext.getResources().getDimensionPixelSize(2131298628) * 2;
      int k = a(j, paramb.hg, paramArrayList);
      if (k > 0)
      {
        paramb.hg.setVisibility(0);
        if (k < paramArrayList.size())
        {
          j = a(j, paramb.hh, paramArrayList.subList(k, paramArrayList.size()));
          paramb = paramb.hh;
          if (j > 0) {}
          for (;;)
          {
            paramb.setVisibility(i);
            return;
            i = 8;
          }
        }
        paramb.hh.setVisibility(8);
        return;
      }
      paramb.hg.setVisibility(8);
      return;
    }
    paramb.hg.setVisibility(8);
    paramb.hh.setVisibility(8);
  }
  
  private void a(xiy.b paramb, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("declaration");
    paramJSONObject = paramJSONObject.optString("signWords");
    if (!TextUtils.isEmpty(str))
    {
      paramb.c.setText(new aofk(awif.sj(hv(str)), 3, 24));
      return;
    }
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramb.c.setText(new aofk(awif.sj(hv(paramJSONObject)), 3, 24));
      return;
    }
    paramb.c.setVisibility(8);
  }
  
  private void a(xiy.b paramb, JSONObject paramJSONObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = 0;
    Object localObject2 = null;
    paramJSONObject = paramJSONObject.optJSONArray("shcoolInfos");
    Object localObject1 = localObject2;
    int i = j;
    if (paramJSONObject != null)
    {
      localObject1 = localObject2;
      i = j;
      if (paramJSONObject.length() > 0)
      {
        paramJSONObject = paramJSONObject.optJSONObject(0);
        localObject1 = localObject2;
        i = j;
        if (paramJSONObject != null)
        {
          if (paramJSONObject.optLong("shcool_state") != 2L) {
            break label308;
          }
          i = 1;
          localObject1 = paramJSONObject.optString("shcool_name");
        }
      }
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    for (paramJSONObject = paramString1 + " | " + paramString3;; paramJSONObject = paramString1)
    {
      if (paramInt >= 0)
      {
        paramString1 = paramInt + "m";
        label148:
        if (TextUtils.isEmpty(paramString1)) {
          break label363;
        }
        paramJSONObject = paramJSONObject + " | " + paramString1;
      }
      label281:
      label308:
      label328:
      label336:
      label344:
      label363:
      for (;;)
      {
        paramString1 = paramJSONObject;
        if (!TextUtils.isEmpty(paramString2)) {
          paramString1 = paramJSONObject + " | " + paramString2;
        }
        paramb.Ji.setText(paramString1);
        paramJSONObject = paramb.Ji;
        if (paramBoolean)
        {
          paramInt = -1315851;
          label243:
          paramJSONObject.setTextColor(paramInt);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label344;
          }
          paramb.Jj.setText((CharSequence)localObject1);
          paramJSONObject = paramb.td;
          if (i == 0) {
            break label328;
          }
          paramInt = 2130846073;
          paramJSONObject.setImageResource(paramInt);
          paramb = paramb.Jj;
          if (!paramBoolean) {
            break label336;
          }
        }
        for (paramInt = -1315851;; paramInt = -7894119)
        {
          paramb.setTextColor(paramInt);
          return;
          i = 0;
          break;
          paramString1 = null;
          break label148;
          paramInt = -7894119;
          break label243;
          paramInt = 2130846075;
          break label281;
        }
        paramb.Jj.setVisibility(8);
        paramb.td.setVisibility(8);
        return;
      }
    }
  }
  
  private void a(xiy.b paramb, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = paramb.wF;
    int i;
    if (paramBoolean2) {
      i = -14474461;
    }
    for (;;)
    {
      ((View)localObject).setBackgroundDrawable(d(16, i));
      localObject = new ArrayList();
      a(paramb, paramString);
      c((ArrayList)localObject, paramJSONObject.optString("age"), paramJSONObject.optInt("gender"));
      e((ArrayList)localObject, paramJSONObject.optLong("popular"));
      a(paramb, paramJSONObject, paramBoolean2, a(paramb, paramJSONObject), paramJSONObject.optString("city"), paramJSONObject.optString("constellation"), paramJSONObject.optInt("distance", -1));
      a(paramb, (ArrayList)localObject, paramJSONObject.optJSONArray("personalTags"));
      a(paramb, paramJSONObject);
      b(paramb, paramJSONObject);
      b(paramb, paramBoolean1, paramJSONObject, paramString, paramBoolean2, paramBoolean3);
      return;
      if (paramBoolean3) {
        i = -657670;
      } else {
        i = -1;
      }
    }
  }
  
  private void b(xiy.b paramb, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("voiceUrl");
    int i = paramJSONObject.optInt("voiceDuration");
    if (TextUtils.isEmpty(str)) {
      paramb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
    }
    do
    {
      do
      {
        return;
      } while (!(this.mContext instanceof BaseActivity));
      paramb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
      paramb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(3);
      paramb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(str);
      paramb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
      paramb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)this.mContext);
      paramb.voiceUrl = str;
      paramb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setTag(paramb);
      paramb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(i);
    } while (this.aD.contains(Long.valueOf(paramb.IT)));
    report("", "0X800AA97", "", "");
  }
  
  private void b(xiy.b paramb, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramJSONObject = paramJSONObject.optString("topic_msg");
    int i;
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramJSONObject)))
    {
      paramb.wG.setVisibility(0);
      Object localObject = paramb.wG;
      if (paramBoolean2)
      {
        i = -14474461;
        ((View)localObject).setBackgroundDrawable(d(16, i));
        localObject = paramb.Jk;
        if (!paramBoolean2) {
          break label200;
        }
        i = -1712591883;
        label72:
        ((TextView)localObject).setTextColor(i);
        paramb.Jk.setText(paramJSONObject);
        paramb.topicName = paramJSONObject;
        label92:
        if (!this.aD.contains(Long.valueOf(paramb.IT)))
        {
          localObject = paramb.tagName;
          if (paramb.tagId != 1) {
            break label220;
          }
          paramJSONObject = (JSONObject)localObject;
          label126:
          report(paramString, "0X800AA94", (String)localObject, paramJSONObject);
        }
        paramString = paramb.Jl;
        if (!paramBoolean2) {
          break label238;
        }
        paramJSONObject = d(20, 435549946);
      }
    }
    for (;;)
    {
      paramString.setBackgroundDrawable(paramJSONObject);
      this.aD.add(Long.valueOf(paramb.IT));
      return;
      if (paramBoolean3)
      {
        i = -657670;
        break;
      }
      i = -1;
      break;
      label200:
      i = -7894119;
      break label72;
      paramb.wG.setVisibility(8);
      break label92;
      label220:
      if (TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = paramb.tagName;
        break label126;
      }
      break label126;
      label238:
      if (paramBoolean3) {
        paramJSONObject = d(20, -1);
      } else {
        paramJSONObject = this.mContext.getResources().getDrawable(2130839559);
      }
    }
  }
  
  private void c(ArrayList<xiy.a> paramArrayList, String paramString, int paramInt)
  {
    String str;
    label56:
    SpannableString localSpannableString;
    int i;
    label79:
    int j;
    if ((paramInt == 1) || (paramInt == 2))
    {
      if (paramInt != 1) {
        break label181;
      }
      str = this.mContext.getString(2131695654);
      if (!TextUtils.isEmpty(paramString)) {
        break label196;
      }
      paramString = str + " ";
      localSpannableString = new SpannableString(paramString);
      if (paramInt != 1) {
        break label225;
      }
      i = Color.parseColor("#3300CAFC");
      if (paramInt != 1) {
        break label236;
      }
      j = Color.parseColor("#02B2DD");
      label92:
      if (paramInt != 1) {
        break label247;
      }
    }
    label181:
    label196:
    label225:
    label236:
    label247:
    for (paramString = this.mContext.getResources().getDrawable(2130846016);; paramString = this.mContext.getResources().getDrawable(2130846015))
    {
      paramInt = aqnm.dip2px(11.0F);
      paramString.setBounds(0, 0, paramInt, paramInt);
      localSpannableString.setSpan(new ImageSpan(paramString, 1), 0, str.length(), 17);
      paramString = new xiy.a();
      paramString.J = localSpannableString;
      paramString.bgColor = i;
      paramString.textColor = j;
      paramArrayList.add(paramString);
      return;
      str = this.mContext.getString(2131693477);
      break;
      paramString = str + " " + paramString;
      break label56;
      i = Color.parseColor("#33FF80BF");
      break label79;
      j = Color.parseColor("#FF80BF");
      break label92;
    }
  }
  
  private Drawable d(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(aqnm.dip2px(paramInt1));
    localGradientDrawable.setColor(paramInt2);
    return localGradientDrawable;
  }
  
  private void e(ArrayList<xiy.a> paramArrayList, long paramLong)
  {
    if (paramLong > 0L)
    {
      int i = aqnm.dip2px(11.0F);
      Object localObject1 = this.mContext.getResources().getDrawable(2130846017);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      Object localObject2 = new ImageSpan((Drawable)localObject1, 1);
      String str = this.mContext.getString(2131695654);
      localObject1 = new SpannableString(str + " " + paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, 0, str.length(), 17);
      localObject2 = new xiy.a();
      ((xiy.a)localObject2).J = ((CharSequence)localObject1);
      ((xiy.a)localObject2).bgColor = Color.parseColor("#338173FF");
      ((xiy.a)localObject2).textColor = Color.parseColor("#8173FF");
      paramArrayList.add(localObject2);
    }
  }
  
  private String hv(String paramString)
  {
    return paramString.replaceAll("\n", " ").trim();
  }
  
  private void report(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    anot.a(this.app, "dc00898", "", paramString1, "qq_kuolie", paramString2, 0, 0, "", "", paramString3, paramString4);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    boolean bool4 = ThemeUtil.isNowThemeIsNight(this.app, false, null);
    MessageForLimitChatTopic localMessageForLimitChatTopic = (MessageForLimitChatTopic)paramMessageRecord;
    String str = localMessageForLimitChatTopic.getExtInfoFromExtStr("match_chat_msg_data_key");
    paramLinearLayout = null;
    paramwlz = null;
    if (TextUtils.isEmpty(str))
    {
      paramLinearLayout = paramwlz;
      if ((parama instanceof xiy.b)) {
        paramLinearLayout = (xiy.b)parama;
      }
      if ((paramView != null) && (paramLinearLayout != null)) {
        break label794;
      }
      paramView = LayoutInflater.from(this.mContext).inflate(2131559492, null);
      paramLinearLayout = new xiy.b();
      paramView.setTag(paramLinearLayout);
    }
    label788:
    label794:
    for (;;)
    {
      paramView.findViewById(2131371535).setVisibility(8);
      paramView.findViewById(2131371536).setVisibility(8);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView = ((TopicTextView)paramView.findViewById(2131380976));
      paramLinearLayout.fP = paramView.findViewById(2131363394);
      paramLinearLayout.IT = paramMessageRecord.uniseq;
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView.setTopicText(localMessageForLimitChatTopic.msg);
      paramLinearLayout.fP.setVisibility(0);
      if (bool4) {}
      for (int i = Color.rgb(34, 34, 34);; i = -1)
      {
        paramMessageRecord = d(8, i);
        paramLinearLayout.fP.setBackgroundDrawable(paramMessageRecord);
        if (aTl)
        {
          parama.E.append(localMessageForLimitChatTopic.msg);
          paramView.setContentDescription(parama.E.toString());
        }
        return paramView;
      }
      try
      {
        paramwlz = new JSONObject(str);
        if (paramwlz == null) {
          return new View(this.mContext);
        }
      }
      catch (JSONException paramwlz)
      {
        for (;;)
        {
          QLog.d("LimitChatTopicItemBuilder", 2, paramwlz, new Object[0]);
          paramwlz = null;
        }
        if ((parama instanceof xiy.b)) {
          paramLinearLayout = (xiy.b)parama;
        }
        if (paramView != null)
        {
          parama = paramLinearLayout;
          if (paramLinearLayout != null) {}
        }
        else
        {
          paramView = LayoutInflater.from(this.mContext).inflate(2131559492, null);
          parama = new xiy.b();
          paramView.setTag(parama);
        }
        boolean bool3 = false;
        boolean bool2 = false;
        i = paramwlz.optInt("matchTagId");
        paramLinearLayout = ((afsi)this.app.getManager(264)).a(paramMessageRecord.frienduin, false);
        parama.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo = paramLinearLayout;
        boolean bool1;
        if (i <= 1) {
          bool1 = false;
        }
        do
        {
          do
          {
            parama.IT = paramMessageRecord.uniseq;
            parama.wF = paramView.findViewById(2131371535);
            parama.wG = paramView.findViewById(2131371536);
            parama.Ji = ((TextView)paramView.findViewById(2131371175));
            parama.td = ((ImageView)paramView.findViewById(2131369887));
            parama.Jj = ((TextView)paramView.findViewById(2131380908));
            parama.c = ((ETTextView)paramView.findViewById(2131381075));
            parama.hg = ((LinearLayout)paramView.findViewById(2131370112));
            parama.hh = ((LinearLayout)paramView.findViewById(2131370113));
            parama.Jk = ((TextView)paramView.findViewById(2131380070));
            parama.Jl = ((TextView)paramView.findViewById(2131380069));
            parama.Jl.setTag(parama);
            parama.tc = ((ImageView)paramView.findViewById(2131363185));
            parama.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131382056));
            parama.Jl.setOnClickListener(this);
            parama.tc.setOnClickListener(this);
            parama.tagId = i;
            paramView.findViewById(2131363394).setVisibility(8);
            bool2 = "2971".equals(ThemeUtil.getCurrentThemeId());
            a(parama, bool1, paramwlz, paramMessageRecord.frienduin, bool4, bool2);
            return paramView;
            bool1 = bool2;
          } while (paramLinearLayout == null);
          bool1 = bool2;
        } while (TextUtils.isEmpty(paramLinearLayout.miniProfileMsg));
        bool2 = bool3;
        for (;;)
        {
          try
          {
            paramLinearLayout = new JSONObject(paramLinearLayout.miniProfileMsg);
            bool2 = bool3;
            if (paramLinearLayout.optBoolean("send_topic" + paramMessageRecord.uniseq, false)) {
              break label788;
            }
            bool1 = true;
            bool2 = bool1;
            parama.aV = paramLinearLayout;
          }
          catch (JSONException paramLinearLayout)
          {
            bool1 = bool2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("LimitChatTopicItemBuilder", 2, "" + paramLinearLayout);
          bool1 = bool2;
          break;
          bool1 = false;
        }
      }
    }
  }
  
  protected wjd.a a()
  {
    return new xiy.b();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return new aqob[0];
  }
  
  public void destroy()
  {
    super.destroy();
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatTopicItemBuilder", 2, "destroy ");
    }
    this.aD.clear();
    afyj.ddO();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!(localObject1 instanceof xiy.b)) {
        continue;
      }
      localObject1 = (xiy.b)localObject1;
      if (((xiy.b)localObject1).wG == null) {
        continue;
      }
      ((xiy.b)localObject1).wG.setVisibility(8);
      Object localObject2 = ((xiy.b)localObject1).topicName;
      if (localObject2 != null) {
        ujt.e(this.app, this.mContext, this.sessionInfo, (String)localObject2);
      }
      if ((((xiy.b)localObject1).jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) && (((xiy.b)localObject1).aV != null)) {}
      try
      {
        ((xiy.b)localObject1).aV.put("send_topic" + ((xiy.b)localObject1).IT, true);
        ((xiy.b)localObject1).jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.miniProfileMsg = ((xiy.b)localObject1).aV.toString();
        label165:
        ThreadManager.getSubThreadHandler().post(new LimitChatTopicItemBuilder.1(this, (xiy.b)localObject1));
        report(this.sessionInfo.aTl, "0X800AA95", ((xiy.b)localObject1).tagName, (String)localObject2);
        continue;
        report("", "0X800AA96", "", "");
        localObject1 = new ProfileActivity.AllInOne(this.sessionInfo.aTl, 96);
        ProfileActivity.a(this.mContext, (ProfileActivity.AllInOne)localObject1, 0, 2);
        continue;
        if ((!(paramView instanceof ExtendFriendVoiceView)) || (!(localObject1 instanceof xiy.b))) {
          continue;
        }
        Object localObject3 = (xiy.b)localObject1;
        localObject1 = (ExtendFriendVoiceView)paramView;
        if (((ExtendFriendVoiceView)localObject1).isAnimating())
        {
          ((ExtendFriendVoiceView)localObject1).stopAnimation();
          afyj.a((BaseActivity)this.mContext).aRx();
        }
        for (;;)
        {
          report("", "0X800AA98", "", "");
          break;
          if (!TextUtils.isEmpty(((xiy.b)localObject3).voiceUrl))
          {
            ((ExtendFriendVoiceView)localObject1).startAnimation();
            localObject2 = afyj.a((BaseActivity)this.mContext);
            MediaPlayerManager.a(this.app).stop(false);
            ((afyj)localObject2).pc(((xiy.b)localObject3).voiceUrl);
            localObject3 = ((afyj)localObject2).a();
            if ((localObject3 != null) && (localObject3 != localObject1) && (((ExtendFriendVoiceView)localObject3).isAnimating())) {
              ((ExtendFriendVoiceView)localObject3).stopAnimation();
            }
            ((afyj)localObject2).a((ExtendFriendVoiceView)localObject1);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        break label165;
      }
    }
  }
  
  public static class a
  {
    public CharSequence J;
    public int bgColor;
    public int textColor;
  }
  
  public static class b
    extends wjd.a
  {
    public long IT;
    TextView Ji;
    TextView Jj;
    TextView Jk;
    TextView Jl;
    public ExtendFriendUserInfo a;
    ExtendFriendVoiceView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
    TopicTextView jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView;
    JSONObject aV;
    ETTextView c;
    View fP;
    LinearLayout hg;
    LinearLayout hh;
    int tagId;
    String tagName;
    ImageView tc;
    ImageView td;
    String topicName;
    String voiceUrl;
    View wF;
    View wG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xiy
 * JD-Core Version:    0.7.0.1
 */