import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unify.search.UnifySearchDiscovery.HotSearchItem;
import pb.unify.search.UnifySearchDiscovery.Result;
import pb.unite.search.DynamicDiscovery.HotSearchItem;
import pb.unite.search.DynamicDiscovery.Result;

public abstract class amrb
  implements ampv
{
  public final Object LOCK = new Object();
  public int bms;
  public boolean cEd;
  public int dDB;
  public byte[] mRawData;
  
  public amrb(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.dDB = paramInt1;
    this.bms = paramInt2;
    this.cEd = paramBoolean;
  }
  
  public amrb(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    this.dDB = paramInt1;
    this.mRawData = paramArrayOfByte;
    this.bms = paramInt2;
    this.cEd = paramBoolean;
  }
  
  public static List<amrb> a(QQAppInterface paramQQAppInterface, List<DynamicDiscovery.Result> paramList, int paramInt)
  {
    QLog.d("SearchEntryDataModel818searchProto_old", 2, "convertPbDataToModel");
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[paramList.size()];
    if (paramList.size() > 0)
    {
      int i = 0;
      if (i < paramList.size())
      {
        Object localObject = (DynamicDiscovery.Result)paramList.get(i);
        arrayOfInt[i] = ((DynamicDiscovery.Result)paramList.get(i)).type.get();
        int k = ((DynamicDiscovery.Result)localObject).type.get();
        switch (k)
        {
        case 2: 
        default: 
          localObject = null;
        }
        for (;;)
        {
          if (localObject != null)
          {
            ((amrb)localObject).dOs();
            localArrayList.add(localObject);
          }
          i += 1;
          break;
          List localList = ((DynamicDiscovery.Result)localObject).hot_search_items.get();
          if (localList.size() < 6)
          {
            localObject = null;
          }
          else
          {
            String[] arrayOfString = new String[localList.size()];
            int j = 0;
            while (j < localList.size())
            {
              arrayOfString[j] = ((DynamicDiscovery.HotSearchItem)localList.get(j)).title.get().toStringUtf8();
              j += 1;
            }
            aqmj.n(paramQQAppInterface.getCurrentAccountUin(), arrayOfString);
            localObject = new HotWordSearchEntryDataModel(paramQQAppInterface, k, ((DynamicDiscovery.Result)localObject).toByteArray(), paramInt, false);
            continue;
            localObject = new amof(paramQQAppInterface, k, ((DynamicDiscovery.Result)localObject).toByteArray(), paramInt, false);
          }
        }
      }
      boolean bool = c(arrayOfInt, amkd.a(paramQQAppInterface, paramInt, false));
      amkd.a(paramQQAppInterface, paramInt, bool, false);
      if (bool) {
        amkd.a(paramQQAppInterface, paramInt, arrayOfInt, false);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryDataModel", 2, "convertPbDataToModel, modelList = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public static List<amrb> b(QQAppInterface paramQQAppInterface, List<UnifySearchDiscovery.Result> paramList, int paramInt)
  {
    QLog.d("SearchEntryDataModel818searchProto_new", 2, "convertUnifyPbDataToModel");
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[paramList.size()];
    if (paramList.size() > 0)
    {
      int i = 0;
      if (i < paramList.size())
      {
        Object localObject = (UnifySearchDiscovery.Result)paramList.get(i);
        arrayOfInt[i] = ((UnifySearchDiscovery.Result)paramList.get(i)).type.get();
        int k = ((UnifySearchDiscovery.Result)localObject).type.get();
        switch (k)
        {
        case 2: 
        default: 
          localObject = null;
        }
        for (;;)
        {
          if (localObject != null)
          {
            ((amrb)localObject).dOs();
            localArrayList.add(localObject);
          }
          i += 1;
          break;
          List localList = ((UnifySearchDiscovery.Result)localObject).hot_search_items.get();
          if (localList.size() < 6)
          {
            localObject = null;
          }
          else
          {
            String[] arrayOfString = new String[localList.size()];
            int j = 0;
            while (j < localList.size())
            {
              arrayOfString[j] = ((UnifySearchDiscovery.HotSearchItem)localList.get(j)).title.get().toStringUtf8();
              j += 1;
            }
            aqmj.o(paramQQAppInterface.getCurrentAccountUin(), arrayOfString);
            localObject = new HotWordSearchEntryDataModel(paramQQAppInterface, k, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
            continue;
            localObject = new amof(paramQQAppInterface, k, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
          }
        }
      }
      boolean bool = c(arrayOfInt, amkd.a(paramQQAppInterface, paramInt, true));
      amkd.a(paramQQAppInterface, paramInt, bool, true);
      if (bool) {
        amkd.a(paramQQAppInterface, paramInt, arrayOfInt, true);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryDataModel", 2, "convertPbDataToModel, modelList = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private static boolean c(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null))
    {
      bool1 = true;
      return bool1;
    }
    if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayOfInt1.length) {
        break;
      }
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return true;
      }
      i += 1;
    }
  }
  
  public abstract void bu(byte[] paramArrayOfByte);
  
  public void dOr()
  {
    synchronized (this.LOCK)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (!this.cEd)
      {
        this.mRawData = aqhq.fileToBytes(BaseApplication.getContext().getFileStreamPath("search_discovery_sp_prefixpref_search_model_data" + localQQAppInterface.getCurrentAccountUin() + "_" + this.dDB + "_" + this.bms));
        bu(this.mRawData);
        return;
      }
      this.mRawData = aqhq.fileToBytes(BaseApplication.getContext().getFileStreamPath("search_discovery_sp_prefix_unifypref_search_model_data" + localQQAppInterface.getCurrentAccountUin() + "_" + this.dDB + "_" + this.bms));
      bu(this.mRawData);
    }
  }
  
  protected void dOs()
  {
    if (this.mRawData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchEntryDataModel", 2, "saveDataToLocal, mRawData is null");
      }
      return;
    }
    ThreadManager.post(new SearchEntryDataModel.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrb
 * JD-Core Version:    0.7.0.1
 */