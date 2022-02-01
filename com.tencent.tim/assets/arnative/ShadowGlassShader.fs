precision highp float;

varying vec2 fragTexCoord;

#define MAX_SHADOW_LIGHTS 3
uniform lowp int shadowLightNum;

varying vec4 lightPOVCoord[MAX_SHADOW_LIGHTS];

uniform sampler2D shadowMap0Sampler;
uniform sampler2D shadowMap1Sampler;
uniform sampler2D shadowMap2Sampler;

float ApplyLight(int index) {
    vec4 shadowMapCoord = lightPOVCoord[index]; //
    vec2 shadowUV;
    shadowUV.x = 0.5 * shadowMapCoord.x / shadowMapCoord.w + 0.5;
    shadowUV.y = 0.5 * shadowMapCoord.y / shadowMapCoord.w + 0.5;
    
    if (shadowUV.x < 1.0 && shadowUV.x > 0.0 && shadowUV.y < 1.0 && shadowUV.y > 0.0)
    {
        highp float depth = 0.5 * shadowMapCoord.z / shadowMapCoord.w + 0.5;
        highp float lightDepth = 0.0;
        if (index == 0) {
            lightDepth = texture2D(shadowMap0Sampler, shadowUV.st).x;
        } else if (index == 1) {
            lightDepth = texture2D(shadowMap1Sampler, shadowUV.st).x;
        } else if (index == 2) {
            lightDepth = texture2D(shadowMap2Sampler, shadowUV.st).x;
        }
        if (depth > lightDepth + 0.001)
            return 0.3;
    }
    return 0.0;
}

void main() {
    //combine color from all the lights
    float shadow = 0.0;
    
    shadow += ApplyLight(0);

    gl_FragColor = vec4(0.0, 0.0, 0.0, shadow); // without gamma correction
    
}