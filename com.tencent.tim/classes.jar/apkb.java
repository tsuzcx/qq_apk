import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.PinyinTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class apkb
{
  protected ArrayList<WordInfo> BZ = new ArrayList(2);
  protected List<String> HV = new ArrayList();
  protected apkb.a a;
  protected apkb.b a;
  protected ArticleInfo a;
  QQAppInterface app;
  TroopManager jdField_b_of_type_ComTencentMobileqqAppTroopManager;
  WordInfo jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = null;
  protected boolean cQZ;
  boolean cRa = false;
  protected int clt;
  protected int dUG;
  protected int dUH;
  int dUI = 0;
  int dUJ = 0;
  int dUK = -1;
  int dUL = 0;
  int dUM = 0;
  double de = -1.0D;
  String mTroopUin;
  protected Handler mUIHandler = new apkc(this, Looper.getMainLooper());
  protected HandlerThread mWorkThread;
  
  public apkb(ArticleInfo paramArticleInfo, apkb.b paramb, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = paramArticleInfo;
    this.mTroopUin = paramString;
    this.jdField_b_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size())
    {
      ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(i)).resetWordsReciteStatus();
      i += 1;
    }
    this.jdField_a_of_type_Apkb$b = paramb;
    this.mWorkThread = new HandlerThread("ReciteDetectHandlerThread");
    this.mWorkThread.start();
    this.jdField_a_of_type_Apkb$a = new apkb.a(this.mWorkThread.getLooper());
    this.cQZ = false;
  }
  
  protected void WN(int paramInt)
  {
    int i;
    label196:
    do
    {
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReciteDetect.ReciteDetectManager", 2, "doDetectNextWord, start");
          }
          i = this.HV.size();
          if (i == 0) {
            return;
          }
          if (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo == null)
          {
            WordInfo localWordInfo = c();
            if (localWordInfo != null) {
              this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = localWordInfo;
            }
          }
          else
          {
            if (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo != null) {
              break;
            }
            ear();
            continue;
          }
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = b();
        }
        finally {}
        while ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo != null) && (!this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isNormalWord()))
        {
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.color = WordInfo.COLOR_DEFAULT;
          localObject2 = this.mUIHandler.obtainMessage();
          ((Message)localObject2).what = 0;
          ((Message)localObject2).obj = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
          this.mUIHandler.sendMessage((Message)localObject2);
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = b();
        }
      }
      if (!QLog.isColorLevel()) {
        break label771;
      }
      QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("背诵内容[%s]\n检测答案[%s]", new Object[] { this.HV.toString(), this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.pinyin2Detect.toString() }));
      break label771;
      if (i >= this.HV.size()) {
        break label774;
      }
      localObject2 = (String)this.HV.get(i);
      if (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isPinyinDetectRight((String)localObject2))
      {
        this.dUI = 0;
        this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.color = WordInfo.COLOR_DEFAULT;
        this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isDetected = true;
        localObject2 = this.mUIHandler.obtainMessage();
        ((Message)localObject2).what = 0;
        ((Message)localObject2).obj = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
        this.mUIHandler.sendMessage((Message)localObject2);
        if (i >= this.dUM)
        {
          this.dUL += i - this.dUM;
          if (QLog.isColorLevel()) {
            QLog.d("ReciteDetect.ReciteDetectManager", 2, "detected！！！mLastSentenceSubLen:" + this.dUL);
          }
        }
        for (this.dUM = 0;; this.dUM -= i)
        {
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = null;
          localObject2 = this.HV.toString();
          this.HV = this.HV.subList(i + 1, this.HV.size());
          localObject3 = this.HV.toString();
          if (QLog.isColorLevel()) {
            QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("识别结果,对 || 对背诵内容进行截断，为下一个字检测所用：\n before[%s], \n after[%s], removeIndex[%d]", new Object[] { localObject2, localObject3, Integer.valueOf(i) }));
          }
          if (paramInt >= this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.a.dUp) {
            break;
          }
          WN(paramInt + 1);
          break;
        }
      }
      if (i <= this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.a.dUq) {
        break label764;
      }
      this.dUI += 1;
      this.clt += 1;
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.color = WordInfo.COLOR_WRONG;
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isDetected = true;
      localObject2 = this.mUIHandler.obtainMessage();
      ((Message)localObject2).what = 0;
      ((Message)localObject2).obj = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
      this.mUIHandler.sendMessage((Message)localObject2);
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = null;
      if (QLog.isColorLevel()) {
        QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("识别结果,错||mErroCount[%d], continuousWrongNum[%d]", new Object[] { Integer.valueOf(this.clt), Integer.valueOf(this.dUI) }));
      }
      if (this.dUI < this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.a.dUr) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReciteDetect.ReciteDetectManager", 2, "repeatRecite");
      }
      eaq();
      localObject2 = this.mUIHandler.obtainMessage();
      ((Message)localObject2).what = 1;
      this.mUIHandler.sendMessage((Message)localObject2);
    } while (this.app == null);
    Object localObject3 = this.app;
    String str1 = this.mTroopUin;
    String str2 = this.mTroopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null) {}
    for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title;; localObject2 = "")
    {
      aqfr.a((QQAppInterface)localObject3, str1, "Grp_recite", "Norecognize_Recite_Again_Clk", 0, 0, new String[] { str2, "", localObject2, "" });
      break;
      if (paramInt >= this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.a.dUp) {
        break;
      }
      WN(paramInt + 1);
      break;
      label764:
      i += 1;
      break label196;
      label771:
      i = 0;
      break label196;
      label774:
      break;
    }
  }
  
  public void a(double paramDouble, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (this.jdField_a_of_type_Apkb$b == null) || (this.cQZ)) {}
    while (this.de > paramDouble) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Apkb$a.obtainMessage(2);
    Bundle localBundle = new Bundle();
    localBundle.putDouble("startTime", paramDouble);
    localBundle.putStringArray("pinyins", paramArrayOfString);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  protected WordInfo b()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReciteDetect.ReciteDetectManager", 2, "getNextWord detectingParagraphPos = " + this.dUJ + " detectingWordInParagaphPos" + this.dUK + " lastParagraphDetectEnd" + this.cRa);
        }
        if (this.cRa)
        {
          this.dUJ += 1;
          this.dUK = 0;
          this.cRa = false;
          if (this.dUJ < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size())
          {
            Object localObject1 = ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(this.dUJ)).generateOrGetWordInfoList(this.dUJ);
            if (this.dUK < ((List)localObject1).size())
            {
              WordInfo localWordInfo = (WordInfo)((List)localObject1).get(this.dUK);
              localWordInfo.paragraphPos = this.dUJ;
              if (QLog.isColorLevel()) {
                QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("正在检测的文字是：%s", new Object[] { localWordInfo.toString() }));
              }
              if (this.dUK == ((List)localObject1).size() - 1) {
                this.cRa = true;
              }
              localObject1 = localWordInfo;
              if (!PinyinTextView.qz(localWordInfo.text))
              {
                this.dUG += 1;
                localObject1 = localWordInfo;
              }
              return localObject1;
            }
          }
        }
        else
        {
          this.dUK += 1;
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
    }
  }
  
  protected void b(double paramDouble, String[] paramArrayOfString)
  {
    int j = 0;
    for (;;)
    {
      String str1;
      ArrayList localArrayList;
      try
      {
        str1 = this.HV.toString() + ",mLastSentenceSubLen:" + this.dUL;
        String str2;
        if (this.de != paramDouble)
        {
          this.de = paramDouble;
          this.dUL = 0;
          i = 0;
          localArrayList = new ArrayList(paramArrayOfString.length);
          if (j >= paramArrayOfString.length) {
            break label149;
          }
          str2 = paramArrayOfString[j];
          if (PinyinTextView.qz(str2))
          {
            if (!QLog.isColorLevel()) {
              break label297;
            }
            QLog.d("ReciteDetect.ReciteDetectManager", 2, "背诵内容是标点符号，跳过");
            break label297;
          }
        }
        else
        {
          if (this.dUL == 0) {
            break label306;
          }
          j = this.dUL;
          i = 0;
          continue;
        }
        localArrayList.add(str2);
      }
      finally {}
      label149:
      if (i != 0)
      {
        if (this.dUM != 0) {
          break label258;
        }
        this.HV.clear();
      }
      for (;;)
      {
        if (!localArrayList.isEmpty())
        {
          this.dUM = this.HV.size();
          this.HV.addAll(localArrayList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("yellowye", 2, "recitingPinyinsList, 插入前：" + str1 + "\n插入后：" + this.HV.toString());
        }
        return;
        label258:
        if (this.dUM <= this.HV.size() - 1) {
          this.HV = this.HV.subList(0, this.dUM);
        }
      }
      label297:
      j += 1;
      continue;
      label306:
      int i = 1;
    }
  }
  
  /* Error */
  protected WordInfo c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	apkb:BZ	Ljava/util/ArrayList;
    //   6: invokevirtual 372	java/util/ArrayList:isEmpty	()Z
    //   9: ifne +19 -> 28
    //   12: aload_0
    //   13: getfield 76	apkb:BZ	Ljava/util/ArrayList;
    //   16: iconst_0
    //   17: invokevirtual 375	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   20: checkcast 174	com/tencent/mobileqq/troop/homework/recite/data/WordInfo
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aconst_null
    //   29: astore_1
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	apkb
    //   23	7	1	localWordInfo	WordInfo
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	33	finally
  }
  
  protected void c(WordInfo paramWordInfo)
  {
    label274:
    for (;;)
    {
      try
      {
        Object localObject;
        if (this.BZ.isEmpty())
        {
          localObject = null;
          if (localObject == null) {
            break label274;
          }
          if ((paramWordInfo.paragraphPos >= ((WordInfo)localObject).paragraphPos) && (paramWordInfo.wordPos > ((WordInfo)localObject).wordPos))
          {
            break label274;
            if ((paramWordInfo != null) && (paramWordInfo.paragraphPos < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size()) && (i != 0))
            {
              localObject = ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(paramWordInfo.paragraphPos)).generateOrGetWordInfoList(paramWordInfo.paragraphPos);
              i = paramWordInfo.wordPos + 1;
              if (i < ((List)localObject).size())
              {
                WordInfo localWordInfo = (WordInfo)((List)localObject).get(i);
                if (QLog.isColorLevel()) {
                  QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("ifNextWordIsPunctuationThenShow：%s", new Object[] { localWordInfo.toString() }));
                }
                if (!localWordInfo.isNormalWord())
                {
                  localWordInfo.color = WordInfo.COLOR_DEFAULT;
                  this.jdField_a_of_type_Apkb$b.b(localWordInfo);
                  if ((this.dUJ == paramWordInfo.wordPos) && (this.dUK == paramWordInfo.paragraphPos))
                  {
                    this.dUK += 1;
                    if (i == ((List)localObject).size() - 1) {
                      this.cRa = true;
                    }
                  }
                  c(localWordInfo);
                }
              }
            }
          }
        }
        else
        {
          localObject = (WordInfo)this.BZ.get(this.BZ.size() - 1);
          continue;
        }
        int i = 0;
        continue;
        i = 1;
      }
      finally {}
    }
  }
  
  protected void eaq()
  {
    this.HV.clear();
    this.clt = 0;
    this.cQZ = true;
    this.dUH = 0;
    this.de = 0.0D;
    this.dUL = 0;
    this.dUM = 0;
  }
  
  public void ear()
  {
    if (this.cQZ) {}
    do
    {
      return;
      this.cQZ = true;
      if (this.jdField_a_of_type_Apkb$b == null) {
        break;
      }
      Message localMessage = this.mUIHandler.obtainMessage();
      localMessage.what = 2;
      this.mUIHandler.sendMessage(localMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("onCompleteRecite, mWordTotalCount[%d], mErroCount[%d], mRemindCount[%d]", new Object[] { Integer.valueOf(this.dUG), Integer.valueOf(this.clt), Integer.valueOf(this.dUH) }));
    return;
    this.dUG = 0;
    this.dUH = 0;
  }
  
  public void eas()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.a.dUo)
        {
          Object localObject2;
          if ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo != null) && (!this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isReminded))
          {
            localObject2 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
            if (localObject2 != null)
            {
              ((WordInfo)localObject2).color = -7829368;
              ((WordInfo)localObject2).isReminded = true;
              this.BZ.add(localObject2);
              this.jdField_a_of_type_Apkb$b.b((WordInfo)localObject2);
              this.dUH += 1;
            }
          }
          else
          {
            WordInfo localWordInfo = b();
            localObject2 = localWordInfo;
            if (localWordInfo == null) {
              continue;
            }
            localObject2 = localWordInfo;
            if (localWordInfo.isNormalWord()) {
              continue;
            }
            localWordInfo.color = WordInfo.COLOR_DEFAULT;
            this.jdField_a_of_type_Apkb$b.b(localWordInfo);
            localWordInfo = b();
            continue;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void reset()
  {
    try
    {
      this.de = 0.0D;
      this.de = -1.0D;
      this.dUM = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      for (;;)
      {
        try
        {
          switch (paramMessage.what)
          {
          case 2: 
            return;
          }
        }
        finally {}
        paramMessage = paramMessage.getData();
        apkb.this.b(paramMessage.getDouble("startTime"), paramMessage.getStringArray("pinyins"));
        apkb.this.WN(0);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(WordInfo paramWordInfo);
    
    public abstract void bd(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void eaa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkb
 * JD-Core Version:    0.7.0.1
 */