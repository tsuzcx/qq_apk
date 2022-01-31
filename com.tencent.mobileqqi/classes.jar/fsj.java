import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EMagicTask;
import com.tencent.mobileqq.emoticon.EMaterialTask;
import com.tencent.mobileqq.emoticon.EPCoverTask;
import com.tencent.mobileqq.emoticon.EPJsonTask;
import com.tencent.mobileqq.emoticon.EPluginInstallTask;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonController.ProgressHandler;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmoticonTask;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class fsj
  extends Thread
{
  public fsj(EmoticonController paramEmoticonController)
  {
    setName(fsj.class.getSimpleName());
  }
  
  private void a()
  {
    for (;;)
    {
      synchronized (this.a.d)
      {
        if (this.a.d.size() == 0) {
          return;
        }
        EmoticonController.ProgressHandler localProgressHandler = (EmoticonController.ProgressHandler)this.a.d.remove(0);
        if (localProgressHandler.a()) {}
      }
      this.a.c.add(localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "EPThread| downloading task, epId=" + localObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      }
      EmoticonController.b(this.a, localObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
      if (Utils.e())
      {
        if (Utils.b() < 1048576L)
        {
          EmoticonController.a(this.a, this.a.c, localObject);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "qq_error|EPThread| Package sdcardcheck, sdcard FULL .return. epId=" + localObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          }
          EmoticonController.a(this.a, localObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 11001);
          localObject.a("param_step", 0);
          EmoticonController.a(this.a, localObject, 11001);
        }
      }
      else
      {
        EmoticonController.a(this.a, this.a.c, localObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "qq_error|EPThread| Package sdcardcheck,has sdcard FALSE .return. epId=" + localObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        }
        EmoticonController.a(this.a, localObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 11000);
        localObject.a("param_step", 0);
        EmoticonController.a(this.a, localObject, 11000);
        return;
      }
      if (localObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 1) {
        b(localObject);
      } else if (localObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 2) {
        c(localObject);
      } else if (localObject.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 3) {
        a(localObject);
      } else {
        d(localObject);
      }
    }
  }
  
  private void a(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "handleMagicFacePackage ep:" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    }
    Object localObject1;
    int i;
    Object localObject2;
    if (!paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.isMagicFaceDownloading)
    {
      localObject1 = new EPJsonTask(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, EmoticonController.a(this.a));
      ((EPJsonTask)localObject1).a(paramProgressHandler);
      ((EPJsonTask)localObject1).a();
      i = ((EPJsonTask)localObject1).a();
      if (i == 0)
      {
        if (3 == paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType) {
          break label903;
        }
        localObject2 = new EPCoverTask(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, EmoticonController.a(this.a));
        ((EPCoverTask)localObject2).a(paramProgressHandler);
        ((EPCoverTask)localObject2).a();
        i = ((EPCoverTask)localObject2).a();
      }
    }
    label900:
    label903:
    for (;;)
    {
      int j;
      if (i == 0)
      {
        localObject2 = ((EPJsonTask)localObject1).a();
        if (((EPJsonTask)localObject1).a())
        {
          if (!NetworkUtil.e(BaseApplication.getContext()))
          {
            EmoticonController.a(this.a, this.a.c, paramProgressHandler);
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.EmoDown", 2, "EPThread| fetchEncryptKeys fail.netUnSupport epId=" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
            }
            if (paramProgressHandler.a()) {
              EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 11003);
            }
            paramProgressHandler.a("param_step", 5);
            EmoticonController.a(this.a, paramProgressHandler, 11003);
            return;
          }
          j = 0;
          int k;
          do
          {
            paramProgressHandler.jdField_b_of_type_JavaLangString = null;
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.EmoDown", 2, "EPThread| fetchEncryptKeys count=" + j);
            }
            EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, (ArrayList)localObject2, paramProgressHandler, false);
            k = j + 1;
            if ((paramProgressHandler.jdField_a_of_type_Boolean) || (!paramProgressHandler.a())) {
              break;
            }
            j = k;
          } while (k < 3);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "EPThread| fetchEncryptKeys count=" + k + " keysSuccess=" + paramProgressHandler.jdField_a_of_type_Boolean);
          }
        }
        while (!paramProgressHandler.jdField_a_of_type_Boolean)
        {
          EmoticonController.a(this.a, this.a.c, paramProgressHandler);
          i = paramProgressHandler.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "qq_error|EPThread| fetchEncryptKeys fail.resultCode=" + i + " epId=" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " encryptGetKeySeq=" + paramProgressHandler.jdField_b_of_type_JavaLangString + " encryptKeysResultCode" + paramProgressHandler.c);
          }
          if (paramProgressHandler.a()) {
            EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
          }
          paramProgressHandler.a("param_step", 5);
          EmoticonController.a(this.a, paramProgressHandler, i);
          return;
          paramProgressHandler.jdField_a_of_type_Boolean = true;
        }
        if (((ArrayList)localObject2).size() <= 0) {
          break label900;
        }
        localObject1 = new EmoticonTask((Emoticon)((ArrayList)localObject2).get(0), EmoticonController.a(this.a), 14);
        ((EmoticonTask)localObject1).a(paramProgressHandler);
        ((EmoticonTask)localObject1).a();
        j = ((EmoticonTask)localObject1).a();
        if (j == 0)
        {
          localObject1 = new EMagicTask(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, EmoticonController.a(this.a));
          ((EMagicTask)localObject1).a(paramProgressHandler);
          ((EMagicTask)localObject1).a();
          i = ((EMagicTask)localObject1).a();
          if (i == 0) {
            EmoticonController.a(this.a, paramProgressHandler);
          }
        }
      }
      for (;;)
      {
        EmoticonController.a(this.a, this.a.c, paramProgressHandler);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.emoji.EmoDown", 2, "EPThread| epdownload finish resultCode:" + i + " epId:" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        return;
        if (paramProgressHandler.a()) {
          EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
        }
        EmoticonController.a(this.a, paramProgressHandler, i);
        continue;
        i = j;
        if (paramProgressHandler.a())
        {
          EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, j);
          EmoticonController.a(this.a, paramProgressHandler, j);
          i = j;
          continue;
          if (paramProgressHandler.a()) {
            EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
          }
          EmoticonController.a(this.a, paramProgressHandler, i);
          continue;
          if (paramProgressHandler.a()) {
            EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
          }
          EmoticonController.a(this.a, paramProgressHandler, i);
          continue;
          localObject1 = new EMagicTask(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, EmoticonController.a(this.a));
          ((EMagicTask)localObject1).a(paramProgressHandler);
          ((EMagicTask)localObject1).a();
          i = ((EMagicTask)localObject1).a();
          if (i == 0)
          {
            EmoticonController.a(this.a, paramProgressHandler);
          }
          else
          {
            if (paramProgressHandler.a()) {
              EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
            }
            EmoticonController.a(this.a, paramProgressHandler, i);
          }
        }
      }
    }
  }
  
  private void b(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "handleQFaceMaterial ep:" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    }
    Object localObject = new EPluginInstallTask("DEmoji.apk", EmoticonController.a(this.a));
    paramProgressHandler.jdField_a_of_type_ComTencentMobileqqEmoticonEPluginInstallTask = ((EPluginInstallTask)localObject);
    ((EPluginInstallTask)localObject).a();
    int i = ((EPluginInstallTask)localObject).a();
    if (i == 0)
    {
      localObject = new EMaterialTask(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, EmoticonController.a(this.a));
      ((EMaterialTask)localObject).a(paramProgressHandler);
      ((EMaterialTask)localObject).a();
      i = ((EMaterialTask)localObject).a();
      if (i == 0)
      {
        paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.status = 2;
        EmoticonController.a(this.a).a(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
        localObject = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((EmoticonPackageDownloadListener)((Iterator)localObject).next()).onPackageEnd(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 0);
        }
        EmoticonController.a(this.a, paramProgressHandler, 0);
      }
    }
    for (;;)
    {
      EmoticonController.a(this.a, this.a.c, paramProgressHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "EPThread| epdownload finish resultCode:" + i + " epId:" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      }
      return;
      if (paramProgressHandler.a()) {
        EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
      }
      EmoticonController.a(this.a, paramProgressHandler, i);
      continue;
      if (paramProgressHandler.a()) {
        EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
      }
      EmoticonController.a(this.a, paramProgressHandler, i);
    }
  }
  
  private void c(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "handleQFaceGifPackage ep:" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    }
    Object localObject2 = paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
    Object localObject1 = new EPCoverTask(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, EmoticonController.a(this.a));
    ((EPCoverTask)localObject1).a(paramProgressHandler);
    ((EPCoverTask)localObject1).a();
    int k = ((EPCoverTask)localObject1).a();
    if (k == 0)
    {
      localObject1 = (ArrayList)EmoticonController.a(this.a).a(((EmoticonPackage)localObject2).epId);
      if (localObject1 != null)
      {
        int m = ((ArrayList)localObject1).size();
        paramProgressHandler.jdField_a_of_type_Int = m;
        int j = 0;
        i = k;
        for (;;)
        {
          if (j >= m) {
            break label401;
          }
          localObject2 = (Emoticon)((ArrayList)localObject1).get(j);
          EmoticonTask localEmoticonTask = new EmoticonTask((Emoticon)localObject2, EmoticonController.a(this.a), 14);
          localEmoticonTask.a(paramProgressHandler);
          localEmoticonTask.a();
          i = localEmoticonTask.a();
          if (i != 0) {
            break;
          }
          if (j == 0) {
            FileUtils.c(EmosmUtils.getEmoticonPreviewPath(((Emoticon)localObject2).epId, ((Emoticon)localObject2).eId), EmosmUtils.getCoverPath(2, ((Emoticon)localObject2).epId));
          }
          paramProgressHandler.jdField_b_of_type_Int += 1;
          EmoticonController.a(this.a, paramProgressHandler);
          j += 1;
        }
        if (paramProgressHandler.a())
        {
          EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
          EmoticonController.a(this.a, paramProgressHandler, i);
        }
        EmoticonController.a(this.a, this.a.c, paramProgressHandler);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "EPThread| epdownload finish resultCode:" + i + " epId:" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        }
        return;
      }
      if (paramProgressHandler.a()) {
        EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, k);
      }
      i = k;
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoQFace", 2, "epId:" + ((EmoticonPackage)localObject2).epId + " has not any emoticon");
      }
    }
    for (int i = k;; i = k)
    {
      label401:
      break;
      if (paramProgressHandler.a()) {
        EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, k);
      }
      EmoticonController.a(this.a, paramProgressHandler, k);
    }
  }
  
  private void d(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "handleEmoticonPackage ep:" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    }
    EPJsonTask localEPJsonTask = new EPJsonTask(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, EmoticonController.a(this.a));
    localEPJsonTask.a(paramProgressHandler);
    localEPJsonTask.a();
    boolean bool = EmoticonUtils.a(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    int i = localEPJsonTask.a();
    if (i == 0) {
      if (bool) {
        EmoticonController.a(this.a, localEPJsonTask, paramProgressHandler, bool);
      }
    }
    for (;;)
    {
      EmoticonController.a(this.a, this.a.c, paramProgressHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "EPThread| epdownload finish resultCode:" + i + " epId:" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      }
      return;
      i = EmoticonController.a(this.a, paramProgressHandler);
      if (i == 0)
      {
        EmoticonController.a(this.a, localEPJsonTask, paramProgressHandler, bool);
      }
      else
      {
        if (paramProgressHandler.a()) {
          EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
        }
        EmoticonController.a(this.a, paramProgressHandler, i);
        continue;
        if (paramProgressHandler.a()) {
          EmoticonController.a(this.a, paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, i);
        }
        EmoticonController.a(this.a, paramProgressHandler, i);
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 330	fsj:a	()V
    //   4: aload_0
    //   5: getfield 10	fsj:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   8: getfield 333	com/tencent/mobileqq/emoticon/EmoticonController:jdField_a_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 10	fsj:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   18: getfield 333	com/tencent/mobileqq/emoticon/EmoticonController:jdField_a_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   21: astore_2
    //   22: aload_0
    //   23: getfield 10	fsj:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   26: aload_0
    //   27: getfield 10	fsj:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   30: getfield 333	com/tencent/mobileqq/emoticon/EmoticonController:jdField_a_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   33: invokevirtual 338	java/lang/Integer:intValue	()I
    //   36: iconst_1
    //   37: isub
    //   38: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: putfield 333	com/tencent/mobileqq/emoticon/EmoticonController:jdField_a_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   44: aload_1
    //   45: monitorexit
    //   46: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +42 -> 91
    //   52: ldc 59
    //   54: iconst_2
    //   55: new 61	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   62: aload_0
    //   63: invokevirtual 345	fsj:getName	()Ljava/lang/String;
    //   66: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 347
    //   72: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: getfield 10	fsj:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   79: getfield 333	com/tencent/mobileqq/emoticon/EmoticonController:jdField_a_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   82: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: return
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   97: aload_0
    //   98: getfield 10	fsj:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   101: ldc_w 352
    //   104: aload_1
    //   105: invokevirtual 353	java/lang/Exception:toString	()Ljava/lang/String;
    //   108: invokestatic 356	com/tencent/mobileqq/emoticon/EmoticonController:a	(Lcom/tencent/mobileqq/emoticon/EmoticonController;Ljava/lang/String;Ljava/lang/String;)V
    //   111: goto -107 -> 4
    //   114: astore_2
    //   115: aload_1
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	fsj
    //   92	24	1	localException	java.lang.Exception
    //   21	1	2	localInteger2	java.lang.Integer
    //   114	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	92	java/lang/Exception
    //   14	46	114	finally
    //   115	117	114	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fsj
 * JD-Core Version:    0.7.0.1
 */