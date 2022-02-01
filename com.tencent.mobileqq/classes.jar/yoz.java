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

public class yoz
  extends ynu
{
  public SparseArray<wlj> a;
  
  public yoz(@NonNull ynw paramynw)
  {
    super(paramynw);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
  }
  
  @NonNull
  private List<Long> a(@NonNull List<String> paramList)
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
        ykq.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
      }
    }
    return localArrayList;
  }
  
  private void g()
  {
    Activity localActivity = a().getActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, ShareToActivity.class);
      wlj localwlj = (wlj)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Ynw.a());
      if (!wlj.a(localwlj)) {
        localIntent.putStringArrayListExtra("share_to_group_key", new ArrayList(localwlj.a));
      }
      localActivity.startActivityForResult(localIntent, 5555);
    }
  }
  
  private void h()
  {
    ylb localylb = (ylb)super.a(ylb.class);
    if (wlj.a((wlj)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Ynw.a())))
    {
      localylb.b(2130846845);
      return;
    }
    localylb.b(2130846846);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 5555)
    {
      if (paramInt2 == 1)
      {
        paramIntent = paramIntent.getStringArrayListExtra("share_to_group_key");
        if (paramIntent != null) {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Ynw.a(), new wlj(paramIntent));
        }
      }
      this.jdField_a_of_type_Ynw.a(0);
      h();
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    g();
  }
  
  public void a(int paramInt, @NonNull yya paramyya)
  {
    super.a(paramInt, paramyya);
    ??? = (wlj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (wlj.a((wlj)???)) {}
    for (;;)
    {
      return;
      List localList = a(((wlj)???).a);
      if (localList.size() > 0) {}
      synchronized (this.jdField_a_of_type_Ynw)
      {
        qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
        byte[] arrayOfByte = paramyya.a.spreadGroupBytes;
        if (arrayOfByte != null) {}
        try
        {
          localVideoSpreadGroupList.mergeFrom(paramyya.a.spreadGroupBytes);
          localVideoSpreadGroupList.group_list.set(localList);
          localVideoSpreadGroupList.visibility_type.set(2);
          localVideoSpreadGroupList.setHasFlag(true);
          paramyya.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
          ykq.d("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish fragment index = %d, qq-group count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localList.size()) });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("zivonchen", 2, "editVideoPrePublish fragmentIndex = " + paramInt + ", shareGroupArray: " + paramyya.a.spreadGroupBytes);
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            ykq.c("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
          }
        }
      }
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yoz
 * JD-Core Version:    0.7.0.1
 */