package com.tencent.thumbplayer.common.report;

import org.json.JSONObject;

public class TPDeviceCapabilityReportParameters
{
  private AV1DecoderParams mAV1DecoderParams = new AV1DecoderParams();
  private CommonParams mCommonParams = new CommonParams();
  
  public AV1DecoderParams getAV1DecoderParams()
  {
    return this.mAV1DecoderParams;
  }
  
  public CommonParams getCommonParams()
  {
    return this.mCommonParams;
  }
  
  void resetAllParams()
  {
    this.mCommonParams.reset();
    this.mAV1DecoderParams.reset();
  }
  
  class AV1DecoderParams
    implements ITPReportParams
  {
    private static final String AV1_HW_DECODER_LEVEL = "av1hwdecoderlevel";
    private static final String AV1_HW_DECODER_PROFILE = "av1hwdecoderprofile";
    private static final int LEVEL_UNKNOWN = -1;
    private static final int PROFILE_UNKNOWN = -1;
    public int av1HWDecoderLevel;
    public int av1HWDecoderProfile;
    
    public AV1DecoderParams()
    {
      reset();
    }
    
    public void paramsToJson(JSONObject paramJSONObject) {}
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("av1hwdecoderprofile", this.av1HWDecoderProfile);
      paramITPReportProperties.put("av1hwdecoderlevel", this.av1HWDecoderLevel);
    }
    
    public void reset()
    {
      this.av1HWDecoderProfile = -1;
      this.av1HWDecoderLevel = -1;
    }
  }
  
  class CommonParams
    implements ITPReportParams
  {
    private static final String API_LEVEL = "apilevel";
    private static final String CPU_NAME = "cpuname";
    private static final String FLOW_ID = "flowid";
    private static final String MODEL = "model";
    private static final String OS_VER = "osver";
    private static final String PLATFORM = "appplatform";
    private static final String SERIAL_NO = "serialno";
    public int apiLevel;
    public String cpuName;
    public String flowId;
    public String model;
    public String osVer;
    public int platform;
    public String serialNo;
    
    public CommonParams()
    {
      reset();
    }
    
    public void paramsToJson(JSONObject paramJSONObject) {}
    
    public void paramsToProperties(ITPReportProperties paramITPReportProperties)
    {
      paramITPReportProperties.put("flowid", this.flowId);
      paramITPReportProperties.put("appplatform", this.platform);
      paramITPReportProperties.put("apilevel", this.apiLevel);
      paramITPReportProperties.put("osver", this.osVer);
      paramITPReportProperties.put("model", this.model);
      paramITPReportProperties.put("serialno", this.serialNo);
      paramITPReportProperties.put("cpuname", this.cpuName);
    }
    
    public void reset()
    {
      this.flowId = "";
      this.platform = -1;
      this.apiLevel = -1;
      this.osVer = "";
      this.model = "";
      this.serialNo = "";
      this.cpuName = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.common.report.TPDeviceCapabilityReportParameters
 * JD-Core Version:    0.7.0.1
 */