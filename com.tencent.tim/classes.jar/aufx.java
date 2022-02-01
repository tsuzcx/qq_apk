import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class aufx
{
  QQAppInterface app;
  protected int erv;
  int type;
  
  public void VK(boolean paramBoolean) {}
  
  public ConfigurationService.ConfigSeq a()
  {
    if (this.type <= 0) {
      return null;
    }
    ConfigurationService.ConfigSeq localConfigSeq = new ConfigurationService.ConfigSeq();
    localConfigSeq.type.set(this.type);
    PBInt32Field localPBInt32Field = localConfigSeq.compress;
    if (aJp()) {}
    for (int i = 1;; i = 0)
    {
      localPBInt32Field.set(i);
      i = lA();
      if (QLog.isColorLevel()) {
        QLog.i("BaseConfigHandler", 2, "send config request, cmd=" + this.type + " version:" + i);
      }
      localConfigSeq.version.set(i);
      return localConfigSeq;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseConfigHandler", 2, "handleConfig type:" + paramInt + " success:" + paramBoolean + " config:" + paramConfig);
    }
    if ((!paramBoolean) || (paramConfig == null))
    {
      VK(paramBoolean);
      return;
    }
    paramInt = lA();
    int i = paramConfig.version.get();
    this.erv = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.i("BaseConfigHandler", 2, "handleConfig localVersion:" + paramInt + " serverVersion:" + i);
    }
    ArrayList localArrayList;
    Object localObject2;
    String str;
    Object localObject3;
    if (paramInt != i)
    {
      localArrayList = new ArrayList();
      if (paramConfig.msg_content_list.size() > 0)
      {
        localObject2 = paramConfig.msg_content_list.get().iterator();
        str = null;
        if (!((Iterator)localObject2).hasNext()) {
          break label481;
        }
        localObject3 = (ConfigurationService.Content)((Iterator)localObject2).next();
        if (((ConfigurationService.Content)localObject3).compress.get() == 1)
        {
          localObject3 = aurv.decompress(((ConfigurationService.Content)localObject3).content.get().toByteArray());
          if (localObject3 == null)
          {
            if (!QLog.isColorLevel()) {
              break label515;
            }
            QLog.e("BaseConfigHandler", 2, "buffer is null");
          }
        }
      }
    }
    label515:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseConfigHandler", 2, "xmlContent :" + str);
      }
      if (str != null) {
        localArrayList.add(str);
      }
      break;
      try
      {
        str = new String((byte[])localObject3, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BaseConfigHandler", 2, localUnsupportedEncodingException, new Object[0]);
        }
        localObject1 = null;
      }
      continue;
      Object localObject1 = ((ConfigurationService.Content)localObject3).content.get().toStringUtf8();
      continue;
      if (paramConfig.content_list.size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("BaseConfigHandler", 2, "content_list_size " + paramConfig.content_list.size());
        }
        localObject1 = paramConfig.content_list.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.i("BaseConfigHandler", 2, "xmlContent :" + (String)localObject2);
          }
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
      label481:
      nR(localArrayList);
      aqmj.d(this.app.getApp(), hJ(), paramConfig.version.get());
      return;
      VK(true);
      return;
    }
  }
  
  public abstract boolean aJp();
  
  protected abstract String hJ();
  
  protected int lA()
  {
    return aqmj.k(this.app.getApp(), hJ());
  }
  
  public abstract void nR(List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufx
 * JD-Core Version:    0.7.0.1
 */