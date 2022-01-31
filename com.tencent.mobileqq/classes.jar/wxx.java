import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo;

class wxx
  extends Handler
{
  public wxx(wxu paramwxu)
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Bundle localBundle;
    int i;
    boolean bool;
    int j;
    Iterator localIterator;
    label702:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localBundle = paramMessage.getData();
          } while (localBundle == null);
          i = localBundle.getInt("seq", -1);
          switch (paramMessage.what)
          {
          }
        } while (i == -1);
        paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      } while (paramMessage == null);
      paramMessage.a(localBundle);
      return;
      i = localBundle.getInt("type");
      bool = localBundle.getBoolean("isSuccess", false);
      paramMessage = localBundle.getSerializable("data");
      j = localBundle.getInt("observer_type");
      localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    } while (!localIterator.hasNext());
    ajtg localajtg = (ajtg)localIterator.next();
    Object localObject;
    if (((j == 1) && ((localajtg instanceof ajzm))) || ((j == 2) && ((localajtg instanceof ajxl)))) {
      if (28 == i)
      {
        localObject = localBundle.getByteArray("groupInfo");
        paramMessage = new cmd0x7f5.GroupInfo();
        if (localObject == null) {
          break label2403;
        }
      }
    }
    label2403:
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom((byte[])localObject);
        localObject = new Object[2];
        localObject[0] = Integer.valueOf(localBundle.getInt("count"));
        localObject[1] = paramMessage;
        paramMessage = (Message)localObject;
        localajtg.onUpdate(i, bool, paramMessage);
      }
      catch (InvalidProtocolBufferMicroException paramMessage)
      {
        paramMessage.printStackTrace();
        paramMessage = null;
        continue;
      }
      if ((j == 3) && ((localajtg instanceof akim)))
      {
        ((akim)localajtg).onUpdate(i, bool, paramMessage);
        break label702;
      }
      if ((j == 4) && ((localajtg instanceof ajta)))
      {
        ((ajta)localajtg).onUpdate(i, bool, paramMessage);
        break label702;
      }
      if ((j != 5) || (!(localajtg instanceof ajyt))) {
        break label702;
      }
      ((ajyt)localajtg).onUpdate(i, bool, paramMessage);
      break label702;
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i != -1)
      {
        j = localBundle.getInt("retCode", -1);
        int k = localBundle.getInt("rate", -1);
        paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
        if (paramMessage != null)
        {
          paramMessage.a(localBundle);
          if ((j != 0) || (k == 100))
          {
            QLog.d("ReadInJoy", 4, "download finish:" + localBundle);
            this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN retCode=" + j + ",rate=" + k);
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN callback null");
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN seq=" + i);
      return;
      if (this.a.jdField_a_of_type_Ajta == null) {
        break;
      }
      paramMessage = localBundle.getString("pageUrl");
      localObject = localBundle.getStringArrayList("lstVideoUrl");
      i = localBundle.getInt("totalTime", 0);
      this.a.jdField_a_of_type_Ajta.onUpdate(localBundle.getInt("type"), true, new Object[] { paramMessage, localObject, Integer.valueOf(i) });
      return;
      this.a.a().a(localBundle);
      return;
      this.a.a().a(localBundle);
      return;
      localObject = (ajtg)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(localBundle.getInt("req_seq"));
      if (localObject == null) {
        break;
      }
      this.a.jdField_a_of_type_AndroidUtilSparseArray.remove(localBundle.getInt("req_seq"));
      ((ajtg)localObject).onUpdate(paramMessage.what, true, localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq1", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq1", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if ((i == -1) || (paramMessage == null)) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      paramMessage = localBundle.getString("FileName");
      i = localBundle.getInt("Status");
      if ((wxu.a(this.a) == null) || (paramMessage == null) || (wxu.a(this.a).get(paramMessage) == null)) {
        break;
      }
      j = ((Integer)wxu.a(this.a).get(paramMessage)).intValue();
      if (j == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      if (i != 11) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(j));
      return;
      paramMessage = localBundle.getString("FilePath");
      i = localBundle.getInt("size");
      localObject = paramMessage + "/" + i;
      if ((wxu.b(this.a) == null) || (paramMessage == null) || (wxu.b(this.a).get(localObject) == null)) {
        break;
      }
      i = ((Integer)wxu.b(this.a).get(localObject)).intValue();
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      bool = localBundle.getBoolean("actionFinish");
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      if (!bool) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      return;
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (wxu.a(this.a) == null) {
        break;
      }
      wxu.a(this.a).a(localBundle);
      return;
      if (wxu.a(this.a) == null) {
        break;
      }
      wxu.a(this.a).a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      localBundle.putString("type", "troopCreateOpenAIO");
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      localBundle.putBoolean("isSuccess", localBundle.getBoolean("isSuccess"));
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (wxw)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if ((paramMessage == null) || (localBundle == null)) {
        break;
      }
      paramMessage.a(localBundle);
      return;
      if (i == -1) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxx
 * JD-Core Version:    0.7.0.1
 */