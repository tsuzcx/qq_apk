package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers
{
  private static final String TAG = "AtomParsers";
  private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
  private static final int TYPE_meta = Util.getIntegerCodeForString("meta");
  private static final int TYPE_sbtl;
  private static final int TYPE_soun;
  private static final int TYPE_subt;
  private static final int TYPE_text;
  private static final int TYPE_vide = Util.getIntegerCodeForString("vide");
  
  static
  {
    TYPE_soun = Util.getIntegerCodeForString("soun");
    TYPE_text = Util.getIntegerCodeForString("text");
    TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    TYPE_subt = Util.getIntegerCodeForString("subt");
  }
  
  private static int findEsdsPosition(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2)
  {
    int i = paramParsableByteArray.getPosition();
    while (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int j = paramParsableByteArray.readInt();
      if (j > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Assertions.checkArgument(bool, "childAtomSize should be positive");
        if (paramParsableByteArray.readInt() != Atom.TYPE_esds) {
          break;
        }
        return i;
      }
      i += j;
    }
    return -1;
  }
  
  private static void parseAudioSampleEntry(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, boolean paramBoolean, DrmInitData paramDrmInitData, StsdData paramStsdData, int paramInt5)
    throws ParserException
  {
    paramParsableByteArray.setPosition(paramInt2 + 8 + 8);
    int j;
    int k;
    int i;
    if (paramBoolean)
    {
      j = paramParsableByteArray.readUnsignedShort();
      paramParsableByteArray.skipBytes(6);
      if ((j != 0) && (j != 1)) {
        break label383;
      }
      k = paramParsableByteArray.readUnsignedShort();
      paramParsableByteArray.skipBytes(6);
      i = paramParsableByteArray.readUnsignedFixedPoint1616();
      if (j != 1) {
        break label893;
      }
      paramParsableByteArray.skipBytes(16);
      j = k;
    }
    for (;;)
    {
      label73:
      k = paramParsableByteArray.getPosition();
      Object localObject1;
      if (paramInt1 == Atom.TYPE_enca)
      {
        localObject1 = parseSampleEntryEncryptionData(paramParsableByteArray, paramInt2, paramInt3);
        if (localObject1 != null)
        {
          paramInt1 = ((Integer)((Pair)localObject1).first).intValue();
          if (paramDrmInitData == null)
          {
            paramDrmInitData = null;
            label119:
            paramStsdData.trackEncryptionBoxes[paramInt5] = ((TrackEncryptionBox)((Pair)localObject1).second);
            label135:
            paramParsableByteArray.setPosition(k);
          }
        }
      }
      for (DrmInitData localDrmInitData = paramDrmInitData;; localDrmInitData = paramDrmInitData)
      {
        paramDrmInitData = null;
        label159:
        label173:
        int m;
        boolean bool;
        label201:
        int n;
        label247:
        Object localObject2;
        if (paramInt1 == Atom.TYPE_ac_3)
        {
          paramDrmInitData = "audio/ac3";
          localObject1 = null;
          paramInt1 = i;
          i = j;
          paramInt5 = k;
          if (paramInt5 - paramInt2 >= paramInt3) {
            break label801;
          }
          paramParsableByteArray.setPosition(paramInt5);
          m = paramParsableByteArray.readInt();
          if (m <= 0) {
            break label581;
          }
          bool = true;
          Assertions.checkArgument(bool, "childAtomSize should be positive");
          n = paramParsableByteArray.readInt();
          if ((n != Atom.TYPE_esds) && ((!paramBoolean) || (n != Atom.TYPE_wave))) {
            break label600;
          }
          if (n != Atom.TYPE_esds) {
            break label587;
          }
          j = paramInt5;
          if (j == -1) {
            break label880;
          }
          paramDrmInitData = parseEsdsFromParent(paramParsableByteArray, j);
          localObject2 = (String)paramDrmInitData.first;
          byte[] arrayOfByte = (byte[])paramDrmInitData.second;
          paramDrmInitData = (DrmInitData)localObject2;
          localObject1 = arrayOfByte;
          if ("audio/mp4a-latm".equals(localObject2))
          {
            paramDrmInitData = CodecSpecificDataUtil.parseAacAudioSpecificConfig(arrayOfByte);
            paramInt1 = ((Integer)paramDrmInitData.first).intValue();
            i = ((Integer)paramDrmInitData.second).intValue();
            localObject1 = arrayOfByte;
            paramDrmInitData = (DrmInitData)localObject2;
          }
        }
        label581:
        label587:
        label600:
        label865:
        label866:
        label871:
        label880:
        for (;;)
        {
          j = paramInt1;
          k = i;
          localObject2 = paramDrmInitData;
          for (;;)
          {
            paramInt5 += m;
            paramDrmInitData = (DrmInitData)localObject2;
            i = k;
            paramInt1 = j;
            break label173;
            paramParsableByteArray.skipBytes(8);
            j = 0;
            break;
            label383:
            if (j != 2) {
              break label865;
            }
            paramParsableByteArray.skipBytes(16);
            i = (int)Math.round(paramParsableByteArray.readDouble());
            j = paramParsableByteArray.readUnsignedIntToInt();
            paramParsableByteArray.skipBytes(20);
            break label73;
            paramDrmInitData = paramDrmInitData.copyWithSchemeType(((TrackEncryptionBox)((Pair)localObject1).second).schemeType);
            break label119;
            if (paramInt1 == Atom.TYPE_ec_3)
            {
              paramDrmInitData = "audio/eac3";
              break label159;
            }
            if (paramInt1 == Atom.TYPE_dtsc)
            {
              paramDrmInitData = "audio/vnd.dts";
              break label159;
            }
            if ((paramInt1 == Atom.TYPE_dtsh) || (paramInt1 == Atom.TYPE_dtsl))
            {
              paramDrmInitData = "audio/vnd.dts.hd";
              break label159;
            }
            if (paramInt1 == Atom.TYPE_dtse)
            {
              paramDrmInitData = "audio/vnd.dts.hd;profile=lbr";
              break label159;
            }
            if (paramInt1 == Atom.TYPE_samr)
            {
              paramDrmInitData = "audio/3gpp";
              break label159;
            }
            if (paramInt1 == Atom.TYPE_sawb)
            {
              paramDrmInitData = "audio/amr-wb";
              break label159;
            }
            if ((paramInt1 == Atom.TYPE_lpcm) || (paramInt1 == Atom.TYPE_sowt))
            {
              paramDrmInitData = "audio/raw";
              break label159;
            }
            if (paramInt1 == Atom.TYPE__mp3)
            {
              paramDrmInitData = "audio/mpeg";
              break label159;
            }
            if (paramInt1 != Atom.TYPE_alac) {
              break label159;
            }
            paramDrmInitData = "audio/alac";
            break label159;
            bool = false;
            break label201;
            j = findEsdsPosition(paramParsableByteArray, paramInt5, m);
            break label247;
            if (n == Atom.TYPE_dac3)
            {
              paramParsableByteArray.setPosition(paramInt5 + 8);
              paramStsdData.format = Ac3Util.parseAc3AnnexFFormat(paramParsableByteArray, Integer.toString(paramInt4), paramString, localDrmInitData);
              localObject2 = paramDrmInitData;
              k = i;
              j = paramInt1;
            }
            else if (n == Atom.TYPE_dec3)
            {
              paramParsableByteArray.setPosition(paramInt5 + 8);
              paramStsdData.format = Ac3Util.parseEAc3AnnexFFormat(paramParsableByteArray, Integer.toString(paramInt4), paramString, localDrmInitData);
              localObject2 = paramDrmInitData;
              k = i;
              j = paramInt1;
            }
            else if (n == Atom.TYPE_ddts)
            {
              paramStsdData.format = Format.createAudioSampleFormat(Integer.toString(paramInt4), paramDrmInitData, null, -1, -1, i, paramInt1, null, localDrmInitData, 0, paramString);
              localObject2 = paramDrmInitData;
              k = i;
              j = paramInt1;
            }
            else
            {
              localObject2 = paramDrmInitData;
              k = i;
              j = paramInt1;
              if (n == Atom.TYPE_alac)
              {
                localObject1 = new byte[m];
                paramParsableByteArray.setPosition(paramInt5);
                paramParsableByteArray.readBytes((byte[])localObject1, 0, m);
                localObject2 = paramDrmInitData;
                k = i;
                j = paramInt1;
              }
            }
          }
          if ((paramStsdData.format == null) && (paramDrmInitData != null))
          {
            if (!"audio/raw".equals(paramDrmInitData)) {
              break label866;
            }
            paramInt2 = 2;
            localObject2 = Integer.toString(paramInt4);
            if (localObject1 != null) {
              break label871;
            }
          }
          for (paramParsableByteArray = null;; paramParsableByteArray = Collections.singletonList(localObject1))
          {
            paramStsdData.format = Format.createAudioSampleFormat((String)localObject2, paramDrmInitData, null, -1, -1, i, paramInt1, paramInt2, paramParsableByteArray, localDrmInitData, 0, paramString);
            return;
            paramInt2 = -1;
            break;
          }
        }
        label801:
        break label135;
      }
      label893:
      j = k;
    }
  }
  
  static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    int i = paramInt1 + 8;
    Object localObject1 = null;
    Object localObject2 = null;
    int k = 0;
    int j = -1;
    if (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int m = paramParsableByteArray.readInt();
      int n = paramParsableByteArray.readInt();
      Object localObject3;
      Object localObject4;
      if (n == Atom.TYPE_frma)
      {
        localObject3 = Integer.valueOf(paramParsableByteArray.readInt());
        localObject4 = localObject2;
      }
      for (;;)
      {
        i += m;
        localObject1 = localObject3;
        localObject2 = localObject4;
        break;
        if (n == Atom.TYPE_schm)
        {
          paramParsableByteArray.skipBytes(4);
          localObject4 = paramParsableByteArray.readString(4);
          localObject3 = localObject1;
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (n == Atom.TYPE_schi)
          {
            k = m;
            j = i;
            localObject3 = localObject1;
            localObject4 = localObject2;
          }
        }
      }
    }
    if (("cenc".equals(localObject2)) || ("cbc1".equals(localObject2)) || ("cens".equals(localObject2)) || ("cbcs".equals(localObject2)))
    {
      if (localObject1 != null)
      {
        bool1 = true;
        Assertions.checkArgument(bool1, "frma atom is mandatory");
        if (j == -1) {
          break label259;
        }
        bool1 = true;
        label211:
        Assertions.checkArgument(bool1, "schi atom is mandatory");
        paramParsableByteArray = parseSchiFromParent(paramParsableByteArray, j, k, localObject2);
        if (paramParsableByteArray == null) {
          break label265;
        }
      }
      label259:
      label265:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assertions.checkArgument(bool1, "tenc atom is mandatory");
        return Pair.create(localObject1, paramParsableByteArray);
        bool1 = false;
        break;
        bool1 = false;
        break label211;
      }
    }
    return null;
  }
  
  private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom paramContainerAtom)
  {
    if (paramContainerAtom != null)
    {
      paramContainerAtom = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_elst);
      if (paramContainerAtom != null) {}
    }
    else
    {
      return Pair.create(null, null);
    }
    paramContainerAtom = paramContainerAtom.data;
    paramContainerAtom.setPosition(8);
    int j = Atom.parseFullAtomVersion(paramContainerAtom.readInt());
    int k = paramContainerAtom.readUnsignedIntToInt();
    long[] arrayOfLong1 = new long[k];
    long[] arrayOfLong2 = new long[k];
    int i = 0;
    while (i < k)
    {
      if (j == 1)
      {
        l = paramContainerAtom.readUnsignedLongToLong();
        arrayOfLong1[i] = l;
        if (j != 1) {
          break label125;
        }
      }
      label125:
      for (long l = paramContainerAtom.readLong();; l = paramContainerAtom.readInt())
      {
        arrayOfLong2[i] = l;
        if (paramContainerAtom.readShort() == 1) {
          break label135;
        }
        throw new IllegalArgumentException("Unsupported media rate.");
        l = paramContainerAtom.readUnsignedInt();
        break;
      }
      label135:
      paramContainerAtom.skipBytes(2);
      i += 1;
    }
    return Pair.create(arrayOfLong1, arrayOfLong2);
  }
  
  private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    Object localObject = null;
    paramParsableByteArray.setPosition(paramInt + 8 + 4);
    paramParsableByteArray.skipBytes(1);
    parseExpandableClassSize(paramParsableByteArray);
    paramParsableByteArray.skipBytes(2);
    paramInt = paramParsableByteArray.readUnsignedByte();
    if ((paramInt & 0x80) != 0) {
      paramParsableByteArray.skipBytes(2);
    }
    if ((paramInt & 0x40) != 0) {
      paramParsableByteArray.skipBytes(paramParsableByteArray.readUnsignedShort());
    }
    if ((paramInt & 0x20) != 0) {
      paramParsableByteArray.skipBytes(2);
    }
    paramParsableByteArray.skipBytes(1);
    parseExpandableClassSize(paramParsableByteArray);
    switch (paramParsableByteArray.readUnsignedByte())
    {
    default: 
    case 96: 
    case 97: 
    case 32: 
    case 33: 
    case 35: 
    case 107: 
    case 64: 
    case 102: 
    case 103: 
    case 104: 
    case 165: 
    case 166: 
      for (;;)
      {
        paramParsableByteArray.skipBytes(12);
        paramParsableByteArray.skipBytes(1);
        paramInt = parseExpandableClassSize(paramParsableByteArray);
        byte[] arrayOfByte = new byte[paramInt];
        paramParsableByteArray.readBytes(arrayOfByte, 0, paramInt);
        return Pair.create(localObject, arrayOfByte);
        localObject = "video/mpeg2";
        continue;
        localObject = "video/mp4v-es";
        continue;
        localObject = "video/avc";
        continue;
        localObject = "video/hevc";
        continue;
        return Pair.create("audio/mpeg", null);
        localObject = "audio/mp4a-latm";
        continue;
        localObject = "audio/ac3";
        continue;
        localObject = "audio/eac3";
      }
    case 169: 
    case 172: 
      return Pair.create("audio/vnd.dts", null);
    }
    return Pair.create("audio/vnd.dts.hd", null);
  }
  
  private static int parseExpandableClassSize(ParsableByteArray paramParsableByteArray)
  {
    int j = paramParsableByteArray.readUnsignedByte();
    for (int i = j & 0x7F; (j & 0x80) == 128; i = i << 7 | j & 0x7F) {
      j = paramParsableByteArray.readUnsignedByte();
    }
    return i;
  }
  
  private static int parseHdlr(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(16);
    int i = paramParsableByteArray.readInt();
    if (i == TYPE_soun) {
      return 1;
    }
    if (i == TYPE_vide) {
      return 2;
    }
    if ((i == TYPE_text) || (i == TYPE_sbtl) || (i == TYPE_subt) || (i == TYPE_clcp)) {
      return 3;
    }
    if (i == TYPE_meta) {
      return 4;
    }
    return -1;
  }
  
  private static Metadata parseIlst(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    paramParsableByteArray.skipBytes(8);
    ArrayList localArrayList = new ArrayList();
    while (paramParsableByteArray.getPosition() < paramInt)
    {
      Metadata.Entry localEntry = MetadataUtil.parseIlstElement(paramParsableByteArray);
      if (localEntry != null) {
        localArrayList.add(localEntry);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return new Metadata(localArrayList);
  }
  
  private static Pair<Long, String> parseMdhd(ParsableByteArray paramParsableByteArray)
  {
    int j = 8;
    paramParsableByteArray.setPosition(8);
    int k = Atom.parseFullAtomVersion(paramParsableByteArray.readInt());
    if (k == 0) {}
    for (int i = 8;; i = 16)
    {
      paramParsableByteArray.skipBytes(i);
      long l = paramParsableByteArray.readUnsignedInt();
      i = j;
      if (k == 0) {
        i = 4;
      }
      paramParsableByteArray.skipBytes(i);
      i = paramParsableByteArray.readUnsignedShort();
      return Pair.create(Long.valueOf(l), "" + (char)((i >> 10 & 0x1F) + 96) + (char)((i >> 5 & 0x1F) + 96) + (char)((i & 0x1F) + 96));
    }
  }
  
  private static Metadata parseMetaAtom(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    paramParsableByteArray.skipBytes(12);
    while (paramParsableByteArray.getPosition() < paramInt)
    {
      int i = paramParsableByteArray.getPosition();
      int j = paramParsableByteArray.readInt();
      if (paramParsableByteArray.readInt() == Atom.TYPE_ilst)
      {
        paramParsableByteArray.setPosition(i);
        return parseIlst(paramParsableByteArray, i + j);
      }
      paramParsableByteArray.skipBytes(j - 8);
    }
    return null;
  }
  
  private static long parseMvhd(ParsableByteArray paramParsableByteArray)
  {
    int i = 8;
    paramParsableByteArray.setPosition(8);
    if (Atom.parseFullAtomVersion(paramParsableByteArray.readInt()) == 0) {}
    for (;;)
    {
      paramParsableByteArray.skipBytes(i);
      return paramParsableByteArray.readUnsignedInt();
      i = 16;
    }
  }
  
  private static float parsePaspFromParent(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    paramParsableByteArray.setPosition(paramInt + 8);
    paramInt = paramParsableByteArray.readUnsignedIntToInt();
    int i = paramParsableByteArray.readUnsignedIntToInt();
    return paramInt / i;
  }
  
  private static byte[] parseProjFromParent(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 8;
    while (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int j = paramParsableByteArray.readInt();
      if (paramParsableByteArray.readInt() == Atom.TYPE_proj) {
        return Arrays.copyOfRange(paramParsableByteArray.data, i, j + i);
      }
      i += j;
    }
    return null;
  }
  
  private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2)
  {
    int i = paramParsableByteArray.getPosition();
    while (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int j = paramParsableByteArray.readInt();
      if (j > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Assertions.checkArgument(bool, "childAtomSize should be positive");
        if (paramParsableByteArray.readInt() != Atom.TYPE_sinf) {
          break;
        }
        Pair localPair = parseCommonEncryptionSinfFromParent(paramParsableByteArray, i, j);
        if (localPair == null) {
          break;
        }
        return localPair;
      }
      i += j;
    }
    return null;
  }
  
  private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject2 = null;
    boolean bool = true;
    int i = paramInt1 + 8;
    while (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int j = paramParsableByteArray.readInt();
      if (paramParsableByteArray.readInt() == Atom.TYPE_tenc)
      {
        paramInt1 = Atom.parseFullAtomVersion(paramParsableByteArray.readInt());
        paramParsableByteArray.skipBytes(1);
        if (paramInt1 == 0)
        {
          paramParsableByteArray.skipBytes(1);
          paramInt2 = 0;
          paramInt1 = 0;
          if (paramParsableByteArray.readUnsignedByte() != 1) {
            break label177;
          }
        }
        for (;;)
        {
          i = paramParsableByteArray.readUnsignedByte();
          byte[] arrayOfByte = new byte[16];
          paramParsableByteArray.readBytes(arrayOfByte, 0, arrayOfByte.length);
          Object localObject1 = localObject2;
          if (bool)
          {
            localObject1 = localObject2;
            if (i == 0)
            {
              j = paramParsableByteArray.readUnsignedByte();
              localObject1 = new byte[j];
              paramParsableByteArray.readBytes((byte[])localObject1, 0, j);
            }
          }
          return new TrackEncryptionBox(bool, paramString, i, arrayOfByte, paramInt1, paramInt2, (byte[])localObject1);
          paramInt2 = paramParsableByteArray.readUnsignedByte();
          paramInt1 = (paramInt2 & 0xF0) >> 4;
          paramInt2 &= 0xF;
          break;
          label177:
          bool = false;
        }
      }
      i += j;
    }
    return null;
  }
  
  public static TrackSampleTable parseStbl(Track paramTrack, Atom.ContainerAtom paramContainerAtom, GaplessInfoHolder paramGaplessInfoHolder)
    throws ParserException
  {
    Object localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
    if (localObject1 != null) {}
    int i11;
    for (Object localObject2 = new StszSampleSizeBox((Atom.LeafAtom)localObject1);; localObject2 = new Stz2SampleSizeBox((Atom.LeafAtom)localObject1))
    {
      i11 = ((SampleSizeBox)localObject2).getSampleCount();
      if (i11 != 0) {
        break;
      }
      return new TrackSampleTable(new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
      localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
      if (localObject1 == null) {
        throw new ParserException("Track has no sample table size information");
      }
    }
    boolean bool = false;
    Object localObject3 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stco);
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      bool = true;
      localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_co64);
    }
    Object localObject4 = ((Atom.LeafAtom)localObject1).data;
    Object localObject5 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
    ParsableByteArray localParsableByteArray = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
    localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stss);
    label205:
    ChunkIterator localChunkIterator;
    int i4;
    int i6;
    int n;
    int k;
    int i;
    int m;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((Atom.LeafAtom)localObject1).data;
      paramContainerAtom = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
      if (paramContainerAtom == null) {
        break label468;
      }
      localObject3 = paramContainerAtom.data;
      localChunkIterator = new ChunkIterator((ParsableByteArray)localObject5, (ParsableByteArray)localObject4, bool);
      localParsableByteArray.setPosition(12);
      i4 = localParsableByteArray.readUnsignedIntToInt() - 1;
      i6 = localParsableByteArray.readUnsignedIntToInt();
      n = localParsableByteArray.readUnsignedIntToInt();
      k = 0;
      if (localObject3 != null)
      {
        ((ParsableByteArray)localObject3).setPosition(12);
        k = ((ParsableByteArray)localObject3).readUnsignedIntToInt();
      }
      if (localObject1 == null) {
        break label2106;
      }
      ((ParsableByteArray)localObject1).setPosition(12);
      i = ((ParsableByteArray)localObject1).readUnsignedIntToInt();
      if (i <= 0) {
        break label474;
      }
      m = ((ParsableByteArray)localObject1).readUnsignedIntToInt() - 1;
      paramContainerAtom = (Atom.ContainerAtom)localObject1;
      j = i;
      i = m;
    }
    for (;;)
    {
      label312:
      if ((((SampleSizeBox)localObject2).isFixedSampleSize()) && ("audio/raw".equals(paramTrack.format.sampleMimeType)) && (i4 == 0) && (k == 0) && (j == 0)) {}
      int i1;
      Object localObject6;
      long l1;
      int i3;
      long l2;
      int i5;
      int i2;
      for (m = 1;; m = 0)
      {
        i1 = 0;
        if (m != 0) {
          break label993;
        }
        localObject4 = new long[i11];
        localObject1 = new int[i11];
        localObject5 = new long[i11];
        localObject6 = new int[i11];
        l1 = 0L;
        i3 = 0;
        l2 = 0L;
        i5 = 0;
        i2 = 0;
        m = j;
        i7 = 0;
        j = k;
        k = n;
        n = i1;
        i1 = i7;
        if (i5 >= i11) {
          break label753;
        }
        while (i3 == 0)
        {
          Assertions.checkState(localChunkIterator.moveNext());
          l1 = localChunkIterator.offset;
          i3 = localChunkIterator.numSamples;
        }
        localObject1 = null;
        break;
        label468:
        localObject3 = null;
        break label205;
        label474:
        m = -1;
        paramContainerAtom = null;
        j = i;
        i = m;
        break label312;
      }
      int i9 = i1;
      int i8 = j;
      int i7 = i2;
      if (localObject3 != null)
      {
        while ((i2 == 0) && (j > 0))
        {
          i2 = ((ParsableByteArray)localObject3).readUnsignedIntToInt();
          i1 = ((ParsableByteArray)localObject3).readInt();
          j -= 1;
        }
        i7 = i2 - 1;
        i8 = j;
        i9 = i1;
      }
      localObject4[i5] = l1;
      localObject1[i5] = ((SampleSizeBox)localObject2).readNextSampleSize();
      int i10 = n;
      if (localObject1[i5] > n) {
        i10 = localObject1[i5];
      }
      localObject5[i5] = (i9 + l2);
      if (paramContainerAtom == null)
      {
        j = 1;
        label616:
        localObject6[i5] = j;
        if (i5 != i) {
          break label2099;
        }
        localObject6[i5] = 1;
        j = m - 1;
        if (j <= 0) {
          break label2096;
        }
        i = paramContainerAtom.readUnsignedIntToInt() - 1;
      }
      for (;;)
      {
        l2 += k;
        m = i6 - 1;
        if ((m == 0) && (i4 > 0))
        {
          m = localParsableByteArray.readUnsignedIntToInt();
          k = localParsableByteArray.readInt();
          i4 -= 1;
        }
        for (;;)
        {
          l1 += localObject1[i5];
          i5 += 1;
          i6 = m;
          m = j;
          i3 -= 1;
          i1 = i9;
          j = i8;
          i2 = i7;
          n = i10;
          break;
          j = 0;
          break label616;
          label753:
          l1 = i1;
          if (i2 == 0)
          {
            bool = true;
            Assertions.checkArgument(bool);
            label771:
            if (j <= 0) {
              break label819;
            }
            if (((ParsableByteArray)localObject3).readUnsignedIntToInt() != 0) {
              break label813;
            }
          }
          label813:
          for (bool = true;; bool = false)
          {
            Assertions.checkArgument(bool);
            ((ParsableByteArray)localObject3).readInt();
            j -= 1;
            break label771;
            bool = false;
            break;
          }
          label819:
          if ((m != 0) || (i6 != 0) || (i3 != 0) || (i4 != 0)) {
            Log.w("AtomParsers", "Inconsistent stbl box for track " + paramTrack.id + ": remainingSynchronizationSamples " + m + ", remainingSamplesAtTimestampDelta " + i6 + ", remainingSamplesInChunk " + i3 + ", remainingTimestampDeltaChanges " + i4);
          }
          l1 = l2 + l1;
          paramContainerAtom = (Atom.ContainerAtom)localObject6;
          localObject3 = localObject5;
          k = n;
          localObject2 = localObject4;
          for (;;)
          {
            l2 = Util.scaleLargeTimestamp(l1, 1000000L, paramTrack.timescale);
            if ((paramTrack.editListDurations != null) && (!paramGaplessInfoHolder.hasGaplessInfo())) {
              break;
            }
            Util.scaleLargeTimestampsInPlace((long[])localObject3, 1000000L, paramTrack.timescale);
            return new TrackSampleTable((long[])localObject2, (int[])localObject1, k, (long[])localObject3, paramContainerAtom, l2);
            label993:
            paramContainerAtom = new long[localChunkIterator.length];
            localObject1 = new int[localChunkIterator.length];
            while (localChunkIterator.moveNext())
            {
              paramContainerAtom[localChunkIterator.index] = localChunkIterator.offset;
              localObject1[localChunkIterator.index] = localChunkIterator.numSamples;
            }
            localObject4 = FixedSampleSizeRechunker.rechunk(((SampleSizeBox)localObject2).readNextSampleSize(), paramContainerAtom, (int[])localObject1, n);
            localObject2 = ((FixedSampleSizeRechunker.Results)localObject4).offsets;
            localObject1 = ((FixedSampleSizeRechunker.Results)localObject4).sizes;
            k = ((FixedSampleSizeRechunker.Results)localObject4).maximumSize;
            localObject3 = ((FixedSampleSizeRechunker.Results)localObject4).timestamps;
            paramContainerAtom = ((FixedSampleSizeRechunker.Results)localObject4).flags;
            l1 = ((FixedSampleSizeRechunker.Results)localObject4).duration;
          }
          long l4;
          long l3;
          if ((paramTrack.editListDurations.length == 1) && (paramTrack.type == 1) && (localObject3.length >= 2))
          {
            l4 = paramTrack.editListMediaTimes[0];
            l3 = Util.scaleLargeTimestamp(paramTrack.editListDurations[0], paramTrack.timescale, paramTrack.movieTimescale) + l4;
            if ((localObject3[0] <= l4) && (l4 < localObject3[1]) && (localObject3[(localObject3.length - 1)] < l3) && (l3 <= l1))
            {
              l4 = Util.scaleLargeTimestamp(l4 - localObject3[0], paramTrack.format.sampleRate, paramTrack.timescale);
              l3 = Util.scaleLargeTimestamp(l1 - l3, paramTrack.format.sampleRate, paramTrack.timescale);
              if (((l4 != 0L) || (l3 != 0L)) && (l4 <= 2147483647L) && (l3 <= 2147483647L))
              {
                paramGaplessInfoHolder.encoderDelay = ((int)l4);
                paramGaplessInfoHolder.encoderPadding = ((int)l3);
                Util.scaleLargeTimestampsInPlace((long[])localObject3, 1000000L, paramTrack.timescale);
                return new TrackSampleTable((long[])localObject2, (int[])localObject1, k, (long[])localObject3, paramContainerAtom, l2);
              }
            }
          }
          if ((paramTrack.editListDurations.length == 1) && (paramTrack.editListDurations[0] == 0L))
          {
            l2 = paramTrack.editListMediaTimes[0];
            i = 0;
            while (i < localObject3.length)
            {
              localObject3[i] = Util.scaleLargeTimestamp(localObject3[i] - l2, 1000000L, paramTrack.timescale);
              i += 1;
            }
            return new TrackSampleTable((long[])localObject2, (int[])localObject1, k, (long[])localObject3, paramContainerAtom, Util.scaleLargeTimestamp(l1 - l2, 1000000L, paramTrack.timescale));
          }
          if (paramTrack.type == 1)
          {
            bool = true;
            n = 0;
            j = 0;
            m = 0;
            i = 0;
            label1446:
            if (n >= paramTrack.editListDurations.length) {
              break label1583;
            }
            l1 = paramTrack.editListMediaTimes[n];
            if (l1 == -1L) {
              break label2078;
            }
            l3 = Util.scaleLargeTimestamp(paramTrack.editListDurations[n], paramTrack.timescale, paramTrack.movieTimescale);
            i3 = Util.binarySearchCeil((long[])localObject3, l1, true, true);
            i1 = Util.binarySearchCeil((long[])localObject3, l3 + l1, bool, false);
            i2 = i + (i1 - i3);
            if (m == i3) {
              break label1578;
            }
            i = 1;
            label1538:
            m = j | i;
            i = i2;
          }
          for (j = i1;; j = i1)
          {
            n += 1;
            i1 = j;
            j = m;
            m = i1;
            break label1446;
            bool = false;
            break;
            label1578:
            i = 0;
            break label1538;
            label1583:
            if (i != i11)
            {
              m = 1;
              i2 = j | m;
              if (i2 == 0) {
                break label1892;
              }
              paramGaplessInfoHolder = new long[i];
              label1608:
              if (i2 == 0) {
                break label1898;
              }
              localObject4 = new int[i];
              label1618:
              if (i2 == 0) {
                break label1905;
              }
              j = 0;
              label1626:
              if (i2 == 0) {
                break label1912;
              }
            }
            label1892:
            label1898:
            label1905:
            label1912:
            for (localObject5 = new int[i];; localObject5 = paramContainerAtom)
            {
              localObject6 = new long[i];
              l1 = 0L;
              m = 0;
              n = 0;
              i = j;
              j = n;
              if (m >= paramTrack.editListDurations.length) {
                break label1944;
              }
              l3 = paramTrack.editListMediaTimes[m];
              l4 = paramTrack.editListDurations[m];
              if (l3 == -1L) {
                break label2075;
              }
              long l5 = Util.scaleLargeTimestamp(l4, paramTrack.timescale, paramTrack.movieTimescale);
              n = Util.binarySearchCeil((long[])localObject3, l3, true, true);
              i3 = Util.binarySearchCeil((long[])localObject3, l3 + l5, bool, false);
              if (i2 != 0)
              {
                i1 = i3 - n;
                System.arraycopy(localObject2, n, paramGaplessInfoHolder, j, i1);
                System.arraycopy(localObject1, n, localObject4, j, i1);
                System.arraycopy(paramContainerAtom, n, localObject5, j, i1);
              }
              i1 = i;
              i = j;
              for (j = i1; n < i3; j = i1)
              {
                l5 = Util.scaleLargeTimestamp(l1, 1000000L, paramTrack.movieTimescale);
                localObject6[i] = (Util.scaleLargeTimestamp(localObject3[n] - l3, 1000000L, paramTrack.timescale) + l5);
                i1 = j;
                if (i2 != 0)
                {
                  i1 = j;
                  if (localObject4[i] > j) {
                    i1 = localObject1[n];
                  }
                }
                n += 1;
                i += 1;
              }
              m = 0;
              break;
              paramGaplessInfoHolder = (GaplessInfoHolder)localObject2;
              break label1608;
              localObject4 = localObject1;
              break label1618;
              j = k;
              break label1626;
            }
            n = i;
            i = j;
            j = n;
            label1944:
            label2075:
            for (;;)
            {
              l1 += l4;
              m += 1;
              break;
              l1 = Util.scaleLargeTimestamp(l1, 1000000L, paramTrack.timescale);
              m = 0;
              j = 0;
              if ((j < localObject5.length) && (m == 0))
              {
                if ((localObject5[j] & 0x1) != 0) {}
                for (n = 1;; n = 0)
                {
                  m |= n;
                  j += 1;
                  break;
                }
              }
              if (m == 0)
              {
                Log.w("AtomParsers", "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
                Util.scaleLargeTimestampsInPlace((long[])localObject3, 1000000L, paramTrack.timescale);
                return new TrackSampleTable((long[])localObject2, (int[])localObject1, k, (long[])localObject3, paramContainerAtom, l2);
              }
              return new TrackSampleTable(paramGaplessInfoHolder, (int[])localObject4, i, (long[])localObject6, (int[])localObject5, l1);
            }
            label2078:
            i1 = m;
            m = j;
          }
        }
        label2096:
        continue;
        label2099:
        j = m;
      }
      label2106:
      i = -1;
      paramContainerAtom = (Atom.ContainerAtom)localObject1;
      j = 0;
    }
  }
  
  private static StsdData parseStsd(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, String paramString, DrmInitData paramDrmInitData, boolean paramBoolean)
    throws ParserException
  {
    paramParsableByteArray.setPosition(12);
    int j = paramParsableByteArray.readInt();
    StsdData localStsdData = new StsdData(j);
    int i = 0;
    if (i < j)
    {
      int k = paramParsableByteArray.getPosition();
      int m = paramParsableByteArray.readInt();
      boolean bool;
      label53:
      int n;
      if (m > 0)
      {
        bool = true;
        Assertions.checkArgument(bool, "childAtomSize should be positive");
        n = paramParsableByteArray.readInt();
        if ((n != Atom.TYPE_avc1) && (n != Atom.TYPE_avc3) && (n != Atom.TYPE_encv) && (n != Atom.TYPE_mp4v) && (n != Atom.TYPE_hvc1) && (n != Atom.TYPE_hev1) && (n != Atom.TYPE_s263) && (n != Atom.TYPE_vp08) && (n != Atom.TYPE_vp09)) {
          break label180;
        }
        parseVideoSampleEntry(paramParsableByteArray, n, k, m, paramInt1, paramInt2, paramDrmInitData, localStsdData, i);
      }
      for (;;)
      {
        paramParsableByteArray.setPosition(k + m);
        i += 1;
        break;
        bool = false;
        break label53;
        label180:
        if ((n == Atom.TYPE_mp4a) || (n == Atom.TYPE_enca) || (n == Atom.TYPE_ac_3) || (n == Atom.TYPE_ec_3) || (n == Atom.TYPE_dtsc) || (n == Atom.TYPE_dtse) || (n == Atom.TYPE_dtsh) || (n == Atom.TYPE_dtsl) || (n == Atom.TYPE_samr) || (n == Atom.TYPE_sawb) || (n == Atom.TYPE_lpcm) || (n == Atom.TYPE_sowt) || (n == Atom.TYPE__mp3) || (n == Atom.TYPE_alac)) {
          parseAudioSampleEntry(paramParsableByteArray, n, k, m, paramInt1, paramString, paramBoolean, paramDrmInitData, localStsdData, i);
        } else if ((n == Atom.TYPE_TTML) || (n == Atom.TYPE_tx3g) || (n == Atom.TYPE_wvtt) || (n == Atom.TYPE_stpp) || (n == Atom.TYPE_c608)) {
          parseTextSampleEntry(paramParsableByteArray, n, k, m, paramInt1, paramString, localStsdData);
        } else if (n == Atom.TYPE_camm) {
          localStsdData.format = Format.createSampleFormat(Integer.toString(paramInt1), "application/x-camera-motion", null, -1, null);
        }
      }
    }
    return localStsdData;
  }
  
  private static void parseTextSampleEntry(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, StsdData paramStsdData)
    throws ParserException
  {
    paramParsableByteArray.setPosition(paramInt2 + 8 + 8);
    Object localObject1 = null;
    long l = 9223372036854775807L;
    if (paramInt1 == Atom.TYPE_TTML) {
      paramParsableByteArray = "application/ttml+xml";
    }
    for (;;)
    {
      paramStsdData.format = Format.createTextSampleFormat(Integer.toString(paramInt4), paramParsableByteArray, null, -1, 0, paramString, -1, null, l, (List)localObject1);
      return;
      if (paramInt1 == Atom.TYPE_tx3g)
      {
        localObject1 = "application/x-quicktime-tx3g";
        paramInt1 = paramInt3 - 8 - 8;
        Object localObject2 = new byte[paramInt1];
        paramParsableByteArray.readBytes((byte[])localObject2, 0, paramInt1);
        localObject2 = Collections.singletonList(localObject2);
        paramParsableByteArray = (ParsableByteArray)localObject1;
        localObject1 = localObject2;
      }
      else if (paramInt1 == Atom.TYPE_wvtt)
      {
        paramParsableByteArray = "application/x-mp4-vtt";
      }
      else if (paramInt1 == Atom.TYPE_stpp)
      {
        paramParsableByteArray = "application/ttml+xml";
        l = 0L;
      }
      else
      {
        if (paramInt1 != Atom.TYPE_c608) {
          break;
        }
        paramParsableByteArray = "application/x-mp4-cea-608";
        paramStsdData.requiredSampleTransformation = 1;
      }
    }
    throw new IllegalStateException();
  }
  
  private static TkhdData parseTkhd(ParsableByteArray paramParsableByteArray)
  {
    int j = 8;
    paramParsableByteArray.setPosition(8);
    int i1 = Atom.parseFullAtomVersion(paramParsableByteArray.readInt());
    int i;
    int n;
    int m;
    label62:
    int k;
    long l1;
    if (i1 == 0)
    {
      i = 8;
      paramParsableByteArray.skipBytes(i);
      n = paramParsableByteArray.readInt();
      paramParsableByteArray.skipBytes(4);
      m = 1;
      int i2 = paramParsableByteArray.getPosition();
      i = j;
      if (i1 == 0) {
        i = 4;
      }
      j = 0;
      k = m;
      if (j < i)
      {
        if (paramParsableByteArray.data[(i2 + j)] == -1) {
          break label177;
        }
        k = 0;
      }
      if (k == 0) {
        break label184;
      }
      paramParsableByteArray.skipBytes(i);
      l1 = -9223372036854775807L;
      paramParsableByteArray.skipBytes(16);
      i = paramParsableByteArray.readInt();
      j = paramParsableByteArray.readInt();
      paramParsableByteArray.skipBytes(4);
      k = paramParsableByteArray.readInt();
      m = paramParsableByteArray.readInt();
      if ((i != 0) || (j != 65536) || (k != -65536) || (m != 0)) {
        break label223;
      }
      i = 90;
    }
    for (;;)
    {
      return new TkhdData(n, l1, i);
      i = 16;
      break;
      label177:
      j += 1;
      break label62;
      label184:
      if (i1 == 0) {}
      for (long l2 = paramParsableByteArray.readUnsignedInt();; l2 = paramParsableByteArray.readUnsignedLongToLong())
      {
        l1 = l2;
        if (l2 != 0L) {
          break;
        }
        l1 = -9223372036854775807L;
        break;
      }
      label223:
      if ((i == 0) && (j == -65536) && (k == 65536) && (m == 0)) {
        i = 270;
      } else if ((i == -65536) && (j == 0) && (k == 0) && (m == -65536)) {
        i = 180;
      } else {
        i = 0;
      }
    }
  }
  
  public static Track parseTrak(Atom.ContainerAtom paramContainerAtom, Atom.LeafAtom paramLeafAtom, long paramLong, DrmInitData paramDrmInitData, boolean paramBoolean1, boolean paramBoolean2)
    throws ParserException
  {
    Object localObject = paramContainerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
    int i = parseHdlr(((Atom.ContainerAtom)localObject).getLeafAtomOfType(Atom.TYPE_hdlr).data);
    if (i == -1) {
      return null;
    }
    TkhdData localTkhdData = parseTkhd(paramContainerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
    if (paramLong == -9223372036854775807L) {
      paramLong = localTkhdData.duration;
    }
    for (;;)
    {
      long l = parseMvhd(paramLeafAtom.data);
      if (paramLong == -9223372036854775807L) {}
      StsdData localStsdData;
      for (paramLong = -9223372036854775807L;; paramLong = Util.scaleLargeTimestamp(paramLong, 1000000L, l))
      {
        paramLeafAtom = ((Atom.ContainerAtom)localObject).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        localObject = parseMdhd(((Atom.ContainerAtom)localObject).getLeafAtomOfType(Atom.TYPE_mdhd).data);
        localStsdData = parseStsd(paramLeafAtom.getLeafAtomOfType(Atom.TYPE_stsd).data, localTkhdData.id, localTkhdData.rotationDegrees, (String)((Pair)localObject).second, paramDrmInitData, paramBoolean2);
        paramLeafAtom = null;
        paramDrmInitData = null;
        if (!paramBoolean1)
        {
          paramContainerAtom = parseEdts(paramContainerAtom.getContainerAtomOfType(Atom.TYPE_edts));
          paramLeafAtom = (long[])paramContainerAtom.first;
          paramDrmInitData = (long[])paramContainerAtom.second;
        }
        if (localStsdData.format != null) {
          break;
        }
        return null;
      }
      return new Track(localTkhdData.id, i, ((Long)((Pair)localObject).first).longValue(), l, paramLong, localStsdData.format, localStsdData.requiredSampleTransformation, localStsdData.trackEncryptionBoxes, localStsdData.nalUnitLengthFieldLength, paramLeafAtom, paramDrmInitData);
    }
  }
  
  public static Metadata parseUdta(Atom.LeafAtom paramLeafAtom, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      return null;
      paramLeafAtom = paramLeafAtom.data;
      paramLeafAtom.setPosition(8);
      while (paramLeafAtom.bytesLeft() >= 8)
      {
        int i = paramLeafAtom.getPosition();
        int j = paramLeafAtom.readInt();
        if (paramLeafAtom.readInt() == Atom.TYPE_meta)
        {
          paramLeafAtom.setPosition(i);
          return parseMetaAtom(paramLeafAtom, i + j);
        }
        paramLeafAtom.skipBytes(j - 8);
      }
    }
  }
  
  private static void parseVideoSampleEntry(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, DrmInitData paramDrmInitData, StsdData paramStsdData, int paramInt6)
    throws ParserException
  {
    paramParsableByteArray.setPosition(paramInt2 + 8 + 8);
    paramParsableByteArray.skipBytes(16);
    int k = paramParsableByteArray.readUnsignedShort();
    int m = paramParsableByteArray.readUnsignedShort();
    float f = 1.0F;
    paramParsableByteArray.skipBytes(50);
    int j = paramParsableByteArray.getPosition();
    Object localObject1;
    label100:
    int i;
    DrmInitData localDrmInitData;
    if (paramInt1 == Atom.TYPE_encv)
    {
      localObject1 = parseSampleEntryEncryptionData(paramParsableByteArray, paramInt2, paramInt3);
      if (localObject1 != null)
      {
        paramInt1 = ((Integer)((Pair)localObject1).first).intValue();
        if (paramDrmInitData == null)
        {
          paramDrmInitData = null;
          paramStsdData.trackEncryptionBoxes[paramInt6] = ((TrackEncryptionBox)((Pair)localObject1).second);
          paramParsableByteArray.setPosition(j);
          i = paramInt1;
          localDrmInitData = paramDrmInitData;
        }
      }
    }
    for (;;)
    {
      localObject1 = null;
      paramDrmInitData = null;
      byte[] arrayOfByte = null;
      paramInt6 = -1;
      paramInt1 = 0;
      int i1;
      int n;
      if (j - paramInt2 < paramInt3)
      {
        paramParsableByteArray.setPosition(j);
        i1 = paramParsableByteArray.getPosition();
        n = paramParsableByteArray.readInt();
        if ((n != 0) || (paramParsableByteArray.getPosition() - paramInt2 != paramInt3)) {}
      }
      else
      {
        if (paramDrmInitData != null) {
          break label647;
        }
        return;
        paramDrmInitData = paramDrmInitData.copyWithSchemeType(((TrackEncryptionBox)((Pair)localObject1).second).schemeType);
        break;
      }
      boolean bool;
      label203:
      int i2;
      label232:
      Object localObject2;
      if (n > 0)
      {
        bool = true;
        Assertions.checkArgument(bool, "childAtomSize should be positive");
        i2 = paramParsableByteArray.readInt();
        if (i2 != Atom.TYPE_avcC) {
          break label307;
        }
        if (paramDrmInitData != null) {
          break label301;
        }
        bool = true;
        Assertions.checkState(bool);
        paramDrmInitData = "video/avc";
        paramParsableByteArray.setPosition(i1 + 8);
        localObject2 = AvcConfig.parse(paramParsableByteArray);
        localObject1 = ((AvcConfig)localObject2).initializationData;
        paramStsdData.nalUnitLengthFieldLength = ((AvcConfig)localObject2).nalUnitLengthFieldLength;
        if (paramInt1 == 0) {
          f = ((AvcConfig)localObject2).pixelWidthAspectRatio;
        }
      }
      for (;;)
      {
        j += n;
        break;
        bool = false;
        break label203;
        label301:
        bool = false;
        break label232;
        label307:
        if (i2 == Atom.TYPE_hvcC)
        {
          if (paramDrmInitData == null) {}
          for (bool = true;; bool = false)
          {
            Assertions.checkState(bool);
            paramDrmInitData = "video/hevc";
            paramParsableByteArray.setPosition(i1 + 8);
            localObject2 = HevcConfig.parse(paramParsableByteArray);
            localObject1 = ((HevcConfig)localObject2).initializationData;
            paramStsdData.nalUnitLengthFieldLength = ((HevcConfig)localObject2).nalUnitLengthFieldLength;
            break;
          }
        }
        if (i2 == Atom.TYPE_vpcC)
        {
          if (paramDrmInitData == null)
          {
            bool = true;
            label390:
            Assertions.checkState(bool);
            if (i != Atom.TYPE_vp08) {
              break label417;
            }
          }
          label417:
          for (paramDrmInitData = "video/x-vnd.on2.vp8";; paramDrmInitData = "video/x-vnd.on2.vp9")
          {
            break;
            bool = false;
            break label390;
          }
        }
        if (i2 == Atom.TYPE_d263)
        {
          if (paramDrmInitData == null) {}
          for (bool = true;; bool = false)
          {
            Assertions.checkState(bool);
            paramDrmInitData = "video/3gpp";
            break;
          }
        }
        if (i2 == Atom.TYPE_esds)
        {
          if (paramDrmInitData == null) {}
          for (bool = true;; bool = false)
          {
            Assertions.checkState(bool);
            localObject1 = parseEsdsFromParent(paramParsableByteArray, i1);
            paramDrmInitData = (String)((Pair)localObject1).first;
            localObject1 = Collections.singletonList(((Pair)localObject1).second);
            break;
          }
        }
        if (i2 == Atom.TYPE_pasp)
        {
          f = parsePaspFromParent(paramParsableByteArray, i1);
          paramInt1 = 1;
        }
        else if (i2 == Atom.TYPE_sv3d)
        {
          arrayOfByte = parseProjFromParent(paramParsableByteArray, i1, n);
        }
        else
        {
          if (i2 == Atom.TYPE_st3d)
          {
            i1 = paramParsableByteArray.readUnsignedByte();
            paramParsableByteArray.skipBytes(3);
            if (i1 != 0) {}
          }
          switch (paramParsableByteArray.readUnsignedByte())
          {
          default: 
            break;
          case 0: 
            paramInt6 = 0;
            break;
          case 1: 
            paramInt6 = 1;
            break;
          case 2: 
            paramInt6 = 2;
            break;
          case 3: 
            paramInt6 = 3;
          }
        }
      }
      label647:
      paramStsdData.format = Format.createVideoSampleFormat(Integer.toString(paramInt4), paramDrmInitData, null, -1, -1, k, m, -1.0F, (List)localObject1, paramInt5, f, arrayOfByte, paramInt6, null, localDrmInitData);
      return;
      break label100;
      localDrmInitData = paramDrmInitData;
      i = paramInt1;
    }
  }
  
  static final class ChunkIterator
  {
    private final ParsableByteArray chunkOffsets;
    private final boolean chunkOffsetsAreLongs;
    public int index;
    public final int length;
    private int nextSamplesPerChunkChangeIndex;
    public int numSamples;
    public long offset;
    private int remainingSamplesPerChunkChanges;
    private final ParsableByteArray stsc;
    
    public ChunkIterator(ParsableByteArray paramParsableByteArray1, ParsableByteArray paramParsableByteArray2, boolean paramBoolean)
    {
      this.stsc = paramParsableByteArray1;
      this.chunkOffsets = paramParsableByteArray2;
      this.chunkOffsetsAreLongs = paramBoolean;
      paramParsableByteArray2.setPosition(12);
      this.length = paramParsableByteArray2.readUnsignedIntToInt();
      paramParsableByteArray1.setPosition(12);
      this.remainingSamplesPerChunkChanges = paramParsableByteArray1.readUnsignedIntToInt();
      if (paramParsableByteArray1.readInt() == 1) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        Assertions.checkState(paramBoolean, "first_chunk must be 1");
        this.index = -1;
        return;
      }
    }
    
    public boolean moveNext()
    {
      int i = this.index + 1;
      this.index = i;
      if (i == this.length) {
        return false;
      }
      long l;
      if (this.chunkOffsetsAreLongs)
      {
        l = this.chunkOffsets.readUnsignedLongToLong();
        this.offset = l;
        if (this.index == this.nextSamplesPerChunkChangeIndex)
        {
          this.numSamples = this.stsc.readUnsignedIntToInt();
          this.stsc.skipBytes(4);
          i = this.remainingSamplesPerChunkChanges - 1;
          this.remainingSamplesPerChunkChanges = i;
          if (i <= 0) {
            break label116;
          }
        }
      }
      label116:
      for (i = this.stsc.readUnsignedIntToInt() - 1;; i = -1)
      {
        this.nextSamplesPerChunkChangeIndex = i;
        return true;
        l = this.chunkOffsets.readUnsignedInt();
        break;
      }
    }
  }
  
  static abstract interface SampleSizeBox
  {
    public abstract int getSampleCount();
    
    public abstract boolean isFixedSampleSize();
    
    public abstract int readNextSampleSize();
  }
  
  static final class StsdData
  {
    public static final int STSD_HEADER_SIZE = 8;
    public Format format;
    public int nalUnitLengthFieldLength;
    public int requiredSampleTransformation;
    public final TrackEncryptionBox[] trackEncryptionBoxes;
    
    public StsdData(int paramInt)
    {
      this.trackEncryptionBoxes = new TrackEncryptionBox[paramInt];
      this.requiredSampleTransformation = 0;
    }
  }
  
  static final class StszSampleSizeBox
    implements AtomParsers.SampleSizeBox
  {
    private final ParsableByteArray data;
    private final int fixedSampleSize;
    private final int sampleCount;
    
    public StszSampleSizeBox(Atom.LeafAtom paramLeafAtom)
    {
      this.data = paramLeafAtom.data;
      this.data.setPosition(12);
      this.fixedSampleSize = this.data.readUnsignedIntToInt();
      this.sampleCount = this.data.readUnsignedIntToInt();
    }
    
    public int getSampleCount()
    {
      return this.sampleCount;
    }
    
    public boolean isFixedSampleSize()
    {
      return this.fixedSampleSize != 0;
    }
    
    public int readNextSampleSize()
    {
      if (this.fixedSampleSize == 0) {
        return this.data.readUnsignedIntToInt();
      }
      return this.fixedSampleSize;
    }
  }
  
  static final class Stz2SampleSizeBox
    implements AtomParsers.SampleSizeBox
  {
    private int currentByte;
    private final ParsableByteArray data;
    private final int fieldSize;
    private final int sampleCount;
    private int sampleIndex;
    
    public Stz2SampleSizeBox(Atom.LeafAtom paramLeafAtom)
    {
      this.data = paramLeafAtom.data;
      this.data.setPosition(12);
      this.fieldSize = (this.data.readUnsignedIntToInt() & 0xFF);
      this.sampleCount = this.data.readUnsignedIntToInt();
    }
    
    public int getSampleCount()
    {
      return this.sampleCount;
    }
    
    public boolean isFixedSampleSize()
    {
      return false;
    }
    
    public int readNextSampleSize()
    {
      if (this.fieldSize == 8) {
        return this.data.readUnsignedByte();
      }
      if (this.fieldSize == 16) {
        return this.data.readUnsignedShort();
      }
      int i = this.sampleIndex;
      this.sampleIndex = (i + 1);
      if (i % 2 == 0)
      {
        this.currentByte = this.data.readUnsignedByte();
        return (this.currentByte & 0xF0) >> 4;
      }
      return this.currentByte & 0xF;
    }
  }
  
  static final class TkhdData
  {
    private final long duration;
    private final int id;
    private final int rotationDegrees;
    
    public TkhdData(int paramInt1, long paramLong, int paramInt2)
    {
      this.id = paramInt1;
      this.duration = paramLong;
      this.rotationDegrees = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.AtomParsers
 * JD-Core Version:    0.7.0.1
 */