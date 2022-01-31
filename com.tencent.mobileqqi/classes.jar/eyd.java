import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.adapter.ForwardFriendListAdapter;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class eyd
  implements Cursor
{
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private int jdField_a_of_type_Int = -1;
  private List jdField_a_of_type_JavaUtilList;
  
  public eyd(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private Object a(int paramInt)
  {
    Friends localFriends = (Friends)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return localFriends.name;
    case 1: 
      return localFriends.remark;
    case 2: 
      return localFriends.uin;
    case 3: 
      return localFriends.signature;
    case 4: 
      return Integer.valueOf(localFriends.status);
    case 5: 
      if (localFriends.isMqqOnLine) {
        return Integer.valueOf(1);
      }
      return Integer.valueOf(0);
    case 6: 
      return Integer.valueOf(localFriends.sqqtype);
    case 7: 
      return localFriends.alias;
    case 8: 
      return Integer.valueOf(localFriends.sqqOnLineState);
    case 9: 
      return Integer.valueOf(localFriends.detalStatusFlag);
    case 10: 
      return Integer.valueOf(localFriends.faceid);
    }
    return Integer.valueOf(this.jdField_a_of_type_Int);
  }
  
  private static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!Utils.b(localFriends.uin)) {
          localArrayList.add(localFriends);
        }
      }
    }
    return localArrayList;
  }
  
  private static eyd b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = ForwardFriendListAdapter.a();
    }
    return new eyd(a(((ContactFacade)paramQQAppInterface.getManager(49)).a(String.valueOf(paramInt))));
  }
  
  public void close() {}
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void deactivate() {}
  
  public byte[] getBlob(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public int getColumnCount()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getColumnIndex(String paramString)
  {
    return ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String getColumnName(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public String[] getColumnNames()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public double getDouble(int paramInt)
  {
    return ((Double)a(paramInt)).doubleValue();
  }
  
  public Bundle getExtras()
  {
    throw new UnsupportedOperationException();
  }
  
  public float getFloat(int paramInt)
  {
    return ((Float)a(paramInt)).floatValue();
  }
  
  public int getInt(int paramInt)
  {
    return ((Integer)a(paramInt)).intValue();
  }
  
  public long getLong(int paramInt)
  {
    return ((Long)a(paramInt)).longValue();
  }
  
  public Uri getNotificationUri()
  {
    return null;
  }
  
  public int getPosition()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public short getShort(int paramInt)
  {
    return ((Short)a(paramInt)).shortValue();
  }
  
  public String getString(int paramInt)
  {
    return (String)a(paramInt);
  }
  
  public int getType(int paramInt)
  {
    return 0;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return false;
  }
  
  public boolean isAfterLast()
  {
    return this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public boolean isBeforeFirst()
  {
    return this.jdField_a_of_type_Int < 0;
  }
  
  public boolean isClosed()
  {
    return false;
  }
  
  public boolean isFirst()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public boolean isLast()
  {
    return (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 1);
  }
  
  public boolean isNull(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean move(int paramInt)
  {
    return moveToPosition(this.jdField_a_of_type_Int + paramInt);
  }
  
  public boolean moveToFirst()
  {
    return moveToPosition(0);
  }
  
  public boolean moveToLast()
  {
    return moveToPosition(this.jdField_a_of_type_JavaUtilList.size() - 1);
  }
  
  public boolean moveToNext()
  {
    return moveToPosition(this.jdField_a_of_type_Int + 1);
  }
  
  public boolean moveToPosition(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      this.jdField_a_of_type_Int = paramInt;
      return true;
    }
    return false;
  }
  
  public boolean moveToPrevious()
  {
    return moveToPosition(this.jdField_a_of_type_Int - 1);
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  @Deprecated
  public boolean requery()
  {
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri) {}
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eyd
 * JD-Core Version:    0.7.0.1
 */