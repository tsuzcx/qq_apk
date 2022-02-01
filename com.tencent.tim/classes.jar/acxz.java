import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.data.FTSMessageDelete;
import com.tencent.mobileqq.data.FTSMessageSync;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.data.fts.FTSMessageForDel;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.persistence.fts.FTSMsgCounter;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.MsgExts;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class acxz
  extends acxy
{
  private CopyOnWriteArrayList<FTSEntity> R = new CopyOnWriteArrayList();
  long Ry = 0L;
  long Rz = 0L;
  private akvm a;
  private int cAu;
  private int cAv;
  private HashMap<String, FTSMsgCounter> jo = new HashMap(20);
  
  public acxz(QQAppInterface paramQQAppInterface, acyc paramacyc)
  {
    super(paramQQAppInterface, paramacyc);
  }
  
  private akvm a()
  {
    if ((this.jdField_a_of_type_Akvm == null) || (!this.jdField_a_of_type_Akvm.isOpen())) {
      this.jdField_a_of_type_Akvm = ((akvm)this.mApp.a().createMessageRecordEntityManager());
    }
    return this.jdField_a_of_type_Akvm;
  }
  
  private void a(FTSMessage paramFTSMessage, int paramInt)
  {
    try
    {
      Object localObject1 = (acff)this.mApp.getManager(51);
      Object localObject2 = MessageRecord.getTableName(paramFTSMessage.senderuin, paramFTSMessage.msgtype);
      if ((paramFTSMessage.istroop == 0) && (!((acff)localObject1).isFriend(paramFTSMessage.senderuin)) && (!this.mApp.getCurrentAccountUin().equals(paramFTSMessage.senderuin)) && (!aqir.a((String)localObject2, this.mApp.getReadableDatabase())))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("selfuin", this.mApp.getCurrentAccountUin());
        ((HashMap)localObject1).put("senderuin", paramFTSMessage.senderuin);
        ((HashMap)localObject1).put("frienduin", String.valueOf(paramFTSMessage.uin));
        ((HashMap)localObject1).put("type", String.valueOf(paramInt));
        if ((paramFTSMessage.msgExts instanceof FTSMessageCodec.MsgExts))
        {
          localObject2 = (FTSMessageCodec.TextMsgExts)paramFTSMessage.msgExts;
          ((HashMap)localObject1).put("time", String.valueOf(((FTSMessageCodec.TextMsgExts)localObject2).time));
          ((HashMap)localObject1).put("seq", String.valueOf(((FTSMessageCodec.TextMsgExts)localObject2).shmsgseq));
        }
        QLog.d("Q.fts.FTSMsgOperator", 1, new Object[] { "reportStrangerInsert ", Long.valueOf(paramFTSMessage.uin), " senderuin:", paramFTSMessage.senderuin });
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "actStrangerFtsMsg", true, 0L, 0L, (HashMap)localObject1, "");
      }
      return;
    }
    catch (Throwable paramFTSMessage)
    {
      QLog.d("Q.fts.FTSMsgOperator", 1, paramFTSMessage, new Object[0]);
    }
  }
  
  private boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.hasInit())) {
      localArrayList = new ArrayList(50);
    }
    for (;;)
    {
      Object localObject3;
      int i;
      int j;
      synchronized (this.R)
      {
        if (this.R.isEmpty()) {
          break label675;
        }
        localObject3 = this.R.iterator();
        i = 0;
        Object localObject4;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FTSEntity)((Iterator)localObject3).next();
          ((FTSEntity)localObject4).preWrite();
          try
          {
            localArrayList.add(localObject4);
            i += ((FTSEntity)localObject4).mSegmentCount;
          }
          catch (Throwable localThrowable)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.fts.FTSMsgOperator", 2, "internalTransToDatabase failure: ", localThrowable);
            }
            return false;
          }
        }
        this.R.clear();
        if (!localThrowable.isEmpty())
        {
          j = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(localThrowable, paramInt1, paramInt2);
          if (j == -1) {
            break label531;
          }
          if (paramInt1 != 2) {
            break label522;
          }
          this.cAs = j;
          paramLong = System.currentTimeMillis() - paramLong;
          this.cAt += localThrowable.size();
          this.Rx += paramLong;
          if ((QLog.isColorLevel()) || (paramLong > 60000L))
          {
            long l = this.cAu;
            if (this.cAu == 0) {
              break label601;
            }
            localObject3 = new StringBuilder(50);
            localObject4 = ((StringBuilder)localObject3).append(getClass().getSimpleName());
            if (paramInt1 != 2) {
              break label618;
            }
            ??? = " Delete";
            ((StringBuilder)localObject4).append((String)???).append(" count:").append(localThrowable.size()).append(" cost:").append(paramLong).append(" indexCnt:").append(this.cAu).append(" preIndexCnt:").append(l).append(" segmentTotal:").append(i);
            if (paramInt1 == 1) {
              ((StringBuilder)localObject3).append(" assistTroopCount:").append(this.cAv);
            }
            l = fd();
            if ((paramLong <= 30000L) || (System.currentTimeMillis() - l <= 86400000L)) {
              break label642;
            }
            QLog.e("Q.fts.BgCpu", 1, ((StringBuilder)localObject3).toString());
            localObject3 = new HashMap();
            if (paramInt1 != 2) {
              break label626;
            }
            ??? = " Delete";
            ((HashMap)localObject3).put("param_type", ???);
            ((HashMap)localObject3).put("param_count", String.valueOf(localThrowable.size()));
            ((HashMap)localObject3).put("param_stotal", String.valueOf(i));
            if (paramInt1 != 1) {
              break label634;
            }
            ??? = String.valueOf(this.cAv);
            ((HashMap)localObject3).put("param_assist_cnt", ???);
            anpc.a(BaseApplication.getContext()).collectPerformance(null, "actFTSMsgCost", true, paramLong, 0L, (HashMap)localObject3, null, false);
            in(System.currentTimeMillis());
          }
        }
        return true;
      }
      label522:
      this.cAr = j;
      continue;
      label531:
      if (paramInt1 == 2) {
        this.cAs += paramInt2;
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label599;
        }
        QLog.d("Q.fts.FTSMsgOperator", 2, String.format("write fts failed mode=%d, cursorStep=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        break;
        this.cAr += paramInt2;
      }
      label599:
      continue;
      label601:
      this.cAu = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.dF("IndexContent");
      continue;
      label618:
      ??? = " Insert";
      continue;
      label626:
      ??? = " Insert";
      continue;
      label634:
      ??? = "0";
      continue;
      label642:
      QLog.d("Q.fts.BgCpu", 1, ((StringBuilder)localObject3).toString());
      continue;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.fts.FTSMsgOperator", 2, "internalTransToDatabase ftsDatabase not init");
        continue;
        label675:
        i = 0;
      }
    }
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    long l = System.currentTimeMillis();
    paramSQLiteDatabase.delete("msg_sync_log", "_id<=?", new String[] { String.valueOf(this.cAr) });
    Object localObject = this.mApp.a().createEntityManager();
    paramSQLiteDatabase = ((EntityManager)localObject).query(FTSMessageSync.class, "msg_sync_log", false, "_id>?", new String[] { String.valueOf(this.cAr) }, null, null, "_id", String.valueOf(300));
    ((EntityManager)localObject).close();
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("transToDBForInsert size: ");
      if (paramSQLiteDatabase != null)
      {
        i = paramSQLiteDatabase.size();
        QLog.i("Q.fts.FTSMsgOperator", 2, i);
      }
    }
    else
    {
      this.cAv = 0;
      if ((paramSQLiteDatabase == null) || (paramSQLiteDatabase.isEmpty())) {
        break label309;
      }
      i = 0;
      label154:
      if (i >= paramSQLiteDatabase.size()) {
        break label311;
      }
      localObject = FTSMessageCodec.a((FTSMessageSync)paramSQLiteDatabase.get(i));
      if ((((FTSMessage)localObject).mType != -1) && ((((FTSMessage)localObject).mOpt == 16) || (!TextUtils.isEmpty(((FTSMessage)localObject).mContent))) && (((FTSMessage)localObject).mOId != -1L)) {
        break label233;
      }
    }
    for (;;)
    {
      i += 1;
      break label154;
      i = 0;
      break;
      label233:
      ((FTSMessage)localObject).msgCounter = ae(String.valueOf(((FTSMessage)localObject).uin));
      try
      {
        this.R.add(localObject);
        if (this.mApp.cs(String.valueOf(((FTSMessage)localObject).uin)) == 2) {
          this.cAv += 1;
        }
      }
      catch (Throwable paramSQLiteDatabase)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.FTSMsgOperator", 2, "transToDBForInsert failure: ", paramSQLiteDatabase);
        }
      }
    }
    label309:
    return false;
    label311:
    return a(l, 1, paramSQLiteDatabase.size());
  }
  
  private ArrayList<FTSEntity> ad(ArrayList<FTSEntity> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    do
    {
      for (;;)
      {
        FTSEntity localFTSEntity;
        Object localObject3;
        String str;
        try
        {
          localObject1 = new HashSet(10);
          localObject2 = new HashSet(10);
          if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
            break;
          }
          acff localacff = (acff)this.mApp.getManager(51);
          Iterator localIterator = paramArrayList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localFTSEntity = (FTSEntity)localIterator.next();
          localObject3 = (FTSMessage)localFTSEntity;
          if ((localObject3 == null) || (((FTSMessage)localObject3).msgExts == null)) {
            continue;
          }
          i = ((FTSMessage)localObject3).istroop;
          localObject3 = String.valueOf(((FTSMessage)localObject3).uin);
          str = (String)localObject3 + "zZz" + i;
          if (localacff.isFriend((String)localObject3))
          {
            localArrayList.add(localFTSEntity);
            continue;
          }
          if (((HashSet)localObject1).contains(str)) {
            continue;
          }
        }
        catch (Throwable paramArrayList)
        {
          QLog.d("Q.fts.FTSMsgOperator", 1, paramArrayList, new Object[0]);
          return localArrayList;
        }
        if (((HashSet)localObject2).contains(str))
        {
          localArrayList.add(localFTSEntity);
        }
        else if (aqir.a(MessageRecord.getTableName((String)localObject3, i), this.mApp.getReadableDatabase()))
        {
          localArrayList.add(localFTSEntity);
          ((HashSet)localObject2).add(str);
        }
        else
        {
          ((HashSet)localObject1).add(str);
        }
      }
      localObject2 = new StringBuilder();
      Object localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append((String)((Iterator)localObject1).next()).append(" ");
      }
    } while (!QLog.isColorLevel());
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      QLog.d("Q.fts.FTSMsgOperator", 2, new Object[] { "filterEnityByCheckRelation before:", Integer.valueOf(i), " filtered:", Integer.valueOf(localArrayList.size()), "\nfilterUin:", ((StringBuilder)localObject2).toString() });
      return localArrayList;
    }
  }
  
  private boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool2 = false;
    int j = 0;
    long l = System.currentTimeMillis();
    paramSQLiteDatabase.delete("msg_del_log", "_id<=?", new String[] { String.valueOf(this.cAs) });
    Object localObject1 = this.mApp.a().createEntityManager();
    paramSQLiteDatabase = ((EntityManager)localObject1).query(FTSMessageDelete.class, "msg_del_log", false, "_id>?", new String[] { String.valueOf(this.cAs) }, null, null, "_id", String.valueOf(50));
    ((EntityManager)localObject1).close();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("transToDBForDelete size: ");
      if (paramSQLiteDatabase == null) {
        break label248;
      }
    }
    Object localObject2;
    label248:
    for (int i = paramSQLiteDatabase.size();; i = 0)
    {
      QLog.i("Q.fts.FTSMsgOperator", 2, i);
      bool1 = bool2;
      if (paramSQLiteDatabase == null) {
        break label651;
      }
      bool1 = bool2;
      if (paramSQLiteDatabase.isEmpty()) {
        break label651;
      }
      localObject1 = new ArrayList(paramSQLiteDatabase.size());
      i = 0;
      for (;;)
      {
        if (i >= paramSQLiteDatabase.size()) {
          break label280;
        }
        localObject2 = (FTSMessageDelete)paramSQLiteDatabase.get(i);
        if ((((FTSMessageDelete)localObject2).mType != -1) && ((((FTSMessageDelete)localObject2).mOpt == 16) || (!TextUtils.isEmpty(((FTSMessageDelete)localObject2).mContent))) && (((FTSMessageDelete)localObject2).mOId != -1L)) {
          break;
        }
        i += 1;
      }
    }
    label280:
    label301:
    Object localObject3;
    String str;
    if (((FTSMessageDelete)localObject2).mode == 2) {
      if ((!this.R.isEmpty()) || (!((ArrayList)localObject1).isEmpty()))
      {
        if (((ArrayList)localObject1).size() <= 0) {
          break label636;
        }
        localObject2 = new HashMap(10);
        i = j;
        if (i >= ((ArrayList)localObject1).size()) {
          break label584;
        }
        localObject3 = FTSMessageCodec.a((FTSMessageSync)((ArrayList)localObject1).get(i));
        str = FTSMessage.getExt1(((FTSMessage)localObject3).uin, ((FTSMessage)localObject3).istroop);
        if (!((HashMap)localObject2).containsKey(str)) {
          break label505;
        }
        ((FTSMessageForDel)((HashMap)localObject2).get(str)).appendOId((FTSMessageDelete)((ArrayList)localObject1).get(i));
      }
    }
    for (;;)
    {
      i += 1;
      break label301;
      localObject3 = FTSMessageCodec.a((FTSMessageSync)localObject2);
      ((FTSMessageForDel)localObject3).mode = ((FTSMessageDelete)localObject2).mode;
      ((FTSMessageForDel)localObject3).msgCounter = ((FTSMessageDelete)localObject2).delCounter;
      this.R.add(localObject3);
      break label280;
      if (((FTSMessageDelete)localObject2).mode == 4)
      {
        localObject3 = FTSMessageCodec.a((FTSMessageSync)localObject2);
        ((FTSMessageForDel)localObject3).mode = ((FTSMessageDelete)localObject2).mode;
        ((FTSMessageForDel)localObject3).deleteOpt();
        this.R.add(localObject3);
        break;
      }
      if (((FTSMessageDelete)localObject2).mOId == -9223372036854775808L)
      {
        localObject2 = FTSMessageCodec.a((FTSMessageSync)localObject2);
        this.R.add(localObject2);
        break;
      }
      ((ArrayList)localObject1).add(localObject2);
      break;
      label505:
      FTSMessageForDel localFTSMessageForDel = new FTSMessageForDel();
      localFTSMessageForDel.mOpt = ((FTSMessage)localObject3).mOpt;
      localFTSMessageForDel.mType = ((FTSMessage)localObject3).mType;
      localFTSMessageForDel.msgtype = ((FTSMessage)localObject3).msgtype;
      localFTSMessageForDel.mExt1Key = str;
      localFTSMessageForDel.mode = 1;
      localFTSMessageForDel.appendOId((FTSMessageDelete)((ArrayList)localObject1).get(i));
      ((HashMap)localObject2).put(str, localFTSMessageForDel);
    }
    label584:
    localObject1 = ((HashMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      this.R.add(((Map.Entry)localObject2).getValue());
    }
    label636:
    boolean bool1 = a(l, 2, paramSQLiteDatabase.size());
    label651:
    return bool1;
  }
  
  private long fd()
  {
    return BaseApplication.getContext().getSharedPreferences("fts_sp_file", 0).getLong("key_last_msg_time", 0L);
  }
  
  private void in(long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("fts_sp_file", 0).edit().putLong("key_last_msg_time", paramLong).commit();
  }
  
  public int Bl()
  {
    int i = 0;
    this.mApp.getWritableDatabase();
    List localList = this.mApp.a().createEntityManager().query(FTSMessageSync.class, "msg_sync_log", false, "_id>?", new String[] { String.valueOf(this.cAr) }, null, null, null, null);
    if (localList != null) {
      i = localList.size();
    }
    return i;
  }
  
  public ArrayList<FTSEntity> a(long paramLong, Pair<CharSequence, CharSequence> paramPair)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.hasInit()))
    {
      localObject = acxx.a(FTSMessage.class, String.valueOf(paramLong));
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a((akwf)localObject);
      if ((paramPair != null) && (localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          FTSEntity localFTSEntity = (FTSEntity)localIterator.next();
          if ((localFTSEntity instanceof FTSMessage))
          {
            ((FTSMessage)localFTSEntity).matchTitle = ((CharSequence)paramPair.first);
            ((FTSMessage)localFTSEntity).matchSecondTitle = ((CharSequence)paramPair.second);
          }
        }
      }
      if (amxh.awm()) {
        return ad((ArrayList)localObject);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
      }
      return null;
    }
    return localObject;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.hasInit()))
    {
      localObject1 = localObject2;
      if (paramString != null)
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label42;
        }
        localObject1 = localObject2;
      }
    }
    label42:
    do
    {
      do
      {
        long l1;
        String str;
        do
        {
          do
          {
            return localObject1;
            l1 = System.nanoTime();
            str = paramString.trim().toLowerCase();
            paramString = aqoe.z(str);
            if (QLog.isColorLevel()) {
              QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString));
            }
            localObject1 = localObject2;
          } while (paramString == null);
          localObject1 = localObject2;
        } while (paramString.length == 0);
        long l2 = System.nanoTime();
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.FTSMsgOperator", 2, "query: segments cost = " + (l2 - l1) / 1000000L + "ms");
        }
        localObject1 = aqoe.K(str);
        paramString = acxx.a(paramString, (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]), paramClass, paramBoolean1, paramBoolean2);
        paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(paramString);
        localObject1 = paramString;
      } while (!amxh.awm());
      return ad(paramString);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.hasInit()))
    {
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        paramString = null;
      }
      do
      {
        return paramString;
        long l1 = System.nanoTime();
        Object localObject = paramString.trim().toLowerCase();
        paramString = aqoe.z((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString));
        }
        if ((paramString == null) || (paramString.length == 0)) {
          return null;
        }
        long l2 = System.nanoTime();
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.FTSMsgOperator", 2, "query: segments cost = " + (l2 - l1) / 1000000L + "ms");
        }
        localObject = aqoe.K((String)localObject);
        paramString = acxx.a(paramString, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2, paramInt);
        paramClass = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(paramString);
        paramString = paramClass;
      } while (!amxh.awm());
      return ad(paramClass);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString1, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.hasInit()))
    {
      if ((paramString1 == null) || (TextUtils.isEmpty(paramString1))) {
        paramString1 = null;
      }
      do
      {
        return paramString1;
        Object localObject = paramString1.trim().toLowerCase();
        paramString1 = aqoe.z((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString1));
        }
        if ((paramString1 == null) || (paramString1.length == 0)) {
          return null;
        }
        localObject = aqoe.K((String)localObject);
        paramString1 = acxx.a(paramString1, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2, paramInt, paramString2);
        paramClass = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(paramString1);
        paramString1 = paramClass;
      } while (!amxh.awm());
      return ad(paramClass);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt)
  {
    return a(paramString, paramClass, paramBoolean1, paramBoolean2, 1, FTSMessage.getExt1(paramLong, paramInt));
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, long paramLong, Pair<CharSequence, CharSequence> paramPair)
  {
    paramString = a(paramString, paramClass, paramBoolean1, paramBoolean2, 2, String.valueOf(paramLong));
    if ((paramPair != null) && (paramString != null) && (!paramString.isEmpty()))
    {
      paramClass = paramString.iterator();
      while (paramClass.hasNext())
      {
        FTSEntity localFTSEntity = (FTSEntity)paramClass.next();
        if ((localFTSEntity instanceof FTSMessage))
        {
          ((FTSMessage)localFTSEntity).matchTitle = ((CharSequence)paramPair.first);
          ((FTSMessage)localFTSEntity).matchSecondTitle = ((CharSequence)paramPair.second);
        }
      }
    }
    if (amxh.awm()) {
      return ad(paramString);
    }
    return paramString;
  }
  
  public void a(MsgQueueItem paramMsgQueueItem, EntityManager paramEntityManager)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMsgQueueItem.whereClause != null) && (!TextUtils.isEmpty(paramMsgQueueItem.whereClause)))
    {
      if (paramMsgQueueItem.value == null) {
        return;
      }
      localObject1 = "SELECT * FROM " + paramMsgQueueItem.tableName + " WHERE " + paramMsgQueueItem.whereClause + ";";
      localObject2 = new String[paramMsgQueueItem.whereArgs.length];
      int i = 0;
      while (i < paramMsgQueueItem.whereArgs.length)
      {
        localObject2[i] = paramMsgQueueItem.whereArgs[i];
        i += 1;
      }
      localObject1 = a().a((String)localObject1, paramMsgQueueItem.tableName, paramMsgQueueItem.whereClause, (String[])localObject2, this.mApp);
      if ((localObject1 != null) && (aqoe.a(paramMsgQueueItem.value))) {
        paramMsgQueueItem = ((List)localObject1).iterator();
      }
    }
    while (paramMsgQueueItem.hasNext())
    {
      localObject1 = (MessageRecord)paramMsgQueueItem.next();
      if ((((MessageRecord)localObject1).isSupportFTS()) && (((MessageRecord)localObject1).isValid) && (((MessageRecord)localObject1).msgtype != -2006) && (!((MessageRecord)localObject1).isMultiMsg))
      {
        localObject1 = FTSMessageCodec.b((MessageRecord)localObject1);
        ((FTSMessage)localObject1).deleteOpt();
        paramEntityManager.persistOrReplace(FTSMessageCodec.a((FTSMessage)localObject1));
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgOperator", 2, "updateMessageSync 1 msg:" + ((FTSMessage)localObject1).toString());
        }
        a((FTSMessage)localObject1, 2);
        continue;
        if ((localObject1 != null) && (aqoe.b(paramMsgQueueItem.value)))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (MessageRecord)((Iterator)localObject1).next();
            if ((((MessageRecord)localObject3).isSupportFTS()) && (((MessageRecord)localObject3).isValid) && (((MessageRecord)localObject3).msgtype != -2006) && (!((MessageRecord)localObject3).isMultiMsg))
            {
              if ((localObject3 instanceof MessageForStructing)) {
                ((MessageForStructing)localObject3).parse();
              }
              localObject2 = FTSMessageCodec.b((MessageRecord)localObject3);
              ((FTSMessage)localObject2).deleteOpt();
              paramEntityManager.persistOrReplace(FTSMessageCodec.a((FTSMessage)localObject2));
              localObject3 = aqoe.a(paramMsgQueueItem.value, (MessageRecord)localObject3);
              ((FTSMessage)localObject3).insertOpt();
              paramEntityManager.persistOrReplace(FTSMessageCodec.a((FTSMessage)localObject3));
              if (QLog.isColorLevel()) {
                QLog.d("Q.fts.FTSMsgOperator", 2, "updateMessageSync 2 msg:" + ((FTSMessage)localObject2).toString());
              }
              a((FTSMessage)localObject2, 3);
              continue;
              if (QLog.isColorLevel()) {
                QLog.w("Q.fts.FTSMsgOperator", 2, "UPDATE MESSAGE, whereClause null");
              }
            }
          }
        }
      }
    }
  }
  
  public void a(Entity paramEntity, EntityManager paramEntityManager)
  {
    if (((paramEntity instanceof MessageRecord)) && (((MessageRecord)paramEntity).isSupportFTS()) && (((MessageRecord)paramEntity).isValid) && (((MessageRecord)paramEntity).msgtype != -2006) && (!((MessageRecord)paramEntity).isMultiMsg))
    {
      paramEntity = FTSMessageCodec.b((MessageRecord)paramEntity);
      paramEntity.insertOpt();
      paramEntityManager.persistOrReplace(FTSMessageCodec.a(paramEntity));
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgOperator", 2, "insertMessageSync msg:" + paramEntity.toString());
      }
      a(paramEntity, 1);
    }
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    super.a(paramFTSDatatbase, paramFTSDatabase);
    this.jdField_a_of_type_Acyf = new acya(this.mApp, this);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.G("IndexContent", true);
  }
  
  public boolean acX()
  {
    if (!this.bKl)
    {
      boolean bool2;
      try
      {
        boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.nP("SyncCursor");
        bool2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.nP("DeleteCursor");
        if (!bool1) {
          if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.nO("SyncCursor")) {
            return false;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.FTSMsgOperator", 2, "mWokerThread: failure ", localThrowable1);
        }
        acxu.ENABLE = false;
        return false;
      }
      for (int i = 0;; i = -1)
      {
        if (!bool2) {
          if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.nO("DeleteCursor")) {
            break;
          }
        }
        for (int j = 0;; j = -1)
        {
          int k = i;
          if (i != 1) {
            k = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.dE("SyncCursor");
          }
          this.cAr = k;
          if (k == -1) {
            break;
          }
          i = j;
          if (j != 1) {
            i = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.dE("DeleteCursor");
          }
          this.cAs = i;
          if (i == -1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.FTSMsgOperator", 2, "startSyncStep: syncCursor = " + k + " delCursor = " + i);
          }
          this.bKl = true;
          EntityManager localEntityManager = this.mApp.a().createEntityManager();
          Object localObject = localEntityManager.query(FTSMsgCounter.class, false, null, null, null, null, null, null);
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              FTSMsgCounter localFTSMsgCounter = (FTSMsgCounter)((Iterator)localObject).next();
              this.jo.put(localFTSMsgCounter.mMsgUin, localFTSMsgCounter);
            }
          }
          localEntityManager.close();
          try
          {
            if (this.cAu != 0) {
              break label343;
            }
            this.cAu = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.dF("IndexContent");
          }
          catch (Throwable localThrowable2)
          {
            QLog.e("Q.fts.FTSMsgOperator", 1, localThrowable2, new Object[0]);
          }
        }
      }
    }
    label343:
    return true;
  }
  
  protected boolean acY()
  {
    return true;
  }
  
  public boolean acZ()
  {
    return false;
  }
  
  public long ae(String paramString)
  {
    long l1;
    if (this.jo.containsKey(paramString))
    {
      long l2 = ((FTSMsgCounter)this.jo.get(paramString)).mCounter;
      l1 = l2;
      if (System.currentTimeMillis() - this.Ry > 30000L)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounterForInsert uin:" + paramString + " ret:" + l2);
          this.Ry = System.currentTimeMillis();
          l1 = l2;
        }
      }
    }
    do
    {
      return l1;
      l1 = 0L;
    } while (!QLog.isColorLevel());
    QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounterForInsert uin:" + paramString + " not exist? why?");
    return 0L;
  }
  
  public long af(String paramString)
  {
    if (this.jo.containsKey(paramString))
    {
      localObject = (FTSMsgCounter)this.jo.get(paramString);
      ((FTSMsgCounter)localObject).mMsgCnt += 1L;
      if (((FTSMsgCounter)localObject).mMsgCnt > 1000L)
      {
        ((FTSMsgCounter)localObject).mCounter += 1L;
        ((FTSMsgCounter)localObject).mMsgCnt = 0L;
        this.jdField_a_of_type_Akvm.update((Entity)localObject);
      }
      for (;;)
      {
        long l = ((FTSMsgCounter)localObject).mCounter;
        if ((System.currentTimeMillis() - this.Rz > 30000L) && (QLog.isColorLevel()))
        {
          QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounter uin:" + paramString + " counter:" + ((FTSMsgCounter)localObject).mCounter + " msgCnt:" + ((FTSMsgCounter)localObject).mMsgCnt);
          this.Rz = System.currentTimeMillis();
        }
        return l;
        if (((FTSMsgCounter)localObject).mMsgCnt % 300L == 0L)
        {
          this.jdField_a_of_type_Akvm.update((Entity)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounter update curCounter msgCnt:" + ((FTSMsgCounter)localObject).mMsgCnt);
          }
        }
      }
    }
    Object localObject = this.mApp.a().createEntityManager();
    FTSMsgCounter localFTSMsgCounter = new FTSMsgCounter();
    localFTSMsgCounter.mMsgUin = paramString;
    localFTSMsgCounter.mCounter = 0L;
    localFTSMsgCounter.mMsgCnt = 1L;
    this.jo.put(paramString, localFTSMsgCounter);
    ((EntityManager)localObject).persistOrReplace(localFTSMsgCounter);
    ((EntityManager)localObject).close();
    if ((System.currentTimeMillis() - this.Rz > 30000L) && (QLog.isColorLevel()))
    {
      QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounter uin:" + paramString + " counter:" + localFTSMsgCounter.mCounter + " msgCnt:" + localFTSMsgCounter.mMsgCnt);
      this.Rz = System.currentTimeMillis();
    }
    return 0L;
  }
  
  public void b(MsgQueueItem paramMsgQueueItem, EntityManager paramEntityManager)
  {
    Object localObject;
    if ((paramMsgQueueItem.whereClause != null) && (!TextUtils.isEmpty(paramMsgQueueItem.whereClause)))
    {
      localObject = "SELECT * FROM " + paramMsgQueueItem.tableName + " WHERE " + paramMsgQueueItem.whereClause + ";";
      String[] arrayOfString = new String[paramMsgQueueItem.whereArgs.length];
      int i = 0;
      while (i < paramMsgQueueItem.whereArgs.length)
      {
        arrayOfString[i] = paramMsgQueueItem.whereArgs[i];
        i += 1;
      }
      try
      {
        paramMsgQueueItem = a().a((String)localObject, paramMsgQueueItem.tableName, paramMsgQueueItem.whereClause, arrayOfString, this.mApp);
        if (paramMsgQueueItem == null) {
          break label288;
        }
        paramMsgQueueItem = paramMsgQueueItem.iterator();
        while (paramMsgQueueItem.hasNext())
        {
          localObject = (MessageRecord)paramMsgQueueItem.next();
          if ((((MessageRecord)localObject).isSupportFTS()) && (((MessageRecord)localObject).isValid) && (((MessageRecord)localObject).msgtype != -2006))
          {
            localObject = FTSMessageCodec.b((MessageRecord)localObject);
            ((FTSMessage)localObject).deleteOpt();
            paramEntityManager.persistOrReplace(FTSMessageCodec.a((FTSMessage)localObject));
          }
        }
      }
      catch (OutOfMemoryError paramMsgQueueItem)
      {
        for (;;)
        {
          QLog.e("Q.fts.FTSMsgOperator", 2, paramMsgQueueItem, new Object[0]);
          paramMsgQueueItem = null;
        }
      }
    }
    else
    {
      localObject = new FTSMessage();
      ((FTSMessage)localObject).mType = 1;
      ((FTSMessage)localObject).mContent = "DELETE TABLE";
      ((FTSMessage)localObject).mOId = -9223372036854775808L;
    }
    try
    {
      ((FTSMessage)localObject).uin = jji.B(paramMsgQueueItem.frindUin);
      ((FTSMessage)localObject).istroop = paramMsgQueueItem.type;
      ((FTSMessage)localObject).deleteOpt();
      paramEntityManager.persistOrReplace(FTSMessageCodec.a((FTSMessage)localObject));
      label288:
      return;
    }
    catch (NumberFormatException paramMsgQueueItem) {}
  }
  
  public void c(Entity paramEntity)
  {
    if (((paramEntity instanceof MessageRecord)) && (((MessageRecord)paramEntity).isSupportFTS()))
    {
      paramEntity = (MessageRecord)paramEntity;
      paramEntity.saveExtInfoToExtStr("ExtraFTSMsgCounter", String.valueOf(af(paramEntity.frienduin)));
    }
  }
  
  public void cOP()
  {
    if (aqoe.ak(this.mApp) == 1)
    {
      if (!acV()) {
        break label30;
      }
      if (acW()) {
        cOQ();
      }
    }
    return;
    label30:
    cOQ();
  }
  
  public void cOQ()
  {
    super.cOQ();
    if (1 == aqoe.ak(this.mApp)) {
      this.jdField_a_of_type_Acyc.obtainMessage(1, this).sendToTarget();
    }
  }
  
  public void cOS()
  {
    if ((!acxu.ENABLE) && (aqoe.cj(this.mApp))) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMsgOperator", 2, "transToDatabase ENABLE = " + acxu.ENABLE + ", FTSUpgradeFlag = " + aqoe.cj(this.mApp));
      }
    }
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = this.mApp.getWritableDatabase();
    } while (a(localSQLiteDatabase));
    b(localSQLiteDatabase);
  }
  
  /* Error */
  public void cOT()
  {
    // Byte code:
    //   0: getstatic 787	acxu:ENABLE	Z
    //   3: ifne +64 -> 67
    //   6: aload_0
    //   7: getfield 54	acxz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: invokestatic 901	aqoe:cj	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   13: ifeq +54 -> 67
    //   16: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +47 -> 66
    //   22: ldc 156
    //   24: iconst_2
    //   25: new 275	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 903
    //   35: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: getstatic 787	acxu:ENABLE	Z
    //   41: invokevirtual 906	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: ldc_w 908
    //   47: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 54	acxz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: invokestatic 901	aqoe:cj	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   57: invokevirtual 906	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: return
    //   67: aload_0
    //   68: getfield 54	acxz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   71: invokevirtual 574	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   74: astore 9
    //   76: aload_0
    //   77: getfield 54	acxz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   80: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   83: invokevirtual 388	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   86: astore 7
    //   88: invokestatic 259	java/lang/System:currentTimeMillis	()J
    //   91: lstore_3
    //   92: aload 9
    //   94: ldc_w 377
    //   97: ldc_w 379
    //   100: iconst_1
    //   101: anewarray 102	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: getfield 349	acxz:cAr	I
    //   110: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   113: aastore
    //   114: invokevirtual 385	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: pop
    //   118: aload 7
    //   120: ldc_w 390
    //   123: ldc_w 377
    //   126: iconst_0
    //   127: ldc_w 392
    //   130: iconst_1
    //   131: anewarray 102	java/lang/String
    //   134: dup
    //   135: iconst_0
    //   136: aload_0
    //   137: getfield 349	acxz:cAr	I
    //   140: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   143: aastore
    //   144: aconst_null
    //   145: aconst_null
    //   146: ldc_w 394
    //   149: aconst_null
    //   150: invokevirtual 400	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   153: astore 8
    //   155: aload 9
    //   157: ldc_w 483
    //   160: ldc_w 379
    //   163: iconst_1
    //   164: anewarray 102	java/lang/String
    //   167: dup
    //   168: iconst_0
    //   169: aload_0
    //   170: getfield 253	acxz:cAs	I
    //   173: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   176: aastore
    //   177: invokevirtual 385	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   180: pop
    //   181: aload 7
    //   183: ldc_w 485
    //   186: ldc_w 483
    //   189: iconst_0
    //   190: ldc_w 392
    //   193: iconst_1
    //   194: anewarray 102	java/lang/String
    //   197: dup
    //   198: iconst_0
    //   199: aload_0
    //   200: getfield 253	acxz:cAs	I
    //   203: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   206: aastore
    //   207: aconst_null
    //   208: aconst_null
    //   209: ldc_w 394
    //   212: aconst_null
    //   213: invokevirtual 400	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   216: astore 9
    //   218: new 507	com/tencent/mobileqq/data/fts/FTSMessageForDel
    //   221: dup
    //   222: invokespecial 525	com/tencent/mobileqq/data/fts/FTSMessageForDel:<init>	()V
    //   225: astore 10
    //   227: aload 10
    //   229: iconst_4
    //   230: putfield 515	com/tencent/mobileqq/data/fts/FTSMessageForDel:mode	I
    //   233: aload 10
    //   235: invokevirtual 522	com/tencent/mobileqq/data/fts/FTSMessageForDel:deleteOpt	()V
    //   238: aload_0
    //   239: getfield 199	acxz:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   242: ifnull +271 -> 513
    //   245: aload_0
    //   246: getfield 199	acxz:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   249: invokevirtual 204	com/tencent/mobileqq/persistence/fts/FTSDatatbase:hasInit	()Z
    //   252: ifeq +261 -> 513
    //   255: new 206	java/util/ArrayList
    //   258: dup
    //   259: bipush 10
    //   261: invokespecial 207	java/util/ArrayList:<init>	(I)V
    //   264: astore 11
    //   266: aload 11
    //   268: aload 10
    //   270: invokevirtual 231	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   273: pop
    //   274: aload 8
    //   276: ifnull +243 -> 519
    //   279: aload 8
    //   281: invokeinterface 409 1 0
    //   286: istore_1
    //   287: aload_0
    //   288: getfield 199	acxz:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   291: aload 11
    //   293: iconst_1
    //   294: iload_1
    //   295: invokevirtual 250	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;II)I
    //   298: istore_2
    //   299: aload_0
    //   300: aload_0
    //   301: getfield 349	acxz:cAr	I
    //   304: iload_1
    //   305: iadd
    //   306: putfield 349	acxz:cAr	I
    //   309: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +39 -> 351
    //   315: ldc 156
    //   317: iconst_2
    //   318: iconst_4
    //   319: anewarray 158	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: ldc_w 917
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: iload_1
    //   331: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: aastore
    //   335: dup
    //   336: iconst_2
    //   337: ldc_w 919
    //   340: aastore
    //   341: dup
    //   342: iconst_3
    //   343: iload_2
    //   344: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: aastore
    //   348: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   351: aload 9
    //   353: ifnull +171 -> 524
    //   356: aload 9
    //   358: invokeinterface 409 1 0
    //   363: istore_1
    //   364: aload_0
    //   365: getfield 199	acxz:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   368: aload 11
    //   370: iconst_2
    //   371: iload_1
    //   372: invokevirtual 250	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;II)I
    //   375: istore_2
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 253	acxz:cAs	I
    //   381: iload_1
    //   382: iadd
    //   383: putfield 253	acxz:cAs	I
    //   386: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq +39 -> 428
    //   392: ldc 156
    //   394: iconst_2
    //   395: iconst_4
    //   396: anewarray 158	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: ldc_w 921
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: iload_1
    //   408: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: aastore
    //   412: dup
    //   413: iconst_2
    //   414: ldc_w 919
    //   417: aastore
    //   418: dup
    //   419: iconst_3
    //   420: iload_2
    //   421: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   424: aastore
    //   425: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   428: aload_0
    //   429: getfield 273	acxz:cAu	I
    //   432: i2l
    //   433: lstore 5
    //   435: aload_0
    //   436: aload_0
    //   437: getfield 199	acxz:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   440: ldc_w 364
    //   443: invokevirtual 368	com/tencent/mobileqq/persistence/fts/FTSDatatbase:dF	(Ljava/lang/String;)I
    //   446: putfield 273	acxz:cAu	I
    //   449: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq +61 -> 513
    //   455: ldc 156
    //   457: iconst_2
    //   458: bipush 6
    //   460: anewarray 158	java/lang/Object
    //   463: dup
    //   464: iconst_0
    //   465: ldc_w 923
    //   468: aastore
    //   469: dup
    //   470: iconst_1
    //   471: invokestatic 259	java/lang/System:currentTimeMillis	()J
    //   474: lload_3
    //   475: lsub
    //   476: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   479: aastore
    //   480: dup
    //   481: iconst_2
    //   482: ldc_w 303
    //   485: aastore
    //   486: dup
    //   487: iconst_3
    //   488: aload_0
    //   489: getfield 273	acxz:cAu	I
    //   492: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   495: aastore
    //   496: dup
    //   497: iconst_4
    //   498: ldc_w 305
    //   501: aastore
    //   502: dup
    //   503: iconst_5
    //   504: lload 5
    //   506: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: aastore
    //   510: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   513: aload 7
    //   515: invokevirtual 403	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   518: return
    //   519: iconst_0
    //   520: istore_1
    //   521: goto -234 -> 287
    //   524: iconst_0
    //   525: istore_1
    //   526: goto -162 -> 364
    //   529: astore 8
    //   531: ldc 156
    //   533: iconst_1
    //   534: iconst_2
    //   535: anewarray 158	java/lang/Object
    //   538: dup
    //   539: iconst_0
    //   540: ldc_w 925
    //   543: aastore
    //   544: dup
    //   545: iconst_1
    //   546: aload 8
    //   548: invokevirtual 926	java/lang/Exception:toString	()Ljava/lang/String;
    //   551: aastore
    //   552: invokestatic 928	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   555: aload 7
    //   557: invokevirtual 403	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   560: return
    //   561: astore 8
    //   563: aload 7
    //   565: invokevirtual 403	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   568: aload 8
    //   570: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	this	acxz
    //   286	240	1	i	int
    //   298	123	2	j	int
    //   91	384	3	l1	long
    //   433	72	5	l2	long
    //   86	478	7	localEntityManager	EntityManager
    //   153	127	8	localList	List
    //   529	18	8	localException	java.lang.Exception
    //   561	8	8	localObject1	Object
    //   74	283	9	localObject2	Object
    //   225	44	10	localFTSMessageForDel	FTSMessageForDel
    //   264	105	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   92	274	529	java/lang/Exception
    //   279	287	529	java/lang/Exception
    //   287	351	529	java/lang/Exception
    //   356	364	529	java/lang/Exception
    //   364	428	529	java/lang/Exception
    //   428	513	529	java/lang/Exception
    //   92	274	561	finally
    //   279	287	561	finally
    //   287	351	561	finally
    //   356	364	561	finally
    //   364	428	561	finally
    //   428	513	561	finally
    //   531	555	561	finally
  }
  
  public void destroy()
  {
    super.destroy();
    if ((this.jdField_a_of_type_Akvm != null) && (this.jdField_a_of_type_Akvm.isOpen())) {
      this.jdField_a_of_type_Akvm.close();
    }
  }
  
  public int y(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.cAu = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.dF("IndexContent");
    }
    return this.cAu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxz
 * JD-Core Version:    0.7.0.1
 */