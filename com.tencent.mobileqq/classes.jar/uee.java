import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.JSPttDownloadProcessor;
import com.tencent.mobileqq.transfile.JSPttUploadProcessor;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class uee
  implements INetEngine.INetEngineListener
{
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new uef(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<TransferRequest> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<HttpNetReq> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<TransferRequest> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Bundle> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public uee(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = paramQQAppInterface.getNetEngine(0);
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)localIterator.next();
      if (localHttpNetReq.mReqUrl.equals(paramString)) {
        localArrayList.add(localHttpNetReq);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HttpNetReq)((Iterator)localObject1).next();
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.cancelReq((NetReq)localObject2);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      TransferRequest localTransferRequest;
      while (((Iterator)localObject2).hasNext())
      {
        localTransferRequest = (TransferRequest)((Iterator)localObject2).next();
        ((TransFileController)localObject1).cancelSendingPic(localTransferRequest.mPeerUin, localTransferRequest.mUniseq);
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localTransferRequest = (TransferRequest)((Iterator)localObject2).next();
        ((TransFileController)localObject1).cancelJsPttTask(localTransferRequest.mPeerUin, localTransferRequest.mUniseq);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  void a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      if (localTransferRequest.mUniseq == paramLong) {
        localArrayList.add(localTransferRequest);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (HttpUtil.getNetWorkType() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pic_puin");
    TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    localTransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mCommandId = 10;
    localTransferRequest.mLocalPath = str;
    localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mFileType = 24;
    localTransferRequest.mRichTag = "PAJSSDKPicUploadProcess";
    localTransFileController.transferAsync(localTransferRequest);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localTransferRequest);
  }
  
  void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      if (localTransferRequest.mUniseq == paramLong) {
        localArrayList.add(localTransferRequest);
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    int k = 0;
    if (HttpUtil.getNetWorkType() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = this;
      localHttpNetReq.mReqUrl = str;
      localHttpNetReq.mExcuteTimeLimit = 180000L;
      if (localHttpNetReq.mReqUrl == null) {
        break;
      }
      Object localObject1 = localHttpNetReq.mReqUrl.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localHttpNetReq.mOutPath = (AppConstants.SDCARD_PATH + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(AppConstants.SDCARD_PATH + "c2bPIC/");
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((File)localObject2).listFiles();
      if (localObject2 != null)
      {
        int i = 0;
        int j;
        while (i < localObject2.length)
        {
          if (!localObject2[i].isDirectory())
          {
            j = localObject2[i].getName().lastIndexOf(".");
            if (j != -1) {
              localArrayList.add(localObject2[i].getName().substring(0, j));
            }
          }
          i += 1;
        }
        i = 0;
        for (;;)
        {
          j = k;
          if (i < localArrayList.size())
          {
            if (((String)localObject1).equalsIgnoreCase((String)localArrayList.get(i))) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            paramBundle.putString("pic_local_id", (String)localObject1);
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
            return;
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.sendReq(localHttpNetReq);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localHttpNetReq);
    } while (paramBundle.getInt("is_showProgress_tips") != 1);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramBundle);
    return;
    paramBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_local_path");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { JSPttUploadProcessor.class });
    ((TransFileController)localObject).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    localObject = new TransferRequest();
    ((TransferRequest)localObject).mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((TransferRequest)localObject).mPeerUin = "255";
    ((TransferRequest)localObject).mUinType = 9999;
    ((TransferRequest)localObject).mFileType = 32;
    ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000000.0D));
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mLocalPath = str;
    ((TransferRequest)localObject).mBusiType = 102;
    ((TransferRequest)localObject).mPttCompressFinish = true;
    ((TransferRequest)localObject).mPttUploadPanel = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync((TransferRequest)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { JSPttDownloadProcessor.class });
    ((TransFileController)localObject).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    localObject = new TransferRequest();
    ((TransferRequest)localObject).mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((TransferRequest)localObject).mPeerUin = "255";
    ((TransferRequest)localObject).mUinType = 9999;
    ((TransferRequest)localObject).mFileType = 32;
    ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000.0D));
    ((TransferRequest)localObject).mIsUp = false;
    ((TransferRequest)localObject).mServerPath = str;
    ((TransferRequest)localObject).mOutFilePath = (AppConstants.SDCARD_PATH + "c2bPTT/" + str + ".amr");
    if (new File(((TransferRequest)localObject).mOutFilePath).exists())
    {
      paramBundle.putString("pic_local_id", new ufa().a(((TransferRequest)localObject).mOutFilePath));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((TransferRequest)localObject).mIsSelfSend = true;
    ((TransferRequest)localObject).mDbRecVersion = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync((TransferRequest)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject;
    Bundle localBundle;
    if ((paramNetResp != null) && ((paramNetResp.mReq instanceof HttpNetReq)))
    {
      localObject = (HttpNetReq)paramNetResp.mReq;
      if ((paramNetResp.mResult == 0) || (paramNetResp.mResult == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((HttpNetReq)localObject).mReqUrl);
        a(((HttpNetReq)localObject).mReqUrl);
        if (localBundle != null)
        {
          if ((((HttpNetReq)localObject).mReqUrl == null) || (paramNetResp.mResult != 0)) {
            break label293;
          }
          paramNetResp = ((HttpNetReq)localObject).mReqUrl.split("/");
          if (paramNetResp.length < 2) {
            break label293;
          }
          localBundle.putString("pic_local_id", paramNetResp[(paramNetResp.length - 2)]);
          localObject = ((HttpNetReq)localObject).mOutPath;
          if ((localObject == null) || ("".equals(localObject))) {
            break label293;
          }
          paramNetResp = new File((String)localObject);
          if (!paramNetResp.exists()) {
            break label293;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = FileUtils.estimateFileType((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (paramNetResp.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception paramNetResp)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label293:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uee
 * JD-Core Version:    0.7.0.1
 */