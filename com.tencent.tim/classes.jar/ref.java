import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ref
  extends rdb
{
  public SparseArray<ptz> aX = new SparseArray(6);
  
  public ref(@NonNull rdc paramrdc)
  {
    super(paramrdc);
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
    raz localraz = (raz)super.a(raz.class);
    if (ptz.a((ptz)this.aX.get(this.b.tj())))
    {
      localraz.wP(2130847707);
      return;
    }
    localraz.wP(2130847708);
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    super.a(paramInt, paramrkm);
    ??? = (ptz)this.aX.get(paramInt);
    if (ptz.a((ptz)???)) {}
    for (;;)
    {
      return;
      List localList = aw(((ptz)???).mA);
      if (localList.size() > 0) {}
      synchronized (this.b)
      {
        qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
        byte[] arrayOfByte = paramrkm.g.spreadGroupBytes;
        if (arrayOfByte != null) {}
        try
        {
          localVideoSpreadGroupList.mergeFrom(paramrkm.g.spreadGroupBytes);
          localVideoSpreadGroupList.group_list.set(localList);
          localVideoSpreadGroupList.visibility_type.set(2);
          localVideoSpreadGroupList.setHasFlag(true);
          paramrkm.g.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
          ram.w("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish fragment index = %d, qq-group count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localList.size()) });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("zivonchen", 2, "editVideoPrePublish fragmentIndex = " + paramInt + ", shareGroupArray: " + paramrkm.g.spreadGroupBytes);
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            ram.e("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
          }
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ref
 * JD-Core Version:    0.7.0.1
 */