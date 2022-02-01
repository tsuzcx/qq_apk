package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HlsMasterPlaylist
  extends HlsPlaylist
{
  public final List<HlsUrl> audios;
  public final Format muxedAudioFormat;
  public final List<Format> muxedCaptionFormats;
  public final List<HlsUrl> subtitles;
  public final List<HlsUrl> variants;
  
  public HlsMasterPlaylist(String paramString, List<String> paramList, List<HlsUrl> paramList1, List<HlsUrl> paramList2, List<HlsUrl> paramList3, Format paramFormat, List<Format> paramList4)
  {
    super(paramString, paramList);
    this.variants = Collections.unmodifiableList(paramList1);
    this.audios = Collections.unmodifiableList(paramList2);
    this.subtitles = Collections.unmodifiableList(paramList3);
    this.muxedAudioFormat = paramFormat;
    if (paramList4 != null) {}
    for (paramString = Collections.unmodifiableList(paramList4);; paramString = null)
    {
      this.muxedCaptionFormats = paramString;
      return;
    }
  }
  
  private static List<HlsUrl> copyRenditionsList(List<HlsUrl> paramList, List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList(paramList1.size());
    int i = 0;
    while (i < paramList.size())
    {
      HlsUrl localHlsUrl = (HlsUrl)paramList.get(i);
      if (paramList1.contains(localHlsUrl.url)) {
        localArrayList.add(localHlsUrl);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static HlsMasterPlaylist createSingleVariantMasterPlaylist(String paramString)
  {
    paramString = Collections.singletonList(HlsUrl.createMediaPlaylistHlsUrl(paramString));
    List localList = Collections.emptyList();
    return new HlsMasterPlaylist(null, Collections.emptyList(), paramString, localList, localList, null, null);
  }
  
  public HlsMasterPlaylist copy(List<String> paramList)
  {
    return new HlsMasterPlaylist(this.baseUri, this.tags, copyRenditionsList(this.variants, paramList), copyRenditionsList(this.audios, paramList), copyRenditionsList(this.subtitles, paramList), this.muxedAudioFormat, this.muxedCaptionFormats);
  }
  
  public static final class HlsUrl
  {
    public final Format format;
    public final String url;
    
    public HlsUrl(String paramString, Format paramFormat)
    {
      this.url = paramString;
      this.format = paramFormat;
    }
    
    public static HlsUrl createMediaPlaylistHlsUrl(String paramString)
    {
      return new HlsUrl(paramString, Format.createContainerFormat("0", "application/x-mpegURL", null, null, -1, 0, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist
 * JD-Core Version:    0.7.0.1
 */