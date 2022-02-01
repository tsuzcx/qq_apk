import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.MsgCardView;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import java.util.ArrayList;
import java.util.Iterator;

public class avtk
  extends BaseAdapter
{
  private ArrayList<MQMsg> ET = new ArrayList();
  private avsm jdField_a_of_type_Avsm;
  private avtk.a jdField_a_of_type_Avtk$a;
  private avts jdField_a_of_type_Avts;
  private boolean doM;
  private boolean doN;
  private boolean isNightMode;
  private BaseActivity mActivity;
  
  public avtk(BaseActivity paramBaseActivity)
  {
    this.mActivity = paramBaseActivity;
  }
  
  public MQMsg a()
  {
    if (this.ET.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.ET.iterator();
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      MQMsg localMQMsg = (MQMsg)localIterator.next();
      Object localObject2;
      if (localObject1 == null) {
        localObject2 = localMQMsg;
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        localObject2 = localMQMsg;
        if (localObject1.pushTime > localMQMsg.pushTime) {
          localObject2 = localObject1;
        }
      }
    }
    return localObject1;
  }
  
  public void a(avsm paramavsm, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Avsm = paramavsm;
    this.doM = paramBoolean1;
    this.doN = paramBoolean2;
  }
  
  public void a(avtk.a parama)
  {
    this.jdField_a_of_type_Avtk$a = parama;
  }
  
  public void a(MQMsg paramMQMsg)
  {
    int i;
    MQMsg localMQMsg;
    if ((this.ET != null) && (paramMQMsg != null))
    {
      i = 0;
      if (i >= this.ET.size()) {
        break label131;
      }
      localMQMsg = (MQMsg)this.ET.get(i);
      if ((localMQMsg == null) || (localMQMsg.pushTime != paramMQMsg.pushTime)) {
        break label86;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        this.ET.add(0, paramMQMsg);
        if (this.jdField_a_of_type_Avsm != null) {
          this.jdField_a_of_type_Avsm.clearCache();
        }
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        label86:
        i += 1;
        break;
        if (paramMQMsg != localMQMsg)
        {
          this.ET.set(i, paramMQMsg);
          if ((i == 0) && (this.jdField_a_of_type_Avsm != null)) {
            this.jdField_a_of_type_Avsm.clearCache();
          }
        }
      }
      label131:
      localMQMsg = null;
      i = -1;
    }
  }
  
  public void aE(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.ET.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MQMsg)localIterator.next();
      if ((localObject != null) && (((MQMsg)localObject).pushTime == paramLong) && (((MQMsg)localObject).msgInteractData != null) && (((MQMsg)localObject).msgInteractData.likeCell != null) && (((MQMsg)localObject).msgInteractData.likeCell.liked != paramBoolean))
      {
        ((MQMsg)localObject).msgInteractData.likeCell.liked = paramBoolean;
        if (paramBoolean)
        {
          localObject = ((MQMsg)localObject).msgInteractData.likeCell;
          ((MQLikeCell)localObject).totalLike += 1;
        }
        else
        {
          localObject = ((MQMsg)localObject).msgInteractData.likeCell;
          ((MQLikeCell)localObject).totalLike -= 1;
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean aLF()
  {
    MQMsg localMQMsg = a();
    if ((localMQMsg.msgBody.photolist == null) || (localMQMsg.msgBody.photolist.isEmpty()))
    {
      boolean bool = this.ET.remove(localMQMsg);
      if ((bool) && (this.jdField_a_of_type_Avsm != null)) {
        this.jdField_a_of_type_Avsm.clearCache();
      }
      return bool;
    }
    return false;
  }
  
  public void fs(ArrayList<MQMsg> paramArrayList)
  {
    if (this.jdField_a_of_type_Avsm != null) {
      this.jdField_a_of_type_Avsm.clearCache();
    }
    if (paramArrayList != null)
    {
      this.ET.clear();
      this.ET.addAll(paramArrayList);
      notifyDataSetChanged();
      return;
    }
    this.ET.clear();
    notifyDataSetChanged();
  }
  
  public void ft(ArrayList<MQMsg> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.ET.addAll(paramArrayList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.ET.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.ET == null) || (paramInt < 0) || (paramInt >= this.ET.size())) {
      return null;
    }
    return this.ET.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    int i;
    if (paramView == null)
    {
      paramView = new MsgCardView(this.mActivity, this.mActivity.app);
      paramView.setMsgOnClickListener(this.jdField_a_of_type_Avts);
      paramView.setData(paramInt, (MQMsg)getItem(paramInt), this.isNightMode, this.doN);
      if ((paramInt != 0) || (this.jdField_a_of_type_Avsm == null)) {
        break label228;
      }
      boolean bool = this.jdField_a_of_type_Avsm.a(((MsgCardView)paramView).r(), (MQMsg)getItem(paramInt));
      Object localObject = ((MsgCardView)paramView).af();
      if (!bool) {
        break label214;
      }
      i = 0;
      label109:
      ((TextView)localObject).setVisibility(i);
      localObject = ((MsgCardView)paramView).r();
      if (!bool) {
        break label221;
      }
      i = j;
      label134:
      ((LinearLayout)localObject).setVisibility(i);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Avtk$a != null) {
        this.jdField_a_of_type_Avtk$a.b(paramInt, paramView, paramViewGroup);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      ((MsgCardView)paramView).setMsgOnClickListener(this.jdField_a_of_type_Avts);
      ((MsgCardView)paramView).setData(paramInt, (MQMsg)getItem(paramInt), this.isNightMode, this.doN);
      break;
      label214:
      i = 8;
      break label109;
      label221:
      i = 8;
      break label134;
      label228:
      ((MsgCardView)paramView).af().setVisibility(8);
      ((MsgCardView)paramView).r().setVisibility(8);
    }
  }
  
  public void setMsgOnClickListener(avts paramavts)
  {
    this.jdField_a_of_type_Avts = paramavts;
  }
  
  public void setNightMode(boolean paramBoolean)
  {
    this.isNightMode = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, View paramView, ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtk
 * JD-Core Version:    0.7.0.1
 */