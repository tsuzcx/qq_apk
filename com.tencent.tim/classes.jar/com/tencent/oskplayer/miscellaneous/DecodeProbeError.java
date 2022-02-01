package com.tencent.oskplayer.miscellaneous;

public abstract interface DecodeProbeError
{
  public static final int GENERAL_ERR_BASE = 30000;
  public static final int HARDWARE_PROBE_ERR_BASE = 10000;
  public static final int OK = 0;
  public static final int SOFTWARE_PROBE_ERR_BASE = 20000;
  
  public static abstract interface GeneralProbeError
  {
    public static final int CREATE_IMG_OUTPUT_DIR_FAILED = 60000;
  }
  
  public static abstract interface HardwareProbeError
  {
    public static final int AMC_CONFIGURE_FAILED = 10024;
    public static final int AMC_EXTRACT_DEQUEUE_INPUT_BUFFER_FAILED = 10026;
    public static final int AMC_EXTRACT_DEQUEUE_OUTPUT_BUFFER_FAILED = 10025;
    public static final int AMC_EXTRACT_UNKNOWN_FAILED = 10027;
    public static final int AMC_GET_MEDIA_FORMAT_FAILED = 10028;
    public static final int AMC_NO_VIDEO_TRACK = 10009;
    public static final int AMC_SETUP_FAILED = 10010;
    public static final int ANDROID_VERSION_INCOMPATIBLE = 10001;
    public static final int EGL_CHOOSE_CONFIG_FAILED = 10005;
    public static final int EGL_CREATE_CONTEXT_FAILED = 10006;
    public static final int EGL_CREATE_PBUFFER_FAILED = 10007;
    public static final int EGL_GET_DISPLAY_FAILED = 10003;
    public static final int EGL_INITIALIZE_FAILED = 10004;
    public static final int EGL_MAKE_CURRENT_FAILED = 10008;
    public static final int FILE_CANNOT_READ = 10002;
    public static final int FILE_CREATE_FRAME_FAILED = 10022;
    public static final int FILE_CREATE_FRAME_SAVED_DIR_FAILED = 10023;
    public static final int GL_ATTACH_FRAGMENT_SHADER_FAILED = 10015;
    public static final int GL_ATTACH_VERTEX_SHADER_FAILED = 10014;
    public static final int GL_BIND_TEXTURE_FAILED = 10019;
    public static final int GL_CREATE_PROGRAM_FAILED = 10011;
    public static final int GL_GET_ATTRIB_LOCATION_FAILED = 10017;
    public static final int GL_GET_UNIFORM_LOCATION_FAILED = 10018;
    public static final int GL_LINK_PROGRAM_FAILED = 10016;
    public static final int GL_LOAD_FRAGMENT_SHADER_FAILED = 10013;
    public static final int GL_LOAD_VERTEX_SHADER_FAILED = 10012;
    public static final int GL_TEX_PARAMETER_FAILED = 10020;
    public static final int SURFACE_FRAME_NOT_AVAILABLE = 10021;
  }
  
  public static abstract interface SoftwareProbeError
  {
    public static final int AV_ALLOC_FORMAT_CONTEXT_FAILED = 20007;
    public static final int AV_CODEC_DECODE_FRAME_FAILED = 20005;
    public static final int AV_CODEC_ENCODE_IMAGE_FAILED = 20011;
    public static final int AV_CODEC_OPEN_FAILED = 20010;
    public static final int AV_FORMAT_NEW_STREAM_FAILED = 20009;
    public static final int AV_FORMAT_WRITE_FRAME = 20013;
    public static final int AV_FORMAT_WRITE_HEADER = 20012;
    public static final int AV_FORMAT_WRITE_TRAILER = 20014;
    public static final int AV_GUESS_FORMAT_FAILED = 20006;
    public static final int AV_IO_OPEN_FAILED = 20008;
    public static final int FILE_CANNOT_READ = 20015;
    public static final int FILE_CREATE_FRAME_SAVED_DIR_FAILED = 20004;
    public static final int LOCK_TIME_OUT = 20003;
    public static final int PLAYER_SET_DATA_SOURCE_FAILED = 20001;
    public static final int PLAYER_START_FAILED = 20002;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.miscellaneous.DecodeProbeError
 * JD-Core Version:    0.7.0.1
 */