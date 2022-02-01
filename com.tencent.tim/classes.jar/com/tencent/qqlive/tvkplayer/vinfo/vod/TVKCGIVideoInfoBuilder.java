package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TVKCGIVideoInfoBuilder
{
  private int br;
  private int clipCount = 0;
  private int dltype;
  private int em = -1;
  private int exem = -1;
  private String fn;
  private String format;
  private int formatId;
  private String fvkey;
  private String linkvid;
  private ArrayList<TVKCGIVideoInfoVkeyInfo> mVkeyInfos = new ArrayList();
  private int st;
  private String url;
  private ArrayList<String> urlList = new ArrayList();
  private String vid;
  private TVKCGIVideoInfo videoInfo = new TVKCGIVideoInfo();
  private TVKVideoInfoParams videoInfoParams;
  private Map<String, Class> vinfoFormatNodeNameMap = new HashMap();
  private Map<String, ParseVinfoViNodeAction> vinfoViActionMap = new HashMap();
  private String vinfoXml;
  
  public TVKCGIVideoInfoBuilder()
  {
    initVinfoViActionMap();
    initVinfoFormatNodeNameMap();
  }
  
  private void buildClipMp4CdnUrl(String paramString)
  {
    Object localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    ((StringBuffer)localObject1).append("<CLIPMP4><VERSION>2</VERSION><CLIPSINFO>");
    Object localObject2 = ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getUrl();
    Iterator localIterator = this.videoInfo.getMp4ClipInfos().iterator();
    String str;
    if (localIterator.hasNext())
    {
      TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo localTVKCGIVideoMp4ClipInfo = (TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localIterator.next();
      if (TextUtils.isEmpty(paramString)) {}
      for (str = generateMp4url((String)localObject2 + generateClipMp4Filename(this.fn, localTVKCGIVideoMp4ClipInfo.getIdx()), localTVKCGIVideoMp4ClipInfo.getVkey(), localTVKCGIVideoMp4ClipInfo.getKeyid());; str = localTVKCGIVideoMp4ClipInfo.getUrl())
      {
        ((StringBuffer)localObject1).append("<CLIPINFO>");
        ((StringBuffer)localObject1).append("<DURATION>");
        ((StringBuffer)localObject1).append(localTVKCGIVideoMp4ClipInfo.getDuration() * 1000.0D * 1000.0D);
        ((StringBuffer)localObject1).append("</DURATION>");
        ((StringBuffer)localObject1).append("<CLIPSIZE>");
        ((StringBuffer)localObject1).append(localTVKCGIVideoMp4ClipInfo.getSize());
        ((StringBuffer)localObject1).append("</CLIPSIZE>");
        ((StringBuffer)localObject1).append("<URL>");
        ((StringBuffer)localObject1).append(str.replaceAll("&", "&amp;"));
        ((StringBuffer)localObject1).append("</URL>");
        ((StringBuffer)localObject1).append("<URLPARAM>");
        ((StringBuffer)localObject1).append("clipid=" + localTVKCGIVideoMp4ClipInfo.getIdx());
        ((StringBuffer)localObject1).append("</URLPARAM>");
        ((StringBuffer)localObject1).append("</CLIPINFO>");
        break;
      }
    }
    ((StringBuffer)localObject1).append("</CLIPSINFO></CLIPMP4>");
    this.url = ((StringBuffer)localObject1).toString();
    localObject1 = this.videoInfo.getMp4ClipInfos().iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)((Iterator)localObject1).next();
      int i = 0;
      label365:
      if (i < this.videoInfo.getUrlInfos().size())
      {
        str = ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(i)).getUrl();
        if (!TextUtils.isEmpty(paramString)) {
          break label472;
        }
      }
      label472:
      for (str = generateMp4url(str + generateClipMp4Filename(this.fn, ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject2).getIdx()), ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject2).getVkey(), ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject2).getKeyid());; str = ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject2).getUrl())
      {
        if (i == 0) {
          ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject2).setUrl(str);
        }
        ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)localObject2).addUrlList(str);
        i += 1;
        break label365;
        break;
      }
    }
  }
  
  private void buildHlsCdnUrl(String paramString)
  {
    String str = getSdtfrom();
    Object localObject;
    if (this.videoInfo.getUrlInfos().size() > 0)
    {
      localObject = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0);
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label281;
        }
        if (this.dltype != 3) {
          break label238;
        }
        this.url = (((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject).getUrl() + String.format("%s&hlskey=%s&sdtfrom=%s", new Object[] { ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject).getPt(), ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject).getHk(), str }));
      }
    }
    label281:
    for (;;)
    {
      localObject = this.videoInfo.getUrlInfos().iterator();
      while (((Iterator)localObject).hasNext())
      {
        TVKCGIVideoInfo.TVKCGIVideoUrlInfo localTVKCGIVideoUrlInfo = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)((Iterator)localObject).next();
        if (localTVKCGIVideoUrlInfo != null)
        {
          StringBuffer localStringBuffer = new StringBuffer();
          localStringBuffer.append(localTVKCGIVideoUrlInfo.getUrl());
          if (TextUtils.isEmpty(paramString))
          {
            if (this.dltype == 3)
            {
              localStringBuffer.append(localTVKCGIVideoUrlInfo.getPt());
              localStringBuffer.append("&hlskey=");
              localStringBuffer.append(localTVKCGIVideoUrlInfo.getHk());
            }
            localStringBuffer.append("&sdtfrom=");
            localStringBuffer.append(str);
          }
          this.urlList.add(localStringBuffer.toString());
        }
      }
      label238:
      if (this.dltype == 8)
      {
        this.url = (((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject).getUrl() + "&sdtfrom=" + str);
        continue;
        this.url = ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject).getUrl();
      }
    }
    this.videoInfo.setUrlList(this.urlList);
  }
  
  private void buildMp4CdnUrl(String paramString)
  {
    Object localObject = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0);
    if (localObject != null)
    {
      this.url = ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject).getUrl();
      if (TextUtils.isEmpty(paramString)) {
        this.url = generateMp4url(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localObject).getUrl() + this.fn, this.fvkey, "");
      }
    }
    Iterator localIterator = this.videoInfo.getUrlInfos().iterator();
    if (localIterator.hasNext())
    {
      TVKCGIVideoInfo.TVKCGIVideoUrlInfo localTVKCGIVideoUrlInfo = (TVKCGIVideoInfo.TVKCGIVideoUrlInfo)localIterator.next();
      localObject = localTVKCGIVideoUrlInfo.getUrl();
      if (!TextUtils.isEmpty(paramString)) {
        break label178;
      }
      localObject = generateMp4url(localTVKCGIVideoUrlInfo.getUrl() + this.fn, this.fvkey, "");
    }
    label178:
    for (;;)
    {
      this.urlList.add(localObject);
      break;
      this.videoInfo.setUrlList(this.urlList);
      return;
    }
  }
  
  private String convertNodeToXmlString(Node paramNode)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int i = j;
    Node localNode;
    try
    {
      if (paramNode.hasChildNodes())
      {
        i = j;
        if (paramNode.getFirstChild().hasChildNodes())
        {
          localStringBuilder.append("<").append(paramNode.getNodeName()).append(">");
          i = 1;
        }
      }
      for (;;)
      {
        if (paramNode.hasChildNodes())
        {
          localNode = paramNode.getFirstChild();
          if (localNode.hasChildNodes())
          {
            localStringBuilder.append(convertNodeToXmlString(localNode));
            paramNode.removeChild(paramNode.getFirstChild());
            continue;
            return localStringBuilder.toString();
          }
        }
      }
    }
    catch (Exception paramNode)
    {
      paramNode.printStackTrace();
    }
    for (;;)
    {
      localStringBuilder.append("<").append(localNode.getParentNode().getNodeName()).append(">");
      localStringBuilder.append(localNode.getNodeValue());
      localStringBuilder.append("</").append(localNode.getParentNode().getNodeName()).append(">");
      break;
      if (i != 0) {
        localStringBuilder.append("</").append(paramNode.getNodeName()).append(">");
      }
    }
  }
  
  private String generateClipMp4Filename(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf(".");
    return String.format("%s%d%s", new Object[] { paramString.substring(0, i + 1), Integer.valueOf(paramInt), paramString.substring(i) });
  }
  
  private String generateMp4url(String paramString1, String paramString2, String paramString3)
  {
    String str1 = getSdtfrom();
    String str2 = TVideoMgr.getStaGuid();
    paramString2 = String.format("%s?vkey=%s&platform=%d&br=%d&fmt=%s&sdtfrom=%s&guid=%s", new Object[] { paramString1, paramString2, Integer.valueOf(getPlatform()), Integer.valueOf(this.br), this.format, str1, str2 });
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = paramString2 + "&keyid=";
      paramString1 = paramString1 + paramString3;
    }
    return paramString1;
  }
  
  private String getFirstChildNodeValue(Node paramNode)
  {
    if ((paramNode != null) && (paramNode.getFirstChild() != null)) {
      return paramNode.getFirstChild().getNodeValue();
    }
    return "";
  }
  
  private int getPlatform()
  {
    if (this.videoInfoParams != null) {
      return this.videoInfoParams.getPlatForm();
    }
    return TVideoMgr.getVinfoPlatform();
  }
  
  private String getSdtfrom()
  {
    if (this.videoInfoParams != null) {
      return TVideoMgr.getVinfoSdtfrom(this.videoInfoParams.getPlatForm());
    }
    return TVideoMgr.getVinfoSdtfrom();
  }
  
  private void initVinfoFormatNodeNameMap()
  {
    this.vinfoFormatNodeNameMap.put("id", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("name", String.class);
    this.vinfoFormatNodeNameMap.put("br", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("fs", Long.TYPE);
    this.vinfoFormatNodeNameMap.put("sl", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("cname", String.class);
    this.vinfoFormatNodeNameMap.put("lmt", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("profile", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("drm", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("super", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("video", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("audio", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("sb", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("hdr10enh", Integer.TYPE);
    this.vinfoFormatNodeNameMap.put("sname", String.class);
    this.vinfoFormatNodeNameMap.put("resolution", String.class);
  }
  
  private void initVinfoViActionMap()
  {
    this.vinfoViActionMap.put("vi", new ViParseVinfoViNodeAction());
    this.vinfoViActionMap.put("vid", new VidParseVinfoViNodeAction());
    this.vinfoViActionMap.put("fn", new FnParseVinfoViNodeAction());
    this.vinfoViActionMap.put("st", new StParseVinfoViNodeAction());
    this.vinfoViActionMap.put("lnk", new LnkParseVinfoViNodeAction());
    this.vinfoViActionMap.put("fvkey", new FvkeyParseVinfoViNodeAction());
    this.vinfoViActionMap.put("base", new BaseParseVinfoViNodeAction());
    this.vinfoViActionMap.put("duration", new DurationParseVinfoViNodeAction());
    this.vinfoViActionMap.put("ch", new ChParseVinfoViNodeAction());
    this.vinfoViActionMap.put("ckc", new ChkParseVinfoViNodeAction());
    this.vinfoViActionMap.put("ct", new CtParseVinfoViNodeAction());
    this.vinfoViActionMap.put("dm", new DmParseVinfoViNodeAction());
    this.vinfoViActionMap.put("drm", new DrmParseVinfoViNodeAction());
    this.vinfoViActionMap.put("enc", new EncParseVinfoViNodeAction());
    this.vinfoViActionMap.put("fmd5", new Fmd5ParseVinfoViNodeAction());
    this.vinfoViActionMap.put("fps", new FpsParseVinfoViNodeAction());
    this.vinfoViActionMap.put("keyid", new KeyidParseVinfoViNodeAction());
    this.vinfoViActionMap.put("fs", new FsParseVinfoViNodeAction());
    this.vinfoViActionMap.put("fst", new FstParseVinfoViNodeAction());
    this.vinfoViActionMap.put("head", new HeadParseVinfoViNodeAction());
    this.vinfoViActionMap.put("hevc", new HevcParseVinfoViNodeAction());
    this.vinfoViActionMap.put("iflag", new IflagParseVinfoViNodeAction());
    this.vinfoViActionMap.put("mst", new MstParseVinfoViNodeAction());
    this.vinfoViActionMap.put("tail", new TailParseVinfoViNodeAction());
    this.vinfoViActionMap.put("targetid", new TargetIdParseVinfoViNodeAction());
    this.vinfoViActionMap.put("td", new TdParseVinfoViNodeAction());
    this.vinfoViActionMap.put("ti", new TiParseVinfoViNodeAction());
    this.vinfoViActionMap.put("tie", new TieParseVinfoViNodeAction());
    this.vinfoViActionMap.put("type", new TypeParseVinfoViNodeAction());
    this.vinfoViActionMap.put("vh", new VhParseVinfoViNodeAction());
    this.vinfoViActionMap.put("vw", new VwParseVinfoViNodeAction());
    this.vinfoViActionMap.put("wh", new WhParseVinfoViNodeAction());
    this.vinfoViActionMap.put("videotype", new VideotypeParseVinfoViNodeAction());
    this.vinfoViActionMap.put("vr", new VrParseVinfoViNodeAction());
    this.vinfoViActionMap.put("vst", new VstParseVinfoViNodeAction());
    this.vinfoViActionMap.put("swhdcp", new SwhdcpParseVinfoViNodeAction());
    this.vinfoViActionMap.put("br", new BrParseVinfoViNodeAction());
    this.vinfoViActionMap.put("cl", new ClParseVinfoViNodeAction());
    this.vinfoViActionMap.put("ul", new UlParseVinfoViNodeAction());
    this.vinfoViActionMap.put("pl", new PlParseVinfoViNodeAction());
    this.vinfoViActionMap.put("wl", new WlParseVinfoViNodeAction());
    this.vinfoViActionMap.put("ad", new AdParseVinfoViNodeAction());
    this.vinfoViActionMap.put("ll", new LlParseVinfoViNodeAction());
  }
  
  private void innerParseVinfoFormatNode(Node paramNode, TVKCGIVideoInfo.TVKCGIVideoFormatInfo paramTVKCGIVideoFormatInfo)
  {
    String str;
    if (paramNode.getNodeType() == 1)
    {
      str = paramNode.getNodeName().toLowerCase();
      if (!str.equals("fi")) {
        break label41;
      }
      parseVinfoFormatNode(paramNode.getChildNodes());
    }
    label41:
    do
    {
      do
      {
        return;
      } while (!this.vinfoFormatNodeNameMap.containsKey(str));
      if (this.vinfoFormatNodeNameMap.get(str) == Integer.TYPE)
      {
        TVKUtils.invokeSetterMethod(paramTVKCGIVideoFormatInfo, str, Integer.TYPE, Integer.valueOf(TVKUtils.optInt(getFirstChildNodeValue(paramNode), 0)));
        return;
      }
      if (this.vinfoFormatNodeNameMap.get(str) == Long.TYPE)
      {
        TVKUtils.invokeSetterMethod(paramTVKCGIVideoFormatInfo, str, Long.TYPE, Long.valueOf(TVKUtils.optLong(getFirstChildNodeValue(paramNode), 0L)));
        return;
      }
    } while (this.vinfoFormatNodeNameMap.get(str) != String.class);
    TVKUtils.invokeSetterMethod(paramTVKCGIVideoFormatInfo, str, String.class, getFirstChildNodeValue(paramNode));
  }
  
  private void parseTvLogoNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo localTVKCGIVideoTVLogoInfo = new TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo();
      int i = 0;
      if (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1)
        {
          if (!localNode.getNodeName().equalsIgnoreCase("li")) {
            break label78;
          }
          parseTvLogoNode(localNode.getChildNodes());
        }
        for (;;)
        {
          i += 1;
          break;
          label78:
          if (localNode.getNodeName().equalsIgnoreCase("h")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoH(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("w")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoW(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("x")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoX(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("y")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoY(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("show")) {
            localTVKCGIVideoTVLogoInfo.setTvLogoShow(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
        }
      }
      if ((localTVKCGIVideoTVLogoInfo.getTvLogoH() != 0) || ((localTVKCGIVideoTVLogoInfo.getTvLogoW() != 0) && (localTVKCGIVideoTVLogoInfo.getTvLogoX() != 0)) || (localTVKCGIVideoTVLogoInfo.getTvLogoY() != 0)) {
        this.videoInfo.addTVLogoInfo(localTVKCGIVideoTVLogoInfo);
      }
    }
  }
  
  private void parseVinfoAdNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if ((localNode.getNodeType() == 1) && (localNode.getNodeName().equalsIgnoreCase("adsid"))) {
          this.videoInfo.setAdsid(getFirstChildNodeValue(localNode));
        }
        i += 1;
      }
    }
  }
  
  private void parseVinfoAlNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo localTVKCGIVideoAudioTrackInfo = new TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo();
      int i = 0;
      if (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1)
        {
          if (!localNode.getNodeName().equalsIgnoreCase("ai")) {
            break label79;
          }
          parseVinfoAlNode(localNode.getChildNodes());
        }
        for (;;)
        {
          i += 1;
          break;
          label79:
          if (localNode.getNodeName().equalsIgnoreCase("sl"))
          {
            localTVKCGIVideoAudioTrackInfo.setSl(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("action"))
          {
            localTVKCGIVideoAudioTrackInfo.setAction(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("audio"))
          {
            localTVKCGIVideoAudioTrackInfo.setAudio(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("lmt"))
          {
            localTVKCGIVideoAudioTrackInfo.setLmt(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("keyid"))
          {
            localTVKCGIVideoAudioTrackInfo.setKeyid(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("name"))
          {
            localTVKCGIVideoAudioTrackInfo.setName(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("preview"))
          {
            localTVKCGIVideoAudioTrackInfo.setPreview(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("track"))
          {
            localTVKCGIVideoAudioTrackInfo.setTrack(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("ul"))
          {
            int j = 0;
            while (j < localNode.getChildNodes().getLength())
            {
              localTVKCGIVideoAudioTrackInfo.addUrlList(localNode.getChildNodes().item(j).getFirstChild().getFirstChild().getNodeValue());
              j += 1;
            }
          }
        }
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoAudioTrackInfo.getName())) {
        this.videoInfo.addAudioTrackInfos(localTVKCGIVideoAudioTrackInfo);
      }
    }
  }
  
  private void parseVinfoClipNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo localTVKCGIVideoMp4ClipInfo = new TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo();
      int i = 0;
      if (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1)
        {
          if (!localNode.getNodeName().equalsIgnoreCase("fc")) {
            break label92;
          }
          this.clipCount = TVKUtils.optInt(getFirstChildNodeValue(localNode), 0);
          this.videoInfo.setFc(this.clipCount);
        }
        for (;;)
        {
          i += 1;
          break;
          label92:
          if (localNode.getNodeName().equalsIgnoreCase("ci")) {
            parseVinfoClipNode(localNode.getChildNodes());
          } else if (localNode.getNodeName().equalsIgnoreCase("idx")) {
            localTVKCGIVideoMp4ClipInfo.setIdx(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("cs")) {
            localTVKCGIVideoMp4ClipInfo.setSize(TVKUtils.optLong(getFirstChildNodeValue(localNode), 0L));
          } else if (localNode.getNodeName().equalsIgnoreCase("cd")) {
            localTVKCGIVideoMp4ClipInfo.setDuration(TVKUtils.optFloat(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("cmd5")) {
            localTVKCGIVideoMp4ClipInfo.setCmd5(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("keyid")) {
            localTVKCGIVideoMp4ClipInfo.setKeyid(getFirstChildNodeValue(localNode));
          }
        }
      }
      if (localTVKCGIVideoMp4ClipInfo.getIdx() > 0) {
        this.videoInfo.addMp4ClipInfo(localTVKCGIVideoMp4ClipInfo);
      }
    }
  }
  
  private void parseVinfoFormatNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoFormatInfo localTVKCGIVideoFormatInfo = new TVKCGIVideoInfo.TVKCGIVideoFormatInfo();
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        innerParseVinfoFormatNode(paramNodeList.item(i), localTVKCGIVideoFormatInfo);
        i += 1;
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoFormatInfo.getName())) {
        this.videoInfo.addFormatInfo(localTVKCGIVideoFormatInfo);
      }
      if (localTVKCGIVideoFormatInfo.getSl() == 1)
      {
        this.videoInfo.setSelectedFormat(localTVKCGIVideoFormatInfo.getName());
        this.videoInfo.setSelectedFormatID(localTVKCGIVideoFormatInfo.getId());
        this.videoInfo.setSelectedFilesize(localTVKCGIVideoFormatInfo.getFs());
        this.formatId = localTVKCGIVideoFormatInfo.getId();
        this.format = localTVKCGIVideoFormatInfo.getName();
        this.br = localTVKCGIVideoFormatInfo.getBr();
      }
    }
  }
  
  private void parseVinfoPlNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoPictureInfo localTVKCGIVideoPictureInfo = new TVKCGIVideoInfo.TVKCGIVideoPictureInfo();
      int i = 0;
      if (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1)
        {
          if (!localNode.getNodeName().equalsIgnoreCase("pd")) {
            break label78;
          }
          parseVinfoPlNode(localNode.getChildNodes());
        }
        for (;;)
        {
          i += 1;
          break;
          label78:
          if (localNode.getNodeName().equalsIgnoreCase("cd")) {
            localTVKCGIVideoPictureInfo.setCd(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("h")) {
            localTVKCGIVideoPictureInfo.setH(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("w")) {
            localTVKCGIVideoPictureInfo.setW(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("r")) {
            localTVKCGIVideoPictureInfo.setR(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("c")) {
            localTVKCGIVideoPictureInfo.setC(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("fmt")) {
            localTVKCGIVideoPictureInfo.setFmt(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("fn")) {
            localTVKCGIVideoPictureInfo.setFn(getFirstChildNodeValue(localNode));
          }
        }
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoPictureInfo.getFn())) {
        this.videoInfo.addPictureInfo(localTVKCGIVideoPictureInfo);
      }
    }
  }
  
  private void parseVinfoRootNode(Document paramDocument)
  {
    if (paramDocument != null)
    {
      paramDocument = paramDocument.getFirstChild().getChildNodes();
      int i = 0;
      if (i < paramDocument.getLength())
      {
        Node localNode = paramDocument.item(i);
        if (localNode.getNodeType() == 1)
        {
          if (!localNode.getNodeName().equalsIgnoreCase("em")) {
            break label92;
          }
          this.em = TVKUtils.optInt(getFirstChildNodeValue(localNode), 0);
          this.videoInfo.setEm(this.em);
        }
        for (;;)
        {
          i += 1;
          break;
          label92:
          if (localNode.getNodeName().equalsIgnoreCase("exem"))
          {
            this.exem = TVKUtils.optInt(getFirstChildNodeValue(localNode), 0);
            this.videoInfo.setExem(this.exem);
          }
          else if (localNode.getNodeName().equalsIgnoreCase("dltype"))
          {
            this.dltype = TVKUtils.optInt(getFirstChildNodeValue(localNode), 0);
            this.videoInfo.setDltype(this.dltype);
          }
          else if (localNode.getNodeName().equalsIgnoreCase("preview"))
          {
            this.videoInfo.setPreview(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("s"))
          {
            this.videoInfo.setS(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("tm"))
          {
            this.videoInfo.setTm(TVKUtils.optLong(getFirstChildNodeValue(localNode), 0L));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("fp2p"))
          {
            this.videoInfo.setFp2p(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("tstid"))
          {
            this.videoInfo.setTstid(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("ip"))
          {
            this.videoInfo.setIp(getFirstChildNodeValue(localNode));
          }
          else if (localNode.getNodeName().equalsIgnoreCase("fl"))
          {
            parseVinfoFormatNode(localNode.getChildNodes());
          }
          else if (localNode.getNodeName().equalsIgnoreCase("al"))
          {
            parseVinfoAlNode(localNode.getChildNodes());
          }
          else if (localNode.getNodeName().equalsIgnoreCase("vl"))
          {
            parseVinfoViNode(localNode.getChildNodes());
          }
          else if (localNode.getNodeName().equalsIgnoreCase("sfl"))
          {
            parseVinfoSflNode(localNode.getChildNodes());
          }
        }
      }
    }
  }
  
  private void parseVinfoSflNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo localTVKCGIVideoSubtitleInfo = new TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo();
      int i = 0;
      if (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1)
        {
          if (!localNode.getNodeName().equalsIgnoreCase("fi")) {
            break label78;
          }
          parseVinfoSflNode(localNode.getChildNodes());
        }
        for (;;)
        {
          i += 1;
          break;
          label78:
          if (localNode.getNodeName().equalsIgnoreCase("keyid")) {
            localTVKCGIVideoSubtitleInfo.setKeyid(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("name")) {
            localTVKCGIVideoSubtitleInfo.setName(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("url")) {
            localTVKCGIVideoSubtitleInfo.setUrl(getFirstChildNodeValue(localNode));
          }
        }
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoSubtitleInfo.getKeyid())) {
        this.videoInfo.addSubtitleInfo(localTVKCGIVideoSubtitleInfo);
      }
    }
  }
  
  private void parseVinfoUrlNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoUrlInfo localTVKCGIVideoUrlInfo = new TVKCGIVideoInfo.TVKCGIVideoUrlInfo();
      int i = 0;
      if (i < paramNodeList.getLength())
      {
        Object localObject = paramNodeList.item(i);
        if (((Node)localObject).getNodeType() == 1)
        {
          if (!((Node)localObject).getNodeName().equalsIgnoreCase("ui")) {
            break label79;
          }
          parseVinfoUrlNode(((Node)localObject).getChildNodes());
        }
        label79:
        do
        {
          for (;;)
          {
            i += 1;
            break;
            if (((Node)localObject).getNodeName().equalsIgnoreCase("url"))
            {
              localTVKCGIVideoUrlInfo.setUrl(getFirstChildNodeValue((Node)localObject));
            }
            else if (((Node)localObject).getNodeName().equalsIgnoreCase("m3u8"))
            {
              localObject = getFirstChildNodeValue((Node)localObject);
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                this.videoInfo.setM3u8((String)localObject);
              }
            }
            else if (((Node)localObject).getNodeName().equalsIgnoreCase("vt"))
            {
              localTVKCGIVideoUrlInfo.setVt(TVKUtils.optInt(getFirstChildNodeValue((Node)localObject), 0));
            }
            else if (((Node)localObject).getNodeName().equalsIgnoreCase("spip"))
            {
              localTVKCGIVideoUrlInfo.setSpip(getFirstChildNodeValue((Node)localObject));
            }
            else if (((Node)localObject).getNodeName().equalsIgnoreCase("spport"))
            {
              localTVKCGIVideoUrlInfo.setSpport(getFirstChildNodeValue((Node)localObject));
            }
            else
            {
              if (!((Node)localObject).getNodeName().equalsIgnoreCase("path")) {
                break label277;
              }
              localTVKCGIVideoUrlInfo.setPath(getFirstChildNodeValue((Node)localObject));
            }
          }
        } while (!((Node)localObject).getNodeName().equalsIgnoreCase("hls"));
        label277:
        localObject = ((Node)localObject).getChildNodes();
        int j = 0;
        label304:
        Node localNode;
        if (j < ((NodeList)localObject).getLength())
        {
          localNode = ((NodeList)localObject).item(j);
          if (localNode.getNodeType() == 1)
          {
            if (!localNode.getNodeName().equalsIgnoreCase("hk")) {
              break label370;
            }
            localTVKCGIVideoUrlInfo.setHk(getFirstChildNodeValue(localNode));
          }
        }
        for (;;)
        {
          j += 1;
          break label304;
          break;
          label370:
          if (localNode.getNodeName().equalsIgnoreCase("pt")) {
            localTVKCGIVideoUrlInfo.setPt(getFirstChildNodeValue(localNode));
          }
        }
      }
      if (!localTVKCGIVideoUrlInfo.getUrl().isEmpty()) {
        this.videoInfo.addUrlInfos(localTVKCGIVideoUrlInfo);
      }
    }
  }
  
  private void parseVinfoViNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      int i = 0;
      if (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1) {
          if (localNode.getNodeName() == null) {
            break label90;
          }
        }
        label90:
        for (Object localObject = localNode.getNodeName().toLowerCase();; localObject = "")
        {
          localObject = (ParseVinfoViNodeAction)this.vinfoViActionMap.get(localObject);
          if (localObject != null) {
            ((ParseVinfoViNodeAction)localObject).onParseVinfoViNode(localNode);
          }
          i += 1;
          break;
        }
      }
    }
  }
  
  private void parseVinfoWlNode(NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo localTVKCGIVideoWatermarkInfo = new TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo();
      int i = 0;
      if (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if (localNode.getNodeType() == 1)
        {
          if (!localNode.getNodeName().equalsIgnoreCase("wi")) {
            break label78;
          }
          parseVinfoWlNode(localNode.getChildNodes());
        }
        for (;;)
        {
          i += 1;
          break;
          label78:
          if (localNode.getNodeName().equalsIgnoreCase("id")) {
            localTVKCGIVideoWatermarkInfo.setId(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("x")) {
            localTVKCGIVideoWatermarkInfo.setX(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("y")) {
            localTVKCGIVideoWatermarkInfo.setY(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("h")) {
            localTVKCGIVideoWatermarkInfo.setH(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("w")) {
            localTVKCGIVideoWatermarkInfo.setW(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("a")) {
            localTVKCGIVideoWatermarkInfo.setA(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
          } else if (localNode.getNodeName().equalsIgnoreCase("md5")) {
            localTVKCGIVideoWatermarkInfo.setMd5(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("url")) {
            localTVKCGIVideoWatermarkInfo.setUrl(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("surl")) {
            localTVKCGIVideoWatermarkInfo.setSurl(getFirstChildNodeValue(localNode));
          } else if (localNode.getNodeName().equalsIgnoreCase("action")) {
            this.videoInfo.setAction(getFirstChildNodeValue(localNode));
          }
        }
      }
      if (!TextUtils.isEmpty(localTVKCGIVideoWatermarkInfo.getMd5())) {
        this.videoInfo.addWatermarkInfos(localTVKCGIVideoWatermarkInfo);
      }
    }
  }
  
  public void buildCdnUrl(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.dltype == 1)
    {
      if (this.clipCount > 0)
      {
        buildClipMp4CdnUrl(str);
        return;
      }
      buildMp4CdnUrl(str);
      return;
    }
    buildHlsCdnUrl(str);
  }
  
  public int getClipCount()
  {
    return this.clipCount;
  }
  
  public int getDltype()
  {
    return this.dltype;
  }
  
  public int getEm()
  {
    return this.em;
  }
  
  public int getExem()
  {
    return this.exem;
  }
  
  public int getFormatId()
  {
    return this.formatId;
  }
  
  public String getLinkvid()
  {
    return this.linkvid;
  }
  
  public String getPath()
  {
    if (this.videoInfo.getUrlInfos().size() > 0) {
      return ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getPath();
    }
    return "";
  }
  
  public String getSpip()
  {
    if (this.videoInfo.getUrlInfos().size() > 0) {
      return ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getSpip();
    }
    return "";
  }
  
  public String getSpport()
  {
    if (this.videoInfo.getUrlInfos().size() > 0) {
      return ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getSpport();
    }
    return "";
  }
  
  public int getSt()
  {
    return this.st;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public TVKVideoInfoParams getVideoInfoParams()
  {
    return this.videoInfoParams;
  }
  
  public String getVinfoXml()
  {
    return this.vinfoXml;
  }
  
  public int getVkeyCount()
  {
    return this.mVkeyInfos.size();
  }
  
  public int getVt()
  {
    return ((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getVt();
  }
  
  public TVKCGIVideoInfo parseVinfo(Document paramDocument)
  {
    try
    {
      parseVinfoRootNode(paramDocument);
      if (this.videoInfo.getMp4ClipInfos().size() > 0)
      {
        ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(0)).setUrl(((TVKCGIVideoInfo.TVKCGIVideoUrlInfo)this.videoInfo.getUrlInfos().get(0)).getUrl());
        ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(0)).setVkey(this.fvkey);
        paramDocument = new TVKCGIVideoInfoVkeyInfo();
        paramDocument.setIdx(1);
        paramDocument.setVkey(this.fvkey);
        this.mVkeyInfos.add(paramDocument);
      }
      return this.videoInfo;
    }
    catch (Throwable paramDocument)
    {
      for (;;)
      {
        paramDocument.printStackTrace();
      }
    }
  }
  
  public void parseVkeyInfo(Document paramDocument)
  {
    Object localObject1;
    Object localObject2;
    if (paramDocument != null)
    {
      localObject1 = paramDocument.getElementsByTagName("em");
      localObject2 = paramDocument.getElementsByTagName("exem");
      if (((NodeList)localObject1).getLength() <= 0) {
        break label84;
      }
      this.em = TVKUtils.optInt(getFirstChildNodeValue(((NodeList)localObject1).item(0)), 0);
      this.exem = TVKUtils.optInt(getFirstChildNodeValue(((NodeList)localObject2).item(0)), 0);
      if (this.em <= 0) {
        break label84;
      }
    }
    for (;;)
    {
      return;
      label84:
      paramDocument = paramDocument.getElementsByTagName("cl").item(0).getChildNodes();
      int i = 0;
      while (i < paramDocument.getLength())
      {
        localObject1 = paramDocument.item(i);
        if ((((Node)localObject1).getNodeType() == 1) && (((Node)localObject1).getNodeName().equalsIgnoreCase("ci")))
        {
          localObject1 = ((Node)localObject1).getChildNodes();
          localObject2 = new TVKCGIVideoInfoVkeyInfo();
          int j = 0;
          if (j < ((NodeList)localObject1).getLength())
          {
            Node localNode = ((NodeList)localObject1).item(j);
            if (localNode.getNodeType() == 1)
            {
              if (!localNode.getNodeName().equalsIgnoreCase("idx")) {
                break label243;
              }
              ((TVKCGIVideoInfoVkeyInfo)localObject2).setIdx(TVKUtils.optInt(getFirstChildNodeValue(localNode), 0));
            }
            for (;;)
            {
              j += 1;
              break;
              label243:
              if (localNode.getNodeName().equalsIgnoreCase("key"))
              {
                ((TVKCGIVideoInfoVkeyInfo)localObject2).setVkey(getFirstChildNodeValue(localNode));
              }
              else if ((localNode.getNodeName().equalsIgnoreCase("ul")) && (localNode.getFirstChild() != null))
              {
                localNode = localNode.getFirstChild().getFirstChild();
                if ((localNode != null) && (localNode.getNodeName().equalsIgnoreCase("url"))) {
                  ((TVKCGIVideoInfoVkeyInfo)localObject2).setUrl(getFirstChildNodeValue(localNode));
                }
              }
            }
          }
          this.mVkeyInfos.add(localObject2);
          j = ((TVKCGIVideoInfoVkeyInfo)localObject2).getIdx() - 1;
          if ((j > 0) && (this.videoInfo.getMp4ClipInfos().get(j) != null) && (((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(j)).getIdx() == ((TVKCGIVideoInfoVkeyInfo)localObject2).getIdx()))
          {
            ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(j)).setUrl(((TVKCGIVideoInfoVkeyInfo)localObject2).getUrl());
            ((TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo)this.videoInfo.getMp4ClipInfos().get(j)).setVkey(((TVKCGIVideoInfoVkeyInfo)localObject2).getVkey());
          }
        }
        i += 1;
      }
    }
  }
  
  public void setVideoInfoParams(TVKVideoInfoParams paramTVKVideoInfoParams)
  {
    this.videoInfoParams = paramTVKVideoInfoParams;
  }
  
  public void setVinfoXml(String paramString)
  {
    this.vinfoXml = paramString;
  }
  
  class AdParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    AdParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.parseVinfoAdNode(paramNode.getChildNodes());
    }
  }
  
  class BaseParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    BaseParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setBase(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
    }
  }
  
  class BrParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    BrParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setBr(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class ChParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    ChParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setCh(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class ChkParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    ChkParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setCkc(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
    }
  }
  
  class ClParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    ClParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.parseVinfoClipNode(paramNode.getChildNodes());
    }
  }
  
  class CtParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    CtParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setCt(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class DmParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    DmParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setDm(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class DrmParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    DrmParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setDrm(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class DurationParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    DurationParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setDuration(TVKUtils.optDouble(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0.0D));
    }
  }
  
  class EncParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    EncParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setEnc(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class Fmd5ParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    Fmd5ParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setFmd5(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
    }
  }
  
  class FnParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    FnParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.access$402(TVKCGIVideoInfoBuilder.this, TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
      TVKCGIVideoInfoBuilder.this.videoInfo.setFn(TVKCGIVideoInfoBuilder.this.fn);
    }
  }
  
  class FpsParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    FpsParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setFps(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
    }
  }
  
  class FsParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    FsParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setFs(TVKUtils.optLong(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0L));
    }
  }
  
  class FstParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    FstParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setFst(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class FvkeyParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    FvkeyParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.access$702(TVKCGIVideoInfoBuilder.this, TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
      TVKCGIVideoInfoBuilder.this.videoInfo.setFvkey(TVKCGIVideoInfoBuilder.this.fvkey);
    }
  }
  
  class HeadParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    HeadParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setHead(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class HevcParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    HevcParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setHevc(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class IflagParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    IflagParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setIflag(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class KeyidParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    KeyidParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setKeyid(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
    }
  }
  
  class LlParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    LlParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.parseTvLogoNode(paramNode.getChildNodes());
    }
  }
  
  class LnkParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    LnkParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.access$602(TVKCGIVideoInfoBuilder.this, TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
      TVKCGIVideoInfoBuilder.this.videoInfo.setLnk(TVKCGIVideoInfoBuilder.this.linkvid);
    }
  }
  
  class MstParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    MstParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setMst(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  public static abstract interface ParseVinfoViNodeAction
  {
    public abstract void onParseVinfoViNode(Node paramNode);
  }
  
  class PlParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    PlParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setPlInfoXml(TVKCGIVideoInfoBuilder.this.convertNodeToXmlString(paramNode));
      TVKCGIVideoInfoBuilder.this.parseVinfoPlNode(paramNode.getChildNodes());
    }
  }
  
  class StParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    StParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.access$502(TVKCGIVideoInfoBuilder.this, TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
      TVKCGIVideoInfoBuilder.this.videoInfo.setSt(TVKCGIVideoInfoBuilder.this.st);
    }
  }
  
  class SwhdcpParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    SwhdcpParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setSwhdcp(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  public static class TVKCGIVideoInfoVkeyInfo
    implements Serializable
  {
    private static final long serialVersionUID = -1L;
    private int idx;
    private String url;
    private String vkey;
    
    public int getIdx()
    {
      return this.idx;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public String getVkey()
    {
      return this.vkey;
    }
    
    public void setIdx(int paramInt)
    {
      this.idx = paramInt;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
    
    public void setVkey(String paramString)
    {
      this.vkey = paramString;
    }
  }
  
  class TailParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    TailParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setTail(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class TargetIdParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    TargetIdParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setTargetid(TVKUtils.optLong(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0L));
    }
  }
  
  class TdParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    TdParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setTd(TVKUtils.optFloat(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class TiParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    TiParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setTi(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
    }
  }
  
  class TieParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    TieParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setTie(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class TypeParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    TypeParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setType(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class UlParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    UlParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.parseVinfoUrlNode(paramNode.getChildNodes());
    }
  }
  
  class VhParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    VhParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setVh(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class ViParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    ViParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.parseVinfoViNode(paramNode.getChildNodes());
    }
  }
  
  class VidParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    VidParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.access$102(TVKCGIVideoInfoBuilder.this, TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode));
      TVKCGIVideoInfoBuilder.this.videoInfo.setVid(TVKCGIVideoInfoBuilder.this.vid);
    }
  }
  
  class VideotypeParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    VideotypeParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setVideotype(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class VrParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    VrParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setVr(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class VstParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    VstParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setVst(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class VwParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    VwParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setVw(TVKUtils.optInt(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class WhParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    WhParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.videoInfo.setWh(TVKUtils.optFloat(TVKCGIVideoInfoBuilder.this.getFirstChildNodeValue(paramNode), 0));
    }
  }
  
  class WlParseVinfoViNodeAction
    implements TVKCGIVideoInfoBuilder.ParseVinfoViNodeAction
  {
    WlParseVinfoViNodeAction() {}
    
    public void onParseVinfoViNode(Node paramNode)
    {
      TVKCGIVideoInfoBuilder.this.parseVinfoWlNode(paramNode.getChildNodes());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfoBuilder
 * JD-Core Version:    0.7.0.1
 */