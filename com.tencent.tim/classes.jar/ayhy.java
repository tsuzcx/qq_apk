import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ayhy
  extends aygy
{
  public SparseArray<ptz> aX = new SparseArray(6);
  
  public ayhy(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  @NonNull
  private List<Long> aw(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localArrayList.add(Long.valueOf(Long.valueOf(str).longValue()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ram.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
      }
    }
    return localArrayList;
  }
  
  private void btt()
  {
    Activity localActivity = a().getActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, ShareToActivity.class);
      ptz localptz = (ptz)this.aX.get(this.b.tj());
      if (!ptz.a(localptz)) {
        localIntent.putStringArrayListExtra("share_to_group_key", new ArrayList(localptz.mA));
      }
      localActivity.startActivityForResult(localIntent, 5555);
    }
  }
  
  private void btu()
  {
    ayde localayde = (ayde)super.a(ayde.class);
    if (ptz.a((ptz)this.aX.get(this.b.tj())))
    {
      localayde.wP(2130847707);
      return;
    }
    localayde.wP(2130847708);
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    Object localObject = (ptz)this.aX.get(paramInt);
    if (ptz.a((ptz)localObject)) {}
    for (;;)
    {
      return;
      localObject = aw(((ptz)localObject).mA);
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList;
      if (((List)localObject).size() > 0)
      {
        localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
        localVideoSpreadGroupList.group_list.set((List)localObject);
        localVideoSpreadGroupList.visibility_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
      }
      for (paramayqb.g.spreadGroupBytes = localVideoSpreadGroupList.toByteArray(); QLog.isColorLevel(); paramayqb.g.spreadGroupBytes = null)
      {
        QLog.d("zivonchen", 2, "editVideoPrePublish fragmentIndex = " + paramInt + ", shareGroupArray: " + paramayqb.g.spreadGroupBytes);
        return;
      }
    }
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      btu();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 5555)
    {
      if (paramInt2 == 1)
      {
        paramIntent = paramIntent.getStringArrayListExtra("share_to_group_key");
        if (paramIntent != null) {
          this.aX.put(this.b.tj(), new ptz(paramIntent));
        }
      }
      this.b.changeState(0);
      btu();
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    btt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhy
 * JD-Core Version:    0.7.0.1
 */