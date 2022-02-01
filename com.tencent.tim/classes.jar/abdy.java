import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class abdy
  extends BaseAdapter
{
  uou b;
  View.OnClickListener de;
  View.OnClickListener df;
  Context mContext;
  public ArrayList<Object> mData;
  
  public abdy(Context paramContext, ArrayList<Object> paramArrayList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, uou paramuou)
  {
    this.mContext = paramContext;
    this.mData = paramArrayList;
    this.df = paramOnClickListener1;
    this.de = paramOnClickListener2;
    this.b = paramuou;
  }
  
  public static boolean U(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      Object localObject = ((MessageForStructing)paramMessageRecord).structingMsg;
      if (localObject == null) {
        ((MessageForStructing)paramMessageRecord).parse();
      }
      if (jof.a(paramMessageRecord)) {
        return false;
      }
      if (localObject != null)
      {
        if ((((AbsStructMsg)localObject).fwFlag == 1) || (((AbsStructMsg)localObject).hasFlag(1))) {
          return false;
        }
        if ((localObject instanceof StructMsgForAudioShare)) {
          return true;
        }
        if ((localObject instanceof StructMsgForGeneralShare))
        {
          paramMessageRecord = getStructMsgInfo((StructMsgForGeneralShare)localObject, "cover");
          localObject = getStructMsgInfo((StructMsgForGeneralShare)localObject, "title");
          if ((!TextUtils.isEmpty(paramMessageRecord)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            return true;
          }
        }
      }
    }
    return false;
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
                break label214;
              }
              localObject1 = paramAbsShareMsg;
              if (((anqv)localObject2).rz == null) {
                break label248;
              }
              localObject1 = paramAbsShareMsg;
              if (((anqv)localObject2).rz.isEmpty()) {
                break label248;
              }
              localObject2 = ((anqv)localObject2).rz.iterator();
              localObject1 = paramAbsShareMsg;
              label176:
              do
              {
                paramAbsShareMsg = (AbsShareMsg)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramAbsShareMsg = (anqu)((Iterator)localObject2).next();
                if (!paramString.equals("cover")) {
                  break label206;
                }
                paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory(paramAbsShareMsg);
                localObject1 = paramAbsShareMsg;
              } while (TextUtils.isEmpty(paramAbsShareMsg));
              localObject1 = paramAbsShareMsg;
              if (TextUtils.isEmpty(paramAbsShareMsg)) {
                break label248;
              }
              localObject2 = paramAbsShareMsg;
            }
          }
        }
      }
    }
    label206:
    label214:
    label228:
    do
    {
      return localObject2;
      localObject1 = paramAbsShareMsg.mContentTitle;
      break;
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory(paramAbsShareMsg);
      break label176;
      if (!paramString.equals("cover")) {
        break label240;
      }
      paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((anqu)localObject2);
      localObject2 = paramAbsShareMsg;
    } while (!TextUtils.isEmpty(paramAbsShareMsg));
    for (;;)
    {
      break;
      label240:
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((anqu)localObject2);
      break label228;
      label248:
      paramAbsShareMsg = (AbsShareMsg)localObject1;
    }
    return paramAbsShareMsg;
  }
  
  public void a(URLImageView paramURLImageView, AbsShareMsg paramAbsShareMsg)
  {
    Object localObject = this.mContext.getResources();
    String str = getStructMsgInfo(paramAbsShareMsg, "cover");
    int i = 2130851465;
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      i = 2130851475;
    }
    localObject = ((Resources)localObject).getDrawable(i);
    if (TextUtils.isEmpty(str))
    {
      paramURLImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    if ((!str.startsWith("http://")) && (!str.startsWith("https://"))) {}
    for (paramAbsShareMsg = Uri.fromFile(new File(str)).toString();; paramAbsShareMsg = str)
    {
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAbsShareMsg, (Drawable)localObject, (Drawable)localObject));
      return;
    }
  }
  
  public int getCount()
  {
    if (this.mData != null) {
      return this.mData.size();
    }
    return 0;
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
    Object localObject2 = getItem(paramInt);
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject2 = (MessageForStructing)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof abdy.a)))
      {
        localObject1 = (abdy.a)paramView.getTag();
        ((abdy.a)localObject1).entity = localObject2;
        ((abdy.a)localObject1).AI = ((uos)this.b).aLX;
        if (!(localObject2 instanceof MessageForStructing)) {
          break label336;
        }
        if (localObject2 == null) {
          ((MessageForStructing)localObject2).parse();
        }
        if ((((MessageForStructing)localObject2).structingMsg != null) && ((((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg)))
        {
          AbsShareMsg localAbsShareMsg = (AbsShareMsg)((MessageForStructing)localObject2).structingMsg;
          a(((abdy.a)localObject1).aA, localAbsShareMsg);
          ((abdy.a)localObject1).Ju.setText(getStructMsgInfo(localAbsShareMsg, "title"));
          ((abdy.a)localObject1).MK.setText(localAbsShareMsg.mSourceName);
        }
        label153:
        if (!this.b.bC()) {
          break label361;
        }
        ((abdy.a)localObject1).a.setVisibility(0);
        ((abdy.a)localObject1).a.setChecked(this.b.a.c((ChatMessage)localObject2));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = new abdy.a();
        paramView = View.inflate(this.mContext, 2131563123, null);
        ((abdy.a)localObject1).layout = ((RelativeLayout)paramView.findViewById(2131376839));
        ((abdy.a)localObject1).a = ((CheckBox)paramView.findViewById(2131378826));
        ((abdy.a)localObject1).aA = ((URLImageView)paramView.findViewById(2131378824));
        ((abdy.a)localObject1).Ju = ((TextView)paramView.findViewById(2131363719));
        ((abdy.a)localObject1).MK = ((TextView)paramView.findViewById(2131372047));
        paramView.setTag(localObject1);
        ((abdy.a)localObject1).layout.setTag(localObject1);
        ((abdy.a)localObject1).layout.setOnClickListener(this.df);
        break;
        label336:
        ((abdy.a)localObject1).Ju.setText("");
        ((abdy.a)localObject1).MK.setText("");
        break label153;
        label361:
        ((abdy.a)localObject1).a.setVisibility(8);
      }
    }
    Object localObject1 = paramView;
    if ((localObject2 instanceof String))
    {
      if ((paramView == null) || (!(paramView.getTag() instanceof TextView))) {
        break label427;
      }
      localObject1 = (TextView)paramView.getTag();
    }
    for (;;)
    {
      ((TextView)localObject1).setText((String)localObject2);
      localObject1 = paramView;
      paramView = (View)localObject1;
      break;
      label427:
      paramView = View.inflate(this.mContext, 2131563124, null);
      localObject1 = (TextView)paramView.findViewById(2131379419);
      paramView.setTag(localObject1);
    }
  }
  
  public class a
  {
    public String AI;
    public TextView Ju;
    public TextView MK;
    public CheckBox a;
    public URLImageView aA;
    public Object entity;
    public RelativeLayout layout;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdy
 * JD-Core Version:    0.7.0.1
 */