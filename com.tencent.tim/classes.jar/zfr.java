import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zfr
  extends BaseAdapter
{
  private LinkedHashMap<String, List<MessageRecord>> G = new LinkedHashMap();
  ChatHistoryC2CLinkFragment a;
  private zja b;
  View.OnClickListener de;
  View.OnClickListener df;
  private SimpleDateFormat e;
  private acff f;
  private ArrayMap<String, Boolean> i = new ArrayMap();
  private QQAppInterface mApp;
  Context mContext;
  private ArrayList<Object> rz = new ArrayList();
  
  public zfr(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment, zja paramzja)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.df = paramOnClickListener1;
    this.de = paramOnClickListener2;
    this.a = paramChatHistoryC2CLinkFragment;
    this.b = paramzja;
    this.e = new SimpleDateFormat("M月d日");
    this.f = ((acff)this.a.getActivity().app.getManager(51));
  }
  
  private void a(zfr.c paramc, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp)) {}
    for (;;)
    {
      try
      {
        Object localObject = ((MessageForArkApp)paramMessageRecord).getPreview();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool) {
          break label373;
        }
        String str2;
        TextView localTextView;
        QLog.e("Q.history.C2CLinkAdapter", 1, localException1, new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          j(zfr.c.a(paramc), (String)localObject);
          j = 1;
          if (j == 0) {
            zfr.c.a(paramc).setImageDrawable(this.mContext.getResources().getDrawable(2130851466));
          }
          str1 = hR(zjb.l(paramMessageRecord));
          if (!(paramMessageRecord instanceof MessageForArkApp)) {
            break label299;
          }
          str2 = ((MessageForArkApp)paramMessageRecord).getTitle();
          localTextView = zfr.c.a(paramc);
          localObject = str2;
          if (TextUtils.isEmpty(str2)) {
            localObject = str1;
          }
          localTextView.setText((CharSequence)localObject);
          localObject = new Date(paramMessageRecord.time * 1000L);
          localObject = this.e.format((Date)localObject);
          zfr.c.b(paramc).setText((CharSequence)localObject);
          zfr.c.c(paramc).setText(aqgv.D(this.a.getActivity().app, paramMessageRecord.senderuin));
          zfr.c.a(paramc).setOnClickListener(new zft(this, str1, paramc, paramMessageRecord));
          if (!this.a.aTT) {
            break label311;
          }
          zfr.c.a(paramc).setVisibility(0);
          bool = this.b.w(paramMessageRecord);
          zfr.c.a(paramc).setChecked(bool);
          paramMessageRecord = (LinearLayout.LayoutParams)zfr.c.a(paramc).getLayoutParams();
          paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, rpq.dip2px(this.mContext, 8.0F), paramMessageRecord.bottomMargin);
          zfr.c.a(paramc).setLayoutParams(paramMessageRecord);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            String str1;
            j = 1;
          }
        }
        localException1 = localException1;
        j = 0;
      }
      continue;
      label299:
      zfr.c.a(paramc).setText(str1);
      continue;
      label311:
      zfr.c.a(paramc).setVisibility(8);
      paramMessageRecord = (LinearLayout.LayoutParams)zfr.c.a(paramc).getLayoutParams();
      paramMessageRecord.setMargins(paramMessageRecord.leftMargin, paramMessageRecord.topMargin, rpq.dip2px(this.mContext, 50.0F), paramMessageRecord.bottomMargin);
      zfr.c.a(paramc).setLayoutParams(paramMessageRecord);
      return;
      label373:
      int j = 0;
    }
  }
  
  public static String getStructMsgInfo(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (paramString.equals("cover"))
    {
      localObject1 = paramAbsShareMsg.mContentCover;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
        {
          paramAbsShareMsg = (StructMsgForGeneralShare)paramAbsShareMsg;
          localObject2 = localObject1;
          if (paramAbsShareMsg.mStructMsgItemLists != null)
          {
            localObject2 = localObject1;
            if (!paramAbsShareMsg.mStructMsgItemLists.isEmpty())
            {
              Iterator localIterator = paramAbsShareMsg.mStructMsgItemLists.iterator();
              paramAbsShareMsg = (AbsShareMsg)localObject1;
              if (!localIterator.hasNext()) {
                return paramAbsShareMsg;
              }
              localObject2 = (anqu)localIterator.next();
              if (!(localObject2 instanceof anqv)) {
                break label216;
              }
              localObject1 = paramAbsShareMsg;
              if (((anqv)localObject2).rz == null) {
                break label251;
              }
              localObject1 = paramAbsShareMsg;
              if (((anqv)localObject2).rz.isEmpty()) {
                break label251;
              }
              localObject2 = ((anqv)localObject2).rz.iterator();
              localObject1 = paramAbsShareMsg;
              label178:
              do
              {
                paramAbsShareMsg = (AbsShareMsg)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramAbsShareMsg = (anqu)((Iterator)localObject2).next();
                if (!paramString.equals("cover")) {
                  break label208;
                }
                paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory(paramAbsShareMsg);
                localObject1 = paramAbsShareMsg;
              } while (TextUtils.isEmpty(paramAbsShareMsg));
              localObject1 = paramAbsShareMsg;
              if (TextUtils.isEmpty(paramAbsShareMsg)) {
                break label251;
              }
              localObject2 = paramAbsShareMsg;
            }
          }
        }
      }
    }
    label208:
    label216:
    label231:
    do
    {
      return localObject2;
      localObject1 = paramAbsShareMsg.mContentTitle;
      break;
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory(paramAbsShareMsg);
      break label178;
      if (!paramString.equals("cover")) {
        break label243;
      }
      paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((anqu)localObject2);
      localObject2 = paramAbsShareMsg;
    } while (!TextUtils.isEmpty(paramAbsShareMsg));
    for (;;)
    {
      break;
      label243:
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((anqu)localObject2);
      break label231;
      label251:
      paramAbsShareMsg = (AbsShareMsg)localObject1;
    }
    return paramAbsShareMsg;
  }
  
  private String hR(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Matcher localMatcher = ChatHistoryC2CLinkFragment.J.matcher(paramString);
      if (localMatcher.find()) {
        return paramString.substring(localMatcher.start(), localMatcher.end());
      }
    }
    return "";
  }
  
  public static void j(ImageView paramImageView, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130851466);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
    localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(aqbn.d(localLayoutParams.width, localLayoutParams.height, rpq.dip2px(localBaseApplication, 6.0F)));
      paramString.setDecodeHandler(aqbn.a);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramImageView.setImageDrawable(localDrawable);
    }
  }
  
  private void zv(String paramString)
  {
    boolean bool1 = false;
    if ((!this.i.containsKey(paramString)) || (!this.G.containsKey(paramString))) {
      return;
    }
    boolean bool2 = ((Boolean)this.i.get(paramString)).booleanValue();
    Object localObject = (List)this.G.get(paramString);
    if (bool2)
    {
      int j = this.rz.indexOf(paramString);
      this.rz.addAll(j + 1, (Collection)localObject);
      anot.a(this.mApp, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "1", "2", "", "");
    }
    for (;;)
    {
      localObject = this.i;
      if (!bool2) {
        bool1 = true;
      }
      ((ArrayMap)localObject).put(paramString, Boolean.valueOf(bool1));
      notifyDataSetChanged();
      return;
      this.rz.removeAll((Collection)localObject);
      anot.a(this.mApp, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "1", "1", "", "");
    }
  }
  
  public void a(URLImageView paramURLImageView, AbsShareMsg paramAbsShareMsg)
  {
    Object localObject2 = this.mContext.getResources();
    Object localObject1 = getStructMsgInfo(paramAbsShareMsg, "cover");
    int j = 2130851466;
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      j = 2130851475;
    }
    localObject2 = ((Resources)localObject2).getDrawable(j);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramURLImageView.setImageDrawable((Drawable)localObject2);
      return;
    }
    if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://"))) {}
    for (paramAbsShareMsg = Uri.fromFile(new File((String)localObject1)).toString();; paramAbsShareMsg = (AbsShareMsg)localObject1)
    {
      paramAbsShareMsg = URLDrawable.getDrawable(paramAbsShareMsg, (Drawable)localObject2, (Drawable)localObject2);
      localObject1 = paramURLImageView.getLayoutParams();
      paramAbsShareMsg.setTag(aqbn.d(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, rpq.dip2px(this.mContext, 6.0F)));
      paramAbsShareMsg.setDecodeHandler(aqbn.a);
      paramURLImageView.setImageDrawable(paramAbsShareMsg);
      return;
    }
  }
  
  public void b(LinkedHashMap<String, List<MessageRecord>> paramLinkedHashMap)
  {
    if ((paramLinkedHashMap == null) || (paramLinkedHashMap.isEmpty())) {
      return;
    }
    this.G = paramLinkedHashMap;
    this.i.clear();
    this.rz.clear();
    paramLinkedHashMap = this.G.entrySet().iterator();
    while (paramLinkedHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramLinkedHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      this.i.put(str, Boolean.valueOf(false));
      this.rz.add(str);
      this.rz.addAll((Collection)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CLinkAdapter", 2, "[setData]data size: " + this.G.size() + " header size: " + this.i.size() + " elements size: " + this.rz.size());
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CLinkAdapter", 2, "[getCount]data size: " + this.G.size() + " header size: " + this.i.size() + " elements size: " + this.rz.size());
    }
    return this.rz.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.rz.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject3;
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject2 = (MessageForStructing)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof zfr.b)))
      {
        localObject1 = (zfr.b)paramView.getTag();
        ((zfr.b)localObject1).entity = localObject2;
        ((zfr.b)localObject1).AI = this.a.aLX;
        if (!(localObject2 instanceof MessageForStructing)) {
          break label402;
        }
        if (localObject2 == null) {
          ((MessageForStructing)localObject2).parse();
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          localObject3 = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          a(((zfr.b)localObject1).aA, (AbsShareMsg)localObject3);
          ((zfr.b)localObject1).Ju.setText(getStructMsgInfo((AbsShareMsg)localObject3, "title"));
          localObject3 = aqgv.s(this.a.getActivity().app, ((MessageForStructing)localObject2).senderuin);
          ((zfr.b)localObject1).MK.setText((CharSequence)localObject3);
          localObject3 = new Date(((MessageForStructing)localObject2).time * 1000L);
          localObject3 = this.e.format((Date)localObject3);
          ((zfr.b)localObject1).ML.setText((CharSequence)localObject3);
        }
        label207:
        if (!this.a.aTT) {
          break label427;
        }
        ((zfr.b)localObject1).a.setVisibility(0);
        ((zfr.b)localObject1).a.setChecked(this.b.w(localObject2));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = new zfr.b();
        paramView = View.inflate(this.mContext, 2131558948, null);
        ((zfr.b)localObject1).layout = ((RelativeLayout)paramView.findViewById(2131376839));
        ((zfr.b)localObject1).a = ((CheckBox)paramView.findViewById(2131378826));
        ((zfr.b)localObject1).aA = ((URLImageView)paramView.findViewById(2131378824));
        ((zfr.b)localObject1).Ju = ((TextView)paramView.findViewById(2131363719));
        ((zfr.b)localObject1).MK = ((TextView)paramView.findViewById(2131372047));
        ((zfr.b)localObject1).ML = ((TextView)paramView.findViewById(2131365614));
        paramView.setTag(localObject1);
        ((zfr.b)localObject1).layout.setTag(localObject1);
        ((zfr.b)localObject1).layout.setOnClickListener(this.df);
        break;
        label402:
        ((zfr.b)localObject1).Ju.setText("");
        ((zfr.b)localObject1).MK.setText("");
        break label207;
        label427:
        ((zfr.b)localObject1).a.setVisibility(8);
      }
    }
    if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForReplyText)) || ((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForArkApp)))
    {
      if ((paramView != null) && ((paramView.getTag() instanceof zfr.c))) {
        localObject1 = (zfr.c)paramView.getTag();
      }
      for (;;)
      {
        a((zfr.c)localObject1, (MessageRecord)localObject2);
        break;
        paramView = LayoutInflater.from(this.mContext).inflate(2131558893, null);
        localObject1 = new zfr.c(paramView);
        paramView.setTag(localObject1);
      }
    }
    Object localObject1 = paramView;
    if ((localObject2 instanceof String))
    {
      if ((paramView == null) || (!(paramView.getTag() instanceof zfr.a))) {
        break label635;
      }
      localObject1 = (zfr.a)paramView.getTag();
      label578:
      localObject3 = ((zfr.a)localObject1).checkBox;
      if (((Boolean)this.i.get(localObject2)).booleanValue()) {
        break label712;
      }
    }
    label712:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBox)localObject3).setChecked(bool);
      ((zfr.a)localObject1).textView.setText((String)localObject2);
      localObject1 = paramView;
      paramView = (View)localObject1;
      break;
      label635:
      paramView = LayoutInflater.from(this.mContext).inflate(2131558892, null);
      localObject1 = new zfr.a();
      ((zfr.a)localObject1).checkBox = ((CheckBox)paramView.findViewById(2131369742));
      ((zfr.a)localObject1).textView = ((TextView)paramView.findViewById(2131379567));
      paramView.setTag(localObject1);
      paramView.setOnClickListener(new zfs(this, (zfr.a)localObject1));
      break label578;
    }
  }
  
  static class a
  {
    CheckBox checkBox;
    TextView textView;
  }
  
  public class b
  {
    public String AI;
    public TextView Ju;
    public TextView MK;
    public TextView ML;
    public CheckBox a;
    public URLImageView aA;
    public Object entity;
    public RelativeLayout layout;
    
    public b() {}
  }
  
  public class c
  {
    private CheckBox D;
    private TextView MM;
    private TextView MN;
    private View itemView;
    private RelativeLayout iz;
    private TextView titleText;
    private ImageView vk;
    
    c(View paramView)
    {
      this.itemView = paramView.findViewById(2131369545);
      this.D = ((CheckBox)paramView.findViewById(2131370511));
      this.vk = ((ImageView)paramView.findViewById(2131370517));
      this.titleText = ((TextView)paramView.findViewById(2131379862));
      this.MM = ((TextView)paramView.findViewById(2131365614));
      this.MN = ((TextView)paramView.findViewById(2131372382));
      this.iz = ((RelativeLayout)paramView.findViewById(2131365739));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfr
 * JD-Core Version:    0.7.0.1
 */