package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stGlobalConfig
  extends JceStruct
{
  static stCallInfo cache_callinfo;
  static stCommentConfig cache_commentConfig = new stCommentConfig();
  static downloadConfig cache_download;
  static stJumpInfo cache_jumpinfo = new stJumpInfo();
  static stLinkConfig cache_linkConfig;
  static Map<String, String> cache_mapExt;
  static pendantConfig cache_pendant;
  static stPopWindowsConfig cache_red_dot_window;
  static stUserAuth cache_user_auth;
  static ArrayList<stPopWindowsConfig> cache_windows_config = new ArrayList();
  public int cache_size;
  public stCallInfo callinfo;
  public stCommentConfig commentConfig;
  public downloadConfig download;
  public String encrypted_deviceid = "";
  public boolean isHalfAppStoreScreen;
  public byte is_call_weishi;
  public byte is_direct_open;
  public stJumpInfo jumpinfo;
  public stLinkConfig linkConfig;
  public int link_strategy_type;
  public Map<String, String> mapExt;
  public int open_4g_autodownload;
  public pendantConfig pendant;
  public stPopWindowsConfig red_dot_window;
  public stUserAuth user_auth;
  public ArrayList<stPopWindowsConfig> windows_config;
  
  static
  {
    stPopWindowsConfig localstPopWindowsConfig = new stPopWindowsConfig();
    cache_windows_config.add(localstPopWindowsConfig);
    cache_pendant = new pendantConfig();
    cache_download = new downloadConfig();
    cache_linkConfig = new stLinkConfig();
    cache_red_dot_window = new stPopWindowsConfig();
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
    cache_callinfo = new stCallInfo();
    cache_user_auth = new stUserAuth();
  }
  
  public stGlobalConfig() {}
  
  public stGlobalConfig(stJumpInfo paramstJumpInfo, ArrayList<stPopWindowsConfig> paramArrayList, byte paramByte1, int paramInt1, int paramInt2, pendantConfig parampendantConfig, int paramInt3, byte paramByte2, downloadConfig paramdownloadConfig, String paramString, stLinkConfig paramstLinkConfig, stPopWindowsConfig paramstPopWindowsConfig, boolean paramBoolean, Map<String, String> paramMap, stCallInfo paramstCallInfo, stUserAuth paramstUserAuth, stCommentConfig paramstCommentConfig)
  {
    this.jumpinfo = paramstJumpInfo;
    this.windows_config = paramArrayList;
    this.is_call_weishi = paramByte1;
    this.link_strategy_type = paramInt1;
    this.open_4g_autodownload = paramInt2;
    this.pendant = parampendantConfig;
    this.cache_size = paramInt3;
    this.is_direct_open = paramByte2;
    this.download = paramdownloadConfig;
    this.encrypted_deviceid = paramString;
    this.linkConfig = paramstLinkConfig;
    this.red_dot_window = paramstPopWindowsConfig;
    this.isHalfAppStoreScreen = paramBoolean;
    this.mapExt = paramMap;
    this.callinfo = paramstCallInfo;
    this.user_auth = paramstUserAuth;
    this.commentConfig = paramstCommentConfig;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.jumpinfo = ((stJumpInfo)paramJceInputStream.read(cache_jumpinfo, 0, false));
    this.windows_config = ((ArrayList)paramJceInputStream.read(cache_windows_config, 1, false));
    this.is_call_weishi = paramJceInputStream.read(this.is_call_weishi, 2, false);
    this.link_strategy_type = paramJceInputStream.read(this.link_strategy_type, 3, false);
    this.open_4g_autodownload = paramJceInputStream.read(this.open_4g_autodownload, 4, false);
    this.pendant = ((pendantConfig)paramJceInputStream.read(cache_pendant, 5, false));
    this.cache_size = paramJceInputStream.read(this.cache_size, 6, false);
    this.is_direct_open = paramJceInputStream.read(this.is_direct_open, 7, false);
    this.download = ((downloadConfig)paramJceInputStream.read(cache_download, 8, false));
    this.encrypted_deviceid = paramJceInputStream.readString(9, false);
    this.linkConfig = ((stLinkConfig)paramJceInputStream.read(cache_linkConfig, 10, false));
    this.red_dot_window = ((stPopWindowsConfig)paramJceInputStream.read(cache_red_dot_window, 11, false));
    this.isHalfAppStoreScreen = paramJceInputStream.read(this.isHalfAppStoreScreen, 12, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 13, false));
    this.callinfo = ((stCallInfo)paramJceInputStream.read(cache_callinfo, 14, false));
    this.user_auth = ((stUserAuth)paramJceInputStream.read(cache_user_auth, 15, false));
    this.commentConfig = ((stCommentConfig)paramJceInputStream.read(cache_commentConfig, 16, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.jumpinfo != null) {
      paramJceOutputStream.write(this.jumpinfo, 0);
    }
    if (this.windows_config != null) {
      paramJceOutputStream.write(this.windows_config, 1);
    }
    paramJceOutputStream.write(this.is_call_weishi, 2);
    paramJceOutputStream.write(this.link_strategy_type, 3);
    paramJceOutputStream.write(this.open_4g_autodownload, 4);
    if (this.pendant != null) {
      paramJceOutputStream.write(this.pendant, 5);
    }
    paramJceOutputStream.write(this.cache_size, 6);
    paramJceOutputStream.write(this.is_direct_open, 7);
    if (this.download != null) {
      paramJceOutputStream.write(this.download, 8);
    }
    if (this.encrypted_deviceid != null) {
      paramJceOutputStream.write(this.encrypted_deviceid, 9);
    }
    if (this.linkConfig != null) {
      paramJceOutputStream.write(this.linkConfig, 10);
    }
    if (this.red_dot_window != null) {
      paramJceOutputStream.write(this.red_dot_window, 11);
    }
    paramJceOutputStream.write(this.isHalfAppStoreScreen, 12);
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 13);
    }
    if (this.callinfo != null) {
      paramJceOutputStream.write(this.callinfo, 14);
    }
    if (this.user_auth != null) {
      paramJceOutputStream.write(this.user_auth, 15);
    }
    if (this.commentConfig != null) {
      paramJceOutputStream.write(this.commentConfig, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stGlobalConfig
 * JD-Core Version:    0.7.0.1
 */