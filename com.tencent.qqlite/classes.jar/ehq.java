import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider.SosoSrvAddrType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ehq
{
  private static final int jdField_a_of_type_Int = 5;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public ehq(SosoSrvAddrProvider paramSosoSrvAddrProvider) {}
  
  private int a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = 5;
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        int k;
        if (paramArrayOfInt[i] < j)
        {
          k = paramArrayOfInt[i];
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j;
          if (paramArrayOfInt[i] == j)
          {
            localArrayList.add(Integer.valueOf(i));
            k = j;
          }
        }
      }
      if (localArrayList.size() > 0) {
        return ((Integer)localArrayList.get(0)).intValue();
      }
    }
    return -1;
  }
  
  public FileStorageServerListInfo a(SosoSrvAddrProvider.SosoSrvAddrType paramSosoSrvAddrType)
  {
    Object localObject2 = null;
    ArrayList localArrayList = SosoSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider, paramSosoSrvAddrType);
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        int i = a(a(paramSosoSrvAddrType));
        localObject1 = localObject2;
        if (i > -1)
        {
          localObject1 = localObject2;
          if (i < localArrayList.size()) {
            localObject1 = (FileStorageServerListInfo)localArrayList.get(i);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfInt = null;
  }
  
  public void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.vUrlEncodeServiceList != null) && (paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size() > 0)) {
      this.jdField_a_of_type_ArrayOfInt = new int[paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size()];
    }
  }
  
  public void a(SosoSrvAddrProvider.SosoSrvAddrType paramSosoSrvAddrType, String paramString)
  {
    try
    {
      ArrayList localArrayList = SosoSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider, paramSosoSrvAddrType);
      paramSosoSrvAddrType = a(paramSosoSrvAddrType);
      int i;
      if ((localArrayList != null) && (localArrayList.size() > 0) && (paramSosoSrvAddrType != null) && (paramSosoSrvAddrType.length > 0))
      {
        paramString = new URL(paramString).getHost();
        if ((paramString != null) && (paramString.length() > 0)) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < localArrayList.size())
        {
          String str = ((FileStorageServerListInfo)localArrayList.get(i)).sIP;
          if ((str == null) || (!str.equalsIgnoreCase(paramString))) {
            break label115;
          }
          if (paramSosoSrvAddrType.length > i) {
            paramSosoSrvAddrType[i] += 1;
          }
        }
        return;
        label115:
        i += 1;
      }
      return;
    }
    catch (MalformedURLException paramSosoSrvAddrType) {}
  }
  
  int[] a(SosoSrvAddrProvider.SosoSrvAddrType paramSosoSrvAddrType)
  {
    if (paramSosoSrvAddrType == SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV) {
      return this.jdField_a_of_type_ArrayOfInt;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ehq
 * JD-Core Version:    0.7.0.1
 */