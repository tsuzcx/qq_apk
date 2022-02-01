package com.google.android.exoplayer2.extractor.mp4;

import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.cea.CeaUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class FragmentedMp4Extractor
  implements Extractor
{
  private static final Format EMSG_FORMAT = Format.createSampleFormat(null, "application/x-emsg", 9223372036854775807L);
  public static final ExtractorsFactory FACTORY = new FragmentedMp4Extractor.1();
  public static final int FLAG_ENABLE_EMSG_TRACK = 4;
  private static final int FLAG_SIDELOADED = 8;
  public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
  public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
  public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
  private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE;
  private static final int SAMPLE_GROUP_TYPE_seig = Util.getIntegerCodeForString("seig");
  private static final int STATE_READING_ATOM_HEADER = 0;
  private static final int STATE_READING_ATOM_PAYLOAD = 1;
  private static final int STATE_READING_ENCRYPTION_DATA = 2;
  private static final int STATE_READING_SAMPLE_CONTINUE = 4;
  private static final int STATE_READING_SAMPLE_START = 3;
  private static final String TAG = "FragmentedMp4Extractor";
  @Nullable
  private final TrackOutput additionalEmsgTrackOutput;
  private ParsableByteArray atomData;
  private final ParsableByteArray atomHeader;
  private int atomHeaderBytesRead;
  private long atomSize;
  private int atomType;
  private TrackOutput[] cea608TrackOutputs;
  private final List<Format> closedCaptionFormats;
  private final Stack<Atom.ContainerAtom> containerAtoms;
  private TrackBundle currentTrackBundle;
  private final ParsableByteArray defaultInitializationVector;
  private long durationUs;
  private TrackOutput[] emsgTrackOutputs;
  private final ParsableByteArray encryptionSignalByte;
  private long endOfMdatPosition;
  private final byte[] extendedTypeScratch;
  private ExtractorOutput extractorOutput;
  private final int flags;
  private boolean haveOutputSeekMap;
  private final ParsableByteArray nalBuffer;
  private final ParsableByteArray nalPrefix;
  private final ParsableByteArray nalStartCode;
  private int parserState;
  private int pendingMetadataSampleBytes;
  private final ArrayDeque<MetadataSampleInfo> pendingMetadataSampleInfos;
  private boolean processSeiNalUnitPayload;
  private int sampleBytesWritten;
  private int sampleCurrentNalBytesRemaining;
  private int sampleSize;
  private long segmentIndexEarliestPresentationTimeUs;
  private final DrmInitData sideloadedDrmInitData;
  private final Track sideloadedTrack;
  private final TimestampAdjuster timestampAdjuster;
  private final SparseArray<TrackBundle> trackBundles;
  
  static
  {
    PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
  }
  
  public FragmentedMp4Extractor()
  {
    this(0);
  }
  
  public FragmentedMp4Extractor(int paramInt)
  {
    this(paramInt, null);
  }
  
  public FragmentedMp4Extractor(int paramInt, TimestampAdjuster paramTimestampAdjuster)
  {
    this(paramInt, paramTimestampAdjuster, null, null);
  }
  
  public FragmentedMp4Extractor(int paramInt, TimestampAdjuster paramTimestampAdjuster, Track paramTrack, DrmInitData paramDrmInitData)
  {
    this(paramInt, paramTimestampAdjuster, paramTrack, paramDrmInitData, Collections.emptyList());
  }
  
  public FragmentedMp4Extractor(int paramInt, TimestampAdjuster paramTimestampAdjuster, Track paramTrack, DrmInitData paramDrmInitData, List<Format> paramList)
  {
    this(paramInt, paramTimestampAdjuster, paramTrack, paramDrmInitData, paramList, null);
  }
  
  public FragmentedMp4Extractor(int paramInt, TimestampAdjuster paramTimestampAdjuster, Track paramTrack, DrmInitData paramDrmInitData, List<Format> paramList, @Nullable TrackOutput paramTrackOutput)
  {
    if (paramTrack != null) {}
    for (int i = 8;; i = 0)
    {
      this.flags = (i | paramInt);
      this.timestampAdjuster = paramTimestampAdjuster;
      this.sideloadedTrack = paramTrack;
      this.sideloadedDrmInitData = paramDrmInitData;
      this.closedCaptionFormats = Collections.unmodifiableList(paramList);
      this.additionalEmsgTrackOutput = paramTrackOutput;
      this.atomHeader = new ParsableByteArray(16);
      this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
      this.nalPrefix = new ParsableByteArray(5);
      this.nalBuffer = new ParsableByteArray();
      this.encryptionSignalByte = new ParsableByteArray(1);
      this.defaultInitializationVector = new ParsableByteArray();
      this.extendedTypeScratch = new byte[16];
      this.containerAtoms = new Stack();
      this.pendingMetadataSampleInfos = new ArrayDeque();
      this.trackBundles = new SparseArray();
      this.durationUs = -9223372036854775807L;
      this.segmentIndexEarliestPresentationTimeUs = -9223372036854775807L;
      enterReadingAtomHeaderState();
      return;
    }
  }
  
  private int appendSampleEncryptionData(TrackBundle paramTrackBundle)
  {
    TrackFragment localTrackFragment = paramTrackBundle.fragment;
    int i = localTrackFragment.header.sampleDescriptionIndex;
    Object localObject2;
    label55:
    int k;
    if (localTrackFragment.trackEncryptionBox != null)
    {
      localObject1 = localTrackFragment.trackEncryptionBox;
      if (((TrackEncryptionBox)localObject1).initializationVectorSize == 0) {
        break label148;
      }
      localObject2 = localTrackFragment.sampleEncryptionData;
      i = ((TrackEncryptionBox)localObject1).initializationVectorSize;
      localObject1 = localObject2;
      k = localTrackFragment.sampleHasSubsampleEncryptionTable[paramTrackBundle.currentSampleIndex];
      localObject2 = this.encryptionSignalByte.data;
      if (k == 0) {
        break label180;
      }
    }
    label148:
    label180:
    for (int j = 128;; j = 0)
    {
      localObject2[0] = ((byte)(j | i));
      this.encryptionSignalByte.setPosition(0);
      paramTrackBundle = paramTrackBundle.output;
      paramTrackBundle.sampleData(this.encryptionSignalByte, 1);
      paramTrackBundle.sampleData((ParsableByteArray)localObject1, i);
      if (k != 0) {
        break label185;
      }
      return i + 1;
      localObject1 = paramTrackBundle.track.getSampleDescriptionEncryptionBox(i);
      break;
      localObject2 = ((TrackEncryptionBox)localObject1).defaultInitializationVector;
      this.defaultInitializationVector.reset((byte[])localObject2, localObject2.length);
      localObject1 = this.defaultInitializationVector;
      i = localObject2.length;
      break label55;
    }
    label185:
    Object localObject1 = localTrackFragment.sampleEncryptionData;
    j = ((ParsableByteArray)localObject1).readUnsignedShort();
    ((ParsableByteArray)localObject1).skipBytes(-2);
    j = j * 6 + 2;
    paramTrackBundle.sampleData((ParsableByteArray)localObject1, j);
    return i + 1 + j;
  }
  
  private void enterReadingAtomHeaderState()
  {
    this.parserState = 0;
    this.atomHeaderBytesRead = 0;
  }
  
  private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> paramList)
  {
    int j = paramList.size();
    int i = 0;
    Object localObject2 = null;
    if (i < j)
    {
      Object localObject3 = (Atom.LeafAtom)paramList.get(i);
      Object localObject1 = localObject2;
      if (((Atom.LeafAtom)localObject3).type == Atom.TYPE_pssh)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((Atom.LeafAtom)localObject3).data.data;
        localObject3 = PsshAtomUtil.parseUuid((byte[])localObject2);
        if (localObject3 != null) {
          break label100;
        }
        Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        label100:
        ((ArrayList)localObject1).add(new DrmInitData.SchemeData((UUID)localObject3, "video/mp4", (byte[])localObject2));
      }
    }
    if (localObject2 == null) {
      return null;
    }
    return new DrmInitData((List)localObject2);
  }
  
  private static TrackBundle getNextFragmentRun(SparseArray<TrackBundle> paramSparseArray)
  {
    Object localObject = null;
    long l1 = 9223372036854775807L;
    int j = paramSparseArray.size();
    int i = 0;
    TrackBundle localTrackBundle;
    if (i < j)
    {
      localTrackBundle = (TrackBundle)paramSparseArray.valueAt(i);
      if (localTrackBundle.currentTrackRunIndex != localTrackBundle.fragment.trunCount) {}
    }
    for (;;)
    {
      i += 1;
      break;
      long l2 = localTrackBundle.fragment.trunDataPosition[localTrackBundle.currentTrackRunIndex];
      if (l2 < l1)
      {
        localObject = localTrackBundle;
        l1 = l2;
        continue;
        return localObject;
      }
    }
  }
  
  private void maybeInitExtraTracks()
  {
    int k = 0;
    Object localObject;
    int i;
    if (this.emsgTrackOutputs == null)
    {
      this.emsgTrackOutputs = new TrackOutput[2];
      if (this.additionalEmsgTrackOutput == null) {
        break label222;
      }
      localObject = this.emsgTrackOutputs;
      i = 1;
      localObject[0] = this.additionalEmsgTrackOutput;
    }
    for (;;)
    {
      int j = i;
      if ((this.flags & 0x4) != 0)
      {
        this.emsgTrackOutputs[i] = this.extractorOutput.track(this.trackBundles.size(), 4);
        j = i + 1;
      }
      this.emsgTrackOutputs = ((TrackOutput[])Arrays.copyOf(this.emsgTrackOutputs, j));
      localObject = this.emsgTrackOutputs;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localObject[i].format(EMSG_FORMAT);
        i += 1;
      }
      if (this.cea608TrackOutputs == null)
      {
        this.cea608TrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
        i = k;
        while (i < this.cea608TrackOutputs.length)
        {
          localObject = this.extractorOutput.track(this.trackBundles.size() + 1 + i, 3);
          ((TrackOutput)localObject).format((Format)this.closedCaptionFormats.get(i));
          this.cea608TrackOutputs[i] = localObject;
          i += 1;
        }
      }
      return;
      label222:
      i = 0;
    }
  }
  
  private void onContainerAtomRead(Atom.ContainerAtom paramContainerAtom)
    throws ParserException
  {
    if (paramContainerAtom.type == Atom.TYPE_moov) {
      onMoovContainerAtomRead(paramContainerAtom);
    }
    do
    {
      return;
      if (paramContainerAtom.type == Atom.TYPE_moof)
      {
        onMoofContainerAtomRead(paramContainerAtom);
        return;
      }
    } while (this.containerAtoms.isEmpty());
    ((Atom.ContainerAtom)this.containerAtoms.peek()).add(paramContainerAtom);
  }
  
  private void onEmsgLeafAtomRead(ParsableByteArray paramParsableByteArray)
  {
    if ((this.emsgTrackOutputs == null) || (this.emsgTrackOutputs.length == 0)) {}
    int j;
    long l;
    for (;;)
    {
      return;
      paramParsableByteArray.setPosition(12);
      j = paramParsableByteArray.bytesLeft();
      paramParsableByteArray.readNullTerminatedString();
      paramParsableByteArray.readNullTerminatedString();
      l = paramParsableByteArray.readUnsignedInt();
      l = Util.scaleLargeTimestamp(paramParsableByteArray.readUnsignedInt(), 1000000L, l);
      TrackOutput[] arrayOfTrackOutput = this.emsgTrackOutputs;
      int k = arrayOfTrackOutput.length;
      int i = 0;
      while (i < k)
      {
        TrackOutput localTrackOutput = arrayOfTrackOutput[i];
        paramParsableByteArray.setPosition(12);
        localTrackOutput.sampleData(paramParsableByteArray, j);
        i += 1;
      }
      if (this.segmentIndexEarliestPresentationTimeUs == -9223372036854775807L) {
        break;
      }
      paramParsableByteArray = this.emsgTrackOutputs;
      k = paramParsableByteArray.length;
      i = 0;
      while (i < k)
      {
        paramParsableByteArray[i].sampleMetadata(this.segmentIndexEarliestPresentationTimeUs + l, 1, j, 0, null);
        i += 1;
      }
    }
    this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(l, j));
    this.pendingMetadataSampleBytes += j;
  }
  
  private void onLeafAtomRead(Atom.LeafAtom paramLeafAtom, long paramLong)
    throws ParserException
  {
    if (!this.containerAtoms.isEmpty()) {
      ((Atom.ContainerAtom)this.containerAtoms.peek()).add(paramLeafAtom);
    }
    do
    {
      return;
      if (paramLeafAtom.type == Atom.TYPE_sidx)
      {
        paramLeafAtom = parseSidx(paramLeafAtom.data, paramLong);
        this.segmentIndexEarliestPresentationTimeUs = ((Long)paramLeafAtom.first).longValue();
        this.extractorOutput.seekMap((SeekMap)paramLeafAtom.second);
        this.haveOutputSeekMap = true;
        return;
      }
    } while (paramLeafAtom.type != Atom.TYPE_emsg);
    onEmsgLeafAtomRead(paramLeafAtom.data);
  }
  
  private void onMoofContainerAtomRead(Atom.ContainerAtom paramContainerAtom)
    throws ParserException
  {
    parseMoof(paramContainerAtom, this.trackBundles, this.flags, this.extendedTypeScratch);
    if (this.sideloadedDrmInitData != null) {}
    for (paramContainerAtom = null; paramContainerAtom != null; paramContainerAtom = getDrmInitDataFromAtoms(paramContainerAtom.leafChildren))
    {
      int j = this.trackBundles.size();
      int i = 0;
      while (i < j)
      {
        ((TrackBundle)this.trackBundles.valueAt(i)).updateDrmInitData(paramContainerAtom);
        i += 1;
      }
    }
  }
  
  private void onMoovContainerAtomRead(Atom.ContainerAtom paramContainerAtom)
    throws ParserException
  {
    boolean bool2 = true;
    int k = 0;
    int j = 0;
    Object localObject1;
    label39:
    SparseArray localSparseArray;
    long l;
    label76:
    Object localObject3;
    if (this.sideloadedTrack == null)
    {
      bool1 = true;
      Assertions.checkState(bool1, "Unexpected moov box.");
      if (this.sideloadedDrmInitData == null) {
        break label153;
      }
      localObject1 = this.sideloadedDrmInitData;
      localObject2 = paramContainerAtom.getContainerAtomOfType(Atom.TYPE_mvex);
      localSparseArray = new SparseArray();
      l = -9223372036854775807L;
      m = ((Atom.ContainerAtom)localObject2).leafChildren.size();
      i = 0;
      if (i >= m) {
        break label189;
      }
      localObject3 = (Atom.LeafAtom)((Atom.ContainerAtom)localObject2).leafChildren.get(i);
      if (((Atom.LeafAtom)localObject3).type != Atom.TYPE_trex) {
        break label165;
      }
      localObject3 = parseTrex(((Atom.LeafAtom)localObject3).data);
      localSparseArray.put(((Integer)((Pair)localObject3).first).intValue(), ((Pair)localObject3).second);
    }
    for (;;)
    {
      i += 1;
      break label76;
      bool1 = false;
      break;
      label153:
      localObject1 = getDrmInitDataFromAtoms(paramContainerAtom.leafChildren);
      break label39;
      label165:
      if (((Atom.LeafAtom)localObject3).type == Atom.TYPE_mehd) {
        l = parseMehd(((Atom.LeafAtom)localObject3).data);
      }
    }
    label189:
    Object localObject2 = new SparseArray();
    int m = paramContainerAtom.containerChildren.size();
    int i = 0;
    if (i < m)
    {
      localObject3 = (Atom.ContainerAtom)paramContainerAtom.containerChildren.get(i);
      Atom.LeafAtom localLeafAtom;
      if (((Atom.ContainerAtom)localObject3).type == Atom.TYPE_trak)
      {
        localLeafAtom = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_mvhd);
        if ((this.flags & 0x10) == 0) {
          break label305;
        }
      }
      label305:
      for (bool1 = true;; bool1 = false)
      {
        localObject3 = AtomParsers.parseTrak((Atom.ContainerAtom)localObject3, localLeafAtom, l, (DrmInitData)localObject1, bool1, false);
        if (localObject3 != null) {
          ((SparseArray)localObject2).put(((Track)localObject3).id, localObject3);
        }
        i += 1;
        break;
      }
    }
    m = ((SparseArray)localObject2).size();
    if (this.trackBundles.size() == 0)
    {
      i = j;
      while (i < m)
      {
        paramContainerAtom = (Track)((SparseArray)localObject2).valueAt(i);
        localObject1 = new TrackBundle(this.extractorOutput.track(i, paramContainerAtom.type));
        ((TrackBundle)localObject1).init(paramContainerAtom, (DefaultSampleValues)localSparseArray.get(paramContainerAtom.id));
        this.trackBundles.put(paramContainerAtom.id, localObject1);
        this.durationUs = Math.max(this.durationUs, paramContainerAtom.durationUs);
        i += 1;
      }
      maybeInitExtraTracks();
      this.extractorOutput.endTracks();
      return;
    }
    if (this.trackBundles.size() == m) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkState(bool1);
      i = k;
      while (i < m)
      {
        paramContainerAtom = (Track)((SparseArray)localObject2).valueAt(i);
        ((TrackBundle)this.trackBundles.get(paramContainerAtom.id)).init(paramContainerAtom, (DefaultSampleValues)localSparseArray.get(paramContainerAtom.id));
        i += 1;
      }
      break;
    }
  }
  
  private void outputPendingMetadataSamples(long paramLong)
  {
    if (!this.pendingMetadataSampleInfos.isEmpty())
    {
      MetadataSampleInfo localMetadataSampleInfo = (MetadataSampleInfo)this.pendingMetadataSampleInfos.removeFirst();
      this.pendingMetadataSampleBytes -= localMetadataSampleInfo.size;
      TrackOutput[] arrayOfTrackOutput = this.emsgTrackOutputs;
      int j = arrayOfTrackOutput.length;
      int i = 0;
      while (i < j)
      {
        arrayOfTrackOutput[i].sampleMetadata(localMetadataSampleInfo.presentationTimeDeltaUs + paramLong, 1, localMetadataSampleInfo.size, this.pendingMetadataSampleBytes, null);
        i += 1;
      }
    }
  }
  
  private static long parseMehd(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(8);
    if (Atom.parseFullAtomVersion(paramParsableByteArray.readInt()) == 0) {
      return paramParsableByteArray.readUnsignedInt();
    }
    return paramParsableByteArray.readUnsignedLongToLong();
  }
  
  private static void parseMoof(Atom.ContainerAtom paramContainerAtom, SparseArray<TrackBundle> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
    throws ParserException
  {
    int j = paramContainerAtom.containerChildren.size();
    int i = 0;
    while (i < j)
    {
      Atom.ContainerAtom localContainerAtom = (Atom.ContainerAtom)paramContainerAtom.containerChildren.get(i);
      if (localContainerAtom.type == Atom.TYPE_traf) {
        parseTraf(localContainerAtom, paramSparseArray, paramInt, paramArrayOfByte);
      }
      i += 1;
    }
  }
  
  private static void parseSaio(ParsableByteArray paramParsableByteArray, TrackFragment paramTrackFragment)
    throws ParserException
  {
    paramParsableByteArray.setPosition(8);
    int i = paramParsableByteArray.readInt();
    if ((Atom.parseFullAtomFlags(i) & 0x1) == 1) {
      paramParsableByteArray.skipBytes(8);
    }
    int j = paramParsableByteArray.readUnsignedIntToInt();
    if (j != 1) {
      throw new ParserException("Unexpected saio entry count: " + j);
    }
    i = Atom.parseFullAtomVersion(i);
    long l2 = paramTrackFragment.auxiliaryDataPosition;
    if (i == 0) {}
    for (long l1 = paramParsableByteArray.readUnsignedInt();; l1 = paramParsableByteArray.readUnsignedLongToLong())
    {
      paramTrackFragment.auxiliaryDataPosition = (l1 + l2);
      return;
    }
  }
  
  private static void parseSaiz(TrackEncryptionBox paramTrackEncryptionBox, ParsableByteArray paramParsableByteArray, TrackFragment paramTrackFragment)
    throws ParserException
  {
    boolean bool = true;
    int n = paramTrackEncryptionBox.initializationVectorSize;
    paramParsableByteArray.setPosition(8);
    if ((Atom.parseFullAtomFlags(paramParsableByteArray.readInt()) & 0x1) == 1) {
      paramParsableByteArray.skipBytes(8);
    }
    int i = paramParsableByteArray.readUnsignedByte();
    int m = paramParsableByteArray.readUnsignedIntToInt();
    if (m != paramTrackFragment.sampleCount) {
      throw new ParserException("Length mismatch: " + m + ", " + paramTrackFragment.sampleCount);
    }
    int k;
    if (i == 0)
    {
      paramTrackEncryptionBox = paramTrackFragment.sampleHasSubsampleEncryptionTable;
      int j = 0;
      i = 0;
      k = i;
      if (j < m)
      {
        k = paramParsableByteArray.readUnsignedByte();
        if (k > n) {}
        for (bool = true;; bool = false)
        {
          paramTrackEncryptionBox[j] = bool;
          j += 1;
          i += k;
          break;
        }
      }
    }
    else
    {
      if (i <= n) {
        break label195;
      }
    }
    for (;;)
    {
      k = i * m + 0;
      Arrays.fill(paramTrackFragment.sampleHasSubsampleEncryptionTable, 0, m, bool);
      paramTrackFragment.initEncryptionData(k);
      return;
      label195:
      bool = false;
    }
  }
  
  private static void parseSenc(ParsableByteArray paramParsableByteArray, int paramInt, TrackFragment paramTrackFragment)
    throws ParserException
  {
    paramParsableByteArray.setPosition(paramInt + 8);
    paramInt = Atom.parseFullAtomFlags(paramParsableByteArray.readInt());
    if ((paramInt & 0x1) != 0) {
      throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
    }
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = paramParsableByteArray.readUnsignedIntToInt();
      if (paramInt == paramTrackFragment.sampleCount) {
        break;
      }
      throw new ParserException("Length mismatch: " + paramInt + ", " + paramTrackFragment.sampleCount);
    }
    Arrays.fill(paramTrackFragment.sampleHasSubsampleEncryptionTable, 0, paramInt, bool);
    paramTrackFragment.initEncryptionData(paramParsableByteArray.bytesLeft());
    paramTrackFragment.fillEncryptionData(paramParsableByteArray);
  }
  
  private static void parseSenc(ParsableByteArray paramParsableByteArray, TrackFragment paramTrackFragment)
    throws ParserException
  {
    parseSenc(paramParsableByteArray, 0, paramTrackFragment);
  }
  
  private static void parseSgpd(ParsableByteArray paramParsableByteArray1, ParsableByteArray paramParsableByteArray2, String paramString, TrackFragment paramTrackFragment)
    throws ParserException
  {
    paramParsableByteArray1.setPosition(8);
    int i = paramParsableByteArray1.readInt();
    if (paramParsableByteArray1.readInt() != SAMPLE_GROUP_TYPE_seig) {}
    for (;;)
    {
      return;
      if (Atom.parseFullAtomVersion(i) == 1) {
        paramParsableByteArray1.skipBytes(4);
      }
      if (paramParsableByteArray1.readInt() != 1) {
        throw new ParserException("Entry count in sbgp != 1 (unsupported).");
      }
      paramParsableByteArray2.setPosition(8);
      i = paramParsableByteArray2.readInt();
      if (paramParsableByteArray2.readInt() == SAMPLE_GROUP_TYPE_seig)
      {
        i = Atom.parseFullAtomVersion(i);
        if (i == 1)
        {
          if (paramParsableByteArray2.readUnsignedInt() == 0L) {
            throw new ParserException("Variable length description in sgpd found (unsupported)");
          }
        }
        else if (i >= 2) {
          paramParsableByteArray2.skipBytes(4);
        }
        if (paramParsableByteArray2.readUnsignedInt() != 1L) {
          throw new ParserException("Entry count in sgpd != 1 (unsupported).");
        }
        paramParsableByteArray2.skipBytes(1);
        i = paramParsableByteArray2.readUnsignedByte();
        if (paramParsableByteArray2.readUnsignedByte() == 1) {}
        for (boolean bool = true; bool; bool = false)
        {
          int j = paramParsableByteArray2.readUnsignedByte();
          byte[] arrayOfByte = new byte[16];
          paramParsableByteArray2.readBytes(arrayOfByte, 0, arrayOfByte.length);
          Object localObject = null;
          paramParsableByteArray1 = localObject;
          if (bool)
          {
            paramParsableByteArray1 = localObject;
            if (j == 0)
            {
              int k = paramParsableByteArray2.readUnsignedByte();
              paramParsableByteArray1 = new byte[k];
              paramParsableByteArray2.readBytes(paramParsableByteArray1, 0, k);
            }
          }
          paramTrackFragment.definesEncryptionData = true;
          paramTrackFragment.trackEncryptionBox = new TrackEncryptionBox(bool, paramString, j, arrayOfByte, (i & 0xF0) >> 4, i & 0xF, paramParsableByteArray1);
          return;
        }
      }
    }
  }
  
  private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray paramParsableByteArray, long paramLong)
    throws ParserException
  {
    paramParsableByteArray.setPosition(8);
    int i = Atom.parseFullAtomVersion(paramParsableByteArray.readInt());
    paramParsableByteArray.skipBytes(4);
    long l5 = paramParsableByteArray.readUnsignedInt();
    long l1;
    long l2;
    long l4;
    int j;
    int[] arrayOfInt;
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    long[] arrayOfLong3;
    long l3;
    if (i == 0)
    {
      l1 = paramParsableByteArray.readUnsignedInt();
      l2 = paramParsableByteArray.readUnsignedInt() + paramLong;
      paramLong = l1;
      l1 = l2;
      l4 = Util.scaleLargeTimestamp(paramLong, 1000000L, l5);
      paramParsableByteArray.skipBytes(2);
      j = paramParsableByteArray.readUnsignedShort();
      arrayOfInt = new int[j];
      arrayOfLong1 = new long[j];
      arrayOfLong2 = new long[j];
      arrayOfLong3 = new long[j];
      l2 = l1;
      i = 0;
      l3 = paramLong;
      l1 = l4;
      paramLong = l2;
      l2 = l3;
    }
    for (;;)
    {
      if (i >= j) {
        break label245;
      }
      int k = paramParsableByteArray.readInt();
      if ((0x80000000 & k) != 0)
      {
        throw new ParserException("Unhandled indirect reference");
        l2 = paramParsableByteArray.readUnsignedLongToLong();
        l1 = paramParsableByteArray.readUnsignedLongToLong() + paramLong;
        paramLong = l2;
        break;
      }
      l3 = paramParsableByteArray.readUnsignedInt();
      arrayOfInt[i] = (k & 0x7FFFFFFF);
      arrayOfLong1[i] = paramLong;
      arrayOfLong3[i] = l1;
      l2 += l3;
      l1 = Util.scaleLargeTimestamp(l2, 1000000L, l5);
      arrayOfLong2[i] = (l1 - arrayOfLong3[i]);
      paramParsableByteArray.skipBytes(4);
      paramLong += arrayOfInt[i];
      i += 1;
    }
    label245:
    return Pair.create(Long.valueOf(l4), new ChunkIndex(arrayOfInt, arrayOfLong1, arrayOfLong2, arrayOfLong3));
  }
  
  private static long parseTfdt(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(8);
    if (Atom.parseFullAtomVersion(paramParsableByteArray.readInt()) == 1) {
      return paramParsableByteArray.readUnsignedLongToLong();
    }
    return paramParsableByteArray.readUnsignedInt();
  }
  
  private static TrackBundle parseTfhd(ParsableByteArray paramParsableByteArray, SparseArray<TrackBundle> paramSparseArray, int paramInt)
  {
    paramParsableByteArray.setPosition(8);
    int k = Atom.parseFullAtomFlags(paramParsableByteArray.readInt());
    int i = paramParsableByteArray.readInt();
    if ((paramInt & 0x8) == 0) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramSparseArray = (TrackBundle)paramSparseArray.get(paramInt);
      if (paramSparseArray != null) {
        break;
      }
      return null;
    }
    if ((k & 0x1) != 0)
    {
      long l = paramParsableByteArray.readUnsignedLongToLong();
      paramSparseArray.fragment.dataPosition = l;
      paramSparseArray.fragment.auxiliaryDataPosition = l;
    }
    DefaultSampleValues localDefaultSampleValues = paramSparseArray.defaultSampleValues;
    label113:
    int j;
    if ((k & 0x2) != 0)
    {
      paramInt = paramParsableByteArray.readUnsignedIntToInt() - 1;
      if ((k & 0x8) == 0) {
        break label172;
      }
      i = paramParsableByteArray.readUnsignedIntToInt();
      if ((k & 0x10) == 0) {
        break label181;
      }
      j = paramParsableByteArray.readUnsignedIntToInt();
      label127:
      if ((k & 0x20) == 0) {
        break label191;
      }
    }
    label172:
    label181:
    label191:
    for (k = paramParsableByteArray.readUnsignedIntToInt();; k = localDefaultSampleValues.flags)
    {
      paramSparseArray.fragment.header = new DefaultSampleValues(paramInt, i, j, k);
      return paramSparseArray;
      paramInt = localDefaultSampleValues.sampleDescriptionIndex;
      break;
      i = localDefaultSampleValues.duration;
      break label113;
      j = localDefaultSampleValues.size;
      break label127;
    }
  }
  
  private static void parseTraf(Atom.ContainerAtom paramContainerAtom, SparseArray<TrackBundle> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
    throws ParserException
  {
    paramSparseArray = parseTfhd(paramContainerAtom.getLeafAtomOfType(Atom.TYPE_tfhd).data, paramSparseArray, paramInt);
    if (paramSparseArray == null) {
      return;
    }
    TrackFragment localTrackFragment = paramSparseArray.fragment;
    long l2 = localTrackFragment.nextFragmentDecodeTime;
    paramSparseArray.reset();
    long l1 = l2;
    if (paramContainerAtom.getLeafAtomOfType(Atom.TYPE_tfdt) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = parseTfdt(paramContainerAtom.getLeafAtomOfType(Atom.TYPE_tfdt).data);
      }
    }
    parseTruns(paramContainerAtom, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.track.getSampleDescriptionEncryptionBox(localTrackFragment.header.sampleDescriptionIndex);
    Object localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
    if (localObject1 != null) {
      parseSaiz(paramSparseArray, ((Atom.LeafAtom)localObject1).data, localTrackFragment);
    }
    localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_saio);
    if (localObject1 != null) {
      parseSaio(((Atom.LeafAtom)localObject1).data, localTrackFragment);
    }
    localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_senc);
    if (localObject1 != null) {
      parseSenc(((Atom.LeafAtom)localObject1).data, localTrackFragment);
    }
    localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_sbgp);
    Object localObject2 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_sgpd);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((Atom.LeafAtom)localObject1).data;
      localObject2 = ((Atom.LeafAtom)localObject2).data;
      if (paramSparseArray == null) {
        break label295;
      }
    }
    label295:
    for (paramSparseArray = paramSparseArray.schemeType;; paramSparseArray = null)
    {
      parseSgpd((ParsableByteArray)localObject1, (ParsableByteArray)localObject2, paramSparseArray, localTrackFragment);
      int i = paramContainerAtom.leafChildren.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSparseArray = (Atom.LeafAtom)paramContainerAtom.leafChildren.get(paramInt);
        if (paramSparseArray.type == Atom.TYPE_uuid) {
          parseUuid(paramSparseArray.data, localTrackFragment, paramArrayOfByte);
        }
        paramInt += 1;
      }
      break;
    }
  }
  
  private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(12);
    return Pair.create(Integer.valueOf(paramParsableByteArray.readInt()), new DefaultSampleValues(paramParsableByteArray.readUnsignedIntToInt() - 1, paramParsableByteArray.readUnsignedIntToInt(), paramParsableByteArray.readUnsignedIntToInt(), paramParsableByteArray.readInt()));
  }
  
  private static int parseTrun(TrackBundle paramTrackBundle, int paramInt1, long paramLong, int paramInt2, ParsableByteArray paramParsableByteArray, int paramInt3)
  {
    paramParsableByteArray.setPosition(8);
    int i1 = Atom.parseFullAtomFlags(paramParsableByteArray.readInt());
    Track localTrack = paramTrackBundle.track;
    paramTrackBundle = paramTrackBundle.fragment;
    DefaultSampleValues localDefaultSampleValues = paramTrackBundle.header;
    paramTrackBundle.trunLength[paramInt1] = paramParsableByteArray.readUnsignedIntToInt();
    paramTrackBundle.trunDataPosition[paramInt1] = paramTrackBundle.dataPosition;
    Object localObject;
    if ((i1 & 0x1) != 0)
    {
      localObject = paramTrackBundle.trunDataPosition;
      localObject[paramInt1] += paramParsableByteArray.readInt();
    }
    int j;
    int i;
    int k;
    label124:
    int m;
    label136:
    int n;
    if ((i1 & 0x4) != 0)
    {
      j = 1;
      i = localDefaultSampleValues.flags;
      if (j != 0) {
        i = paramParsableByteArray.readUnsignedIntToInt();
      }
      if ((i1 & 0x100) == 0) {
        break label422;
      }
      k = 1;
      if ((i1 & 0x200) == 0) {
        break label428;
      }
      m = 1;
      if ((i1 & 0x400) == 0) {
        break label434;
      }
      n = 1;
      label148:
      if ((i1 & 0x800) == 0) {
        break label440;
      }
      i1 = 1;
      label160:
      if ((localTrack.editListDurations == null) || (localTrack.editListDurations.length != 1) || (localTrack.editListDurations[0] != 0L)) {
        break label518;
      }
    }
    label518:
    for (long l1 = Util.scaleLargeTimestamp(localTrack.editListMediaTimes[0], 1000L, localTrack.timescale);; l1 = 0L)
    {
      localObject = paramTrackBundle.sampleSizeTable;
      int[] arrayOfInt = paramTrackBundle.sampleCompositionTimeOffsetTable;
      long[] arrayOfLong = paramTrackBundle.sampleDecodingTimeTable;
      boolean[] arrayOfBoolean = paramTrackBundle.sampleIsSyncFrameTable;
      label253:
      int i4;
      label280:
      int i2;
      label299:
      int i3;
      if ((localTrack.type == 2) && ((paramInt2 & 0x1) != 0))
      {
        paramInt2 = 1;
        i4 = paramInt3 + paramTrackBundle.trunLength[paramInt1];
        long l2 = localTrack.timescale;
        if (paramInt1 > 0) {
          paramLong = paramTrackBundle.nextFragmentDecodeTime;
        }
        if (paramInt3 >= i4) {
          break label510;
        }
        if (k == 0) {
          break label452;
        }
        i2 = paramParsableByteArray.readUnsignedIntToInt();
        if (m == 0) {
          break label462;
        }
        i3 = paramParsableByteArray.readUnsignedIntToInt();
        label311:
        if ((paramInt3 != 0) || (j == 0)) {
          break label472;
        }
        paramInt1 = i;
        label324:
        if (i1 == 0) {
          break label495;
        }
        arrayOfInt[paramInt3] = ((int)(paramParsableByteArray.readInt() * 1000L / l2));
        label348:
        arrayOfLong[paramInt3] = (Util.scaleLargeTimestamp(paramLong, 1000L, l2) - l1);
        localObject[paramInt3] = i3;
        if (((paramInt1 >> 16 & 0x1) != 0) || ((paramInt2 != 0) && (paramInt3 != 0))) {
          break label504;
        }
      }
      label422:
      label428:
      label434:
      label440:
      label452:
      label462:
      label472:
      label495:
      label504:
      for (int i5 = 1;; i5 = 0)
      {
        arrayOfBoolean[paramInt3] = i5;
        paramLong += i2;
        paramInt3 += 1;
        break label280;
        j = 0;
        break;
        k = 0;
        break label124;
        m = 0;
        break label136;
        n = 0;
        break label148;
        i1 = 0;
        break label160;
        paramInt2 = 0;
        break label253;
        i2 = localDefaultSampleValues.duration;
        break label299;
        i3 = localDefaultSampleValues.size;
        break label311;
        if (n != 0)
        {
          paramInt1 = paramParsableByteArray.readInt();
          break label324;
        }
        paramInt1 = localDefaultSampleValues.flags;
        break label324;
        arrayOfInt[paramInt3] = 0;
        break label348;
      }
      label510:
      paramTrackBundle.nextFragmentDecodeTime = paramLong;
      return i4;
    }
  }
  
  private static void parseTruns(Atom.ContainerAtom paramContainerAtom, TrackBundle paramTrackBundle, long paramLong, int paramInt)
  {
    paramContainerAtom = paramContainerAtom.leafChildren;
    int i1 = paramContainerAtom.size();
    int k = 0;
    int j = 0;
    int i = 0;
    Object localObject;
    int m;
    if (k < i1)
    {
      localObject = (Atom.LeafAtom)paramContainerAtom.get(k);
      if (((Atom.LeafAtom)localObject).type != Atom.TYPE_trun) {
        break label237;
      }
      localObject = ((Atom.LeafAtom)localObject).data;
      ((ParsableByteArray)localObject).setPosition(12);
      m = ((ParsableByteArray)localObject).readUnsignedIntToInt();
      if (m <= 0) {
        break label237;
      }
      m += j;
      j = i + 1;
      i = m;
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      paramTrackBundle.currentTrackRunIndex = 0;
      paramTrackBundle.currentSampleInTrackRun = 0;
      paramTrackBundle.currentSampleIndex = 0;
      paramTrackBundle.fragment.initTables(i, j);
      i = 0;
      k = 0;
      j = 0;
      while (i < i1)
      {
        localObject = (Atom.LeafAtom)paramContainerAtom.get(i);
        int n = j;
        m = k;
        if (((Atom.LeafAtom)localObject).type == Atom.TYPE_trun)
        {
          m = parseTrun(paramTrackBundle, j, paramLong, paramInt, ((Atom.LeafAtom)localObject).data, k);
          n = j + 1;
        }
        i += 1;
        j = n;
        k = m;
      }
      return;
      label237:
      m = i;
      i = j;
      j = m;
    }
  }
  
  private static void parseUuid(ParsableByteArray paramParsableByteArray, TrackFragment paramTrackFragment, byte[] paramArrayOfByte)
    throws ParserException
  {
    paramParsableByteArray.setPosition(8);
    paramParsableByteArray.readBytes(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
      return;
    }
    parseSenc(paramParsableByteArray, 16, paramTrackFragment);
  }
  
  private void processAtomEnded(long paramLong)
    throws ParserException
  {
    while ((!this.containerAtoms.isEmpty()) && (((Atom.ContainerAtom)this.containerAtoms.peek()).endPosition == paramLong)) {
      onContainerAtomRead((Atom.ContainerAtom)this.containerAtoms.pop());
    }
    enterReadingAtomHeaderState();
  }
  
  private boolean readAtomHeader(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    if (this.atomHeaderBytesRead == 0)
    {
      if (!paramExtractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
        return false;
      }
      this.atomHeaderBytesRead = 8;
      this.atomHeader.setPosition(0);
      this.atomSize = this.atomHeader.readUnsignedInt();
      this.atomType = this.atomHeader.readInt();
    }
    if (this.atomSize == 1L)
    {
      paramExtractorInput.readFully(this.atomHeader.data, 8, 8);
      this.atomHeaderBytesRead += 8;
      this.atomSize = this.atomHeader.readUnsignedLongToLong();
    }
    while (this.atomSize < this.atomHeaderBytesRead)
    {
      throw new ParserException("Atom size less than header length (unsupported).");
      if (this.atomSize == 0L)
      {
        long l2 = paramExtractorInput.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.containerAtoms.isEmpty()) {
            l1 = ((Atom.ContainerAtom)this.containerAtoms.peek()).endPosition;
          }
        }
        if (l1 != -1L) {
          this.atomSize = (l1 - paramExtractorInput.getPosition() + this.atomHeaderBytesRead);
        }
      }
    }
    long l1 = paramExtractorInput.getPosition() - this.atomHeaderBytesRead;
    if (this.atomType == Atom.TYPE_moof)
    {
      int j = this.trackBundles.size();
      int i = 0;
      while (i < j)
      {
        TrackFragment localTrackFragment = ((TrackBundle)this.trackBundles.valueAt(i)).fragment;
        localTrackFragment.atomPosition = l1;
        localTrackFragment.auxiliaryDataPosition = l1;
        localTrackFragment.dataPosition = l1;
        i += 1;
      }
    }
    if (this.atomType == Atom.TYPE_mdat)
    {
      this.currentTrackBundle = null;
      this.endOfMdatPosition = (this.atomSize + l1);
      if (!this.haveOutputSeekMap)
      {
        this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, l1));
        this.haveOutputSeekMap = true;
      }
      this.parserState = 2;
      return true;
    }
    if (shouldParseContainerAtom(this.atomType))
    {
      l1 = paramExtractorInput.getPosition() + this.atomSize - 8L;
      this.containerAtoms.add(new Atom.ContainerAtom(this.atomType, l1));
      if (this.atomSize == this.atomHeaderBytesRead) {
        processAtomEnded(l1);
      }
    }
    for (;;)
    {
      return true;
      enterReadingAtomHeaderState();
      continue;
      if (shouldParseLeafAtom(this.atomType))
      {
        if (this.atomHeaderBytesRead != 8) {
          throw new ParserException("Leaf atom defines extended atom size (unsupported).");
        }
        if (this.atomSize > 2147483647L) {
          throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
        }
        this.atomData = new ParsableByteArray((int)this.atomSize);
        System.arraycopy(this.atomHeader.data, 0, this.atomData.data, 0, 8);
        this.parserState = 1;
      }
      else
      {
        if (this.atomSize > 2147483647L) {
          throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        }
        this.atomData = null;
        this.parserState = 1;
      }
    }
  }
  
  private void readAtomPayload(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    int i = (int)this.atomSize - this.atomHeaderBytesRead;
    if (this.atomData != null)
    {
      paramExtractorInput.readFully(this.atomData.data, 8, i);
      onLeafAtomRead(new Atom.LeafAtom(this.atomType, this.atomData), paramExtractorInput.getPosition());
    }
    for (;;)
    {
      processAtomEnded(paramExtractorInput.getPosition());
      return;
      paramExtractorInput.skipFully(i);
    }
  }
  
  private void readEncryptionData(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    TrackBundle localTrackBundle = null;
    long l = 9223372036854775807L;
    int j = this.trackBundles.size();
    int i = 0;
    if (i < j)
    {
      TrackFragment localTrackFragment = ((TrackBundle)this.trackBundles.valueAt(i)).fragment;
      if ((!localTrackFragment.sampleEncryptionDataNeedsFill) || (localTrackFragment.auxiliaryDataPosition >= l)) {
        break label139;
      }
      l = localTrackFragment.auxiliaryDataPosition;
      localTrackBundle = (TrackBundle)this.trackBundles.valueAt(i);
    }
    label139:
    for (;;)
    {
      i += 1;
      break;
      if (localTrackBundle == null)
      {
        this.parserState = 3;
        return;
      }
      i = (int)(l - paramExtractorInput.getPosition());
      if (i < 0) {
        throw new ParserException("Offset to encryption data was negative.");
      }
      paramExtractorInput.skipFully(i);
      localTrackBundle.fragment.fillEncryptionData(paramExtractorInput);
      return;
    }
  }
  
  private boolean readSample(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    Object localObject;
    int j;
    Track localTrack;
    TrackOutput localTrackOutput;
    int k;
    int n;
    if (this.parserState == 3)
    {
      if (this.currentTrackBundle == null)
      {
        localObject = getNextFragmentRun(this.trackBundles);
        if (localObject == null)
        {
          i = (int)(this.endOfMdatPosition - paramExtractorInput.getPosition());
          if (i < 0) {
            throw new ParserException("Offset to end of mdat was negative.");
          }
          paramExtractorInput.skipFully(i);
          enterReadingAtomHeaderState();
          return false;
        }
        j = (int)(localObject.fragment.trunDataPosition[localObject.currentTrackRunIndex] - paramExtractorInput.getPosition());
        i = j;
        if (j < 0)
        {
          Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
          i = 0;
        }
        paramExtractorInput.skipFully(i);
        this.currentTrackBundle = ((TrackBundle)localObject);
      }
      this.sampleSize = this.currentTrackBundle.fragment.sampleSizeTable[this.currentTrackBundle.currentSampleIndex];
      if (this.currentTrackBundle.fragment.definesEncryptionData)
      {
        this.sampleBytesWritten = appendSampleEncryptionData(this.currentTrackBundle);
        this.sampleSize += this.sampleBytesWritten;
        if (this.currentTrackBundle.track.sampleTransformation == 1)
        {
          this.sampleSize -= 8;
          paramExtractorInput.skipFully(8);
        }
        this.parserState = 4;
        this.sampleCurrentNalBytesRemaining = 0;
      }
    }
    else
    {
      localObject = this.currentTrackBundle.fragment;
      localTrack = this.currentTrackBundle.track;
      localTrackOutput = this.currentTrackBundle.output;
      k = this.currentTrackBundle.currentSampleIndex;
      if (localTrack.nalUnitLengthFieldLength == 0) {
        break label652;
      }
      byte[] arrayOfByte = this.nalPrefix.data;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      int m = localTrack.nalUnitLengthFieldLength;
      n = 4 - localTrack.nalUnitLengthFieldLength;
      label310:
      if (this.sampleBytesWritten >= this.sampleSize) {
        break label693;
      }
      if (this.sampleCurrentNalBytesRemaining != 0) {
        break label468;
      }
      paramExtractorInput.readFully(arrayOfByte, n, m + 1);
      this.nalPrefix.setPosition(0);
      this.sampleCurrentNalBytesRemaining = (this.nalPrefix.readUnsignedIntToInt() - 1);
      this.nalStartCode.setPosition(0);
      localTrackOutput.sampleData(this.nalStartCode, 4);
      localTrackOutput.sampleData(this.nalPrefix, 1);
      if ((this.cea608TrackOutputs.length <= 0) || (!NalUnitUtil.isNalUnitSei(localTrack.format.sampleMimeType, arrayOfByte[4]))) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      this.processSeiNalUnitPayload = bool;
      this.sampleBytesWritten += 5;
      this.sampleSize += n;
      break label310;
      this.sampleBytesWritten = 0;
      break;
    }
    label468:
    if (this.processSeiNalUnitPayload)
    {
      this.nalBuffer.reset(this.sampleCurrentNalBytesRemaining);
      paramExtractorInput.readFully(this.nalBuffer.data, 0, this.sampleCurrentNalBytesRemaining);
      localTrackOutput.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
      j = this.sampleCurrentNalBytesRemaining;
      int i1 = NalUnitUtil.unescapeStream(this.nalBuffer.data, this.nalBuffer.limit());
      ParsableByteArray localParsableByteArray = this.nalBuffer;
      if ("video/hevc".equals(localTrack.format.sampleMimeType))
      {
        i = 1;
        localParsableByteArray.setPosition(i);
        this.nalBuffer.setLimit(i1);
        CeaUtil.consume(((TrackFragment)localObject).getSamplePresentationTime(k) * 1000L, this.nalBuffer, this.cea608TrackOutputs);
      }
    }
    label568:
    for (int i = j;; i = localTrackOutput.sampleData(paramExtractorInput, this.sampleCurrentNalBytesRemaining, false))
    {
      this.sampleBytesWritten += i;
      this.sampleCurrentNalBytesRemaining -= i;
      break;
      i = 0;
      break label568;
    }
    label652:
    while (this.sampleBytesWritten < this.sampleSize) {
      this.sampleBytesWritten = (localTrackOutput.sampleData(paramExtractorInput, this.sampleSize - this.sampleBytesWritten, false) + this.sampleBytesWritten);
    }
    label693:
    long l2 = ((TrackFragment)localObject).getSamplePresentationTime(k) * 1000L;
    long l1 = l2;
    if (this.timestampAdjuster != null) {
      l1 = this.timestampAdjuster.adjustSampleTimestamp(l2);
    }
    if (localObject.sampleIsSyncFrameTable[k] != 0)
    {
      i = 1;
      paramExtractorInput = null;
      if (!((TrackFragment)localObject).definesEncryptionData) {
        break label908;
      }
      i = 0x40000000 | i;
      if (((TrackFragment)localObject).trackEncryptionBox == null) {
        break label891;
      }
      paramExtractorInput = ((TrackFragment)localObject).trackEncryptionBox;
      label771:
      paramExtractorInput = paramExtractorInput.cryptoData;
    }
    label908:
    for (;;)
    {
      localTrackOutput.sampleMetadata(l1, i, this.sampleSize, 0, paramExtractorInput);
      outputPendingMetadataSamples(l1);
      paramExtractorInput = this.currentTrackBundle;
      paramExtractorInput.currentSampleIndex += 1;
      paramExtractorInput = this.currentTrackBundle;
      paramExtractorInput.currentSampleInTrackRun += 1;
      if (this.currentTrackBundle.currentSampleInTrackRun == localObject.trunLength[this.currentTrackBundle.currentTrackRunIndex])
      {
        paramExtractorInput = this.currentTrackBundle;
        paramExtractorInput.currentTrackRunIndex += 1;
        this.currentTrackBundle.currentSampleInTrackRun = 0;
        this.currentTrackBundle = null;
      }
      this.parserState = 3;
      return true;
      i = 0;
      break;
      label891:
      paramExtractorInput = localTrack.getSampleDescriptionEncryptionBox(((TrackFragment)localObject).header.sampleDescriptionIndex);
      break label771;
    }
  }
  
  private static boolean shouldParseContainerAtom(int paramInt)
  {
    return (paramInt == Atom.TYPE_moov) || (paramInt == Atom.TYPE_trak) || (paramInt == Atom.TYPE_mdia) || (paramInt == Atom.TYPE_minf) || (paramInt == Atom.TYPE_stbl) || (paramInt == Atom.TYPE_moof) || (paramInt == Atom.TYPE_traf) || (paramInt == Atom.TYPE_mvex) || (paramInt == Atom.TYPE_edts);
  }
  
  private static boolean shouldParseLeafAtom(int paramInt)
  {
    return (paramInt == Atom.TYPE_hdlr) || (paramInt == Atom.TYPE_mdhd) || (paramInt == Atom.TYPE_mvhd) || (paramInt == Atom.TYPE_sidx) || (paramInt == Atom.TYPE_stsd) || (paramInt == Atom.TYPE_tfdt) || (paramInt == Atom.TYPE_tfhd) || (paramInt == Atom.TYPE_tkhd) || (paramInt == Atom.TYPE_trex) || (paramInt == Atom.TYPE_trun) || (paramInt == Atom.TYPE_pssh) || (paramInt == Atom.TYPE_saiz) || (paramInt == Atom.TYPE_saio) || (paramInt == Atom.TYPE_senc) || (paramInt == Atom.TYPE_uuid) || (paramInt == Atom.TYPE_sbgp) || (paramInt == Atom.TYPE_sgpd) || (paramInt == Atom.TYPE_elst) || (paramInt == Atom.TYPE_mehd) || (paramInt == Atom.TYPE_emsg);
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.extractorOutput = paramExtractorOutput;
    if (this.sideloadedTrack != null)
    {
      paramExtractorOutput = new TrackBundle(paramExtractorOutput.track(0, this.sideloadedTrack.type));
      paramExtractorOutput.init(this.sideloadedTrack, new DefaultSampleValues(0, 0, 0, 0));
      this.trackBundles.put(0, paramExtractorOutput);
      maybeInitExtraTracks();
      this.extractorOutput.endTracks();
    }
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
    throws IOException, InterruptedException
  {
    for (;;)
    {
      switch (this.parserState)
      {
      default: 
        if (!readSample(paramExtractorInput)) {
          continue;
        }
        return 0;
      case 0: 
        if (readAtomHeader(paramExtractorInput)) {
          continue;
        }
        return -1;
      case 1: 
        readAtomPayload(paramExtractorInput);
        break;
      }
      readEncryptionData(paramExtractorInput);
    }
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    int j = this.trackBundles.size();
    int i = 0;
    while (i < j)
    {
      ((TrackBundle)this.trackBundles.valueAt(i)).reset();
      i += 1;
    }
    this.pendingMetadataSampleInfos.clear();
    this.pendingMetadataSampleBytes = 0;
    this.containerAtoms.clear();
    enterReadingAtomHeaderState();
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    return Sniffer.sniffFragmented(paramExtractorInput);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Flags {}
  
  static final class MetadataSampleInfo
  {
    public final long presentationTimeDeltaUs;
    public final int size;
    
    public MetadataSampleInfo(long paramLong, int paramInt)
    {
      this.presentationTimeDeltaUs = paramLong;
      this.size = paramInt;
    }
  }
  
  static final class TrackBundle
  {
    public int currentSampleInTrackRun;
    public int currentSampleIndex;
    public int currentTrackRunIndex;
    public DefaultSampleValues defaultSampleValues;
    public final TrackFragment fragment = new TrackFragment();
    public final TrackOutput output;
    public Track track;
    
    public TrackBundle(TrackOutput paramTrackOutput)
    {
      this.output = paramTrackOutput;
    }
    
    public void init(Track paramTrack, DefaultSampleValues paramDefaultSampleValues)
    {
      this.track = ((Track)Assertions.checkNotNull(paramTrack));
      this.defaultSampleValues = ((DefaultSampleValues)Assertions.checkNotNull(paramDefaultSampleValues));
      this.output.format(paramTrack.format);
      reset();
    }
    
    public void reset()
    {
      this.fragment.reset();
      this.currentSampleIndex = 0;
      this.currentTrackRunIndex = 0;
      this.currentSampleInTrackRun = 0;
    }
    
    public void updateDrmInitData(DrmInitData paramDrmInitData)
    {
      Object localObject = this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
      if (localObject != null) {}
      for (localObject = ((TrackEncryptionBox)localObject).schemeType;; localObject = null)
      {
        this.output.format(this.track.format.copyWithDrmInitData(paramDrmInitData.copyWithSchemeType((String)localObject)));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor
 * JD-Core Version:    0.7.0.1
 */