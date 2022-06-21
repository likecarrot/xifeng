package com.example.xifeng2.RetClass;

public class realtime {

    /**
     * status : ok
     * api_version : v2.5
     * api_status : active
     * lang : zh_CN
     * unit : metric
     * tzshift : 28800
     * timezone : Asia/Shanghai
     * server_time : 1655760990
     * location : [33.5355,115.2545]
     * result : {"realtime":{"status":"ok","temperature":27,"humidity":0.76,"cloudrate":0,"skycon":"CLEAR_DAY","visibility":14,"dswrf":0,"wind":{"speed":10.01,"direction":126},"pressure":99521.44,"apparent_temperature":29,"precipitation":{"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":10000,"intensity":0}},"air_quality":{"pm25":26,"pm10":61,"o3":91,"so2":10,"no2":15,"co":0.5,"aqi":{"chn":56,"usa":80},"description":{"chn":"良","usa":"良"}},"life_index":{"ultraviolet":{"index":0,"desc":"无"},"comfort":{"index":3,"desc":"热"}}},"primary":0}
     */

    private String status;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * realtime : {"status":"ok","temperature":27,"humidity":0.76,"cloudrate":0,"skycon":"CLEAR_DAY","visibility":14,"dswrf":0,"wind":{"speed":10.01,"direction":126},"pressure":99521.44,"apparent_temperature":29,"precipitation":{"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":10000,"intensity":0}},"air_quality":{"pm25":26,"pm10":61,"o3":91,"so2":10,"no2":15,"co":0.5,"aqi":{"chn":56,"usa":80},"description":{"chn":"良","usa":"良"}},"life_index":{"ultraviolet":{"index":0,"desc":"无"},"comfort":{"index":3,"desc":"热"}}}
         * primary : 0
         */

        private RealtimeBean realtime;

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public static class RealtimeBean {
            /**
             * status : ok
             * temperature : 27.0
             * humidity : 0.76
             * cloudrate : 0.0
             * skycon : CLEAR_DAY
             * visibility : 14.0
             * dswrf : 0.0
             * wind : {"speed":10.01,"direction":126}
             * pressure : 99521.44
             * apparent_temperature : 29.0
             * precipitation : {"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":10000,"intensity":0}}
             * air_quality : {"pm25":26,"pm10":61,"o3":91,"so2":10,"no2":15,"co":0.5,"aqi":{"chn":56,"usa":80},"description":{"chn":"良","usa":"良"}}
             * life_index : {"ultraviolet":{"index":0,"desc":"无"},"comfort":{"index":3,"desc":"热"}}
             */

            private String status;
            private double temperature;
            private double humidity;
            private double cloudrate;
            private String skycon;
            private double visibility;
            private WindBean wind;
            private double pressure;
            private double apparent_temperature;
            private PrecipitationBean precipitation;
            private AirQualityBean air_quality;
            private LifeIndexBean life_index;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public double getTemperature() {
                return temperature;
            }

            public void setTemperature(double temperature) {
                this.temperature = temperature;
            }

            public double getHumidity() {
                return humidity;
            }

            public void setHumidity(double humidity) {
                this.humidity = humidity;
            }

            public double getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(double cloudrate) {
                this.cloudrate = cloudrate;
            }

            public String getSkycon() {
                return skycon;
            }

            public void setSkycon(String skycon) {
                this.skycon = skycon;
            }

            public double getVisibility() {
                return visibility;
            }

            public void setVisibility(double visibility) {
                this.visibility = visibility;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public double getPressure() {
                return pressure;
            }

            public void setPressure(double pressure) {
                this.pressure = pressure;
            }

            public double getApparent_temperature() {
                return apparent_temperature;
            }

            public void setApparent_temperature(double apparent_temperature) {
                this.apparent_temperature = apparent_temperature;
            }

            public PrecipitationBean getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(PrecipitationBean precipitation) {
                this.precipitation = precipitation;
            }

            public AirQualityBean getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBean air_quality) {
                this.air_quality = air_quality;
            }

            public LifeIndexBean getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndexBean life_index) {
                this.life_index = life_index;
            }

            public static class WindBean {
                /**
                 * speed : 10.01
                 * direction : 126.0
                 */

                private double speed;
                private double direction;

                public double getSpeed() {
                    return speed;
                }

                public void setSpeed(double speed) {
                    this.speed = speed;
                }

                public double getDirection() {
                    return direction;
                }

                public void setDirection(double direction) {
                    this.direction = direction;
                }
            }

            public static class PrecipitationBean {
                /**
                 * local : {"status":"ok","datasource":"radar","intensity":0}
                 * nearest : {"status":"ok","distance":10000,"intensity":0}
                 */

                private LocalBean local;
                private NearestBean nearest;

                public LocalBean getLocal() {
                    return local;
                }

                public void setLocal(LocalBean local) {
                    this.local = local;
                }

                public NearestBean getNearest() {
                    return nearest;
                }

                public void setNearest(NearestBean nearest) {
                    this.nearest = nearest;
                }

                public static class LocalBean {
                    /**
                     * status : ok
                     * datasource : radar
                     * intensity : 0.0
                     */

                    private String status;
                    private String datasource;
                    private double intensity;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getDatasource() {
                        return datasource;
                    }

                    public void setDatasource(String datasource) {
                        this.datasource = datasource;
                    }

                    public double getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(double intensity) {
                        this.intensity = intensity;
                    }
                }

                public static class NearestBean {
                    /**
                     * status : ok
                     * distance : 10000.0
                     * intensity : 0.0
                     */

                    private String status;
                    private double distance;
                    private double intensity;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public double getDistance() {
                        return distance;
                    }

                    public void setDistance(double distance) {
                        this.distance = distance;
                    }

                    public double getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(double intensity) {
                        this.intensity = intensity;
                    }
                }
            }

            public static class AirQualityBean {
                /**
                 * pm25 : 26
                 * pm10 : 61
                 * o3 : 91
                 * so2 : 10
                 * no2 : 15
                 * co : 0.5
                 * aqi : {"chn":56,"usa":80}
                 * description : {"chn":"良","usa":"良"}
                 */

                private int pm25;
                private int pm10;
                private int o3;
                private int so2;
                private int no2;
                private double co;
                private AqiBean aqi;
                private DescriptionBean description;

                public int getPm25() {
                    return pm25;
                }

                public void setPm25(int pm25) {
                    this.pm25 = pm25;
                }

                public int getPm10() {
                    return pm10;
                }

                public void setPm10(int pm10) {
                    this.pm10 = pm10;
                }

                public int getO3() {
                    return o3;
                }

                public void setO3(int o3) {
                    this.o3 = o3;
                }

                public int getSo2() {
                    return so2;
                }

                public void setSo2(int so2) {
                    this.so2 = so2;
                }

                public int getNo2() {
                    return no2;
                }

                public void setNo2(int no2) {
                    this.no2 = no2;
                }

                public double getCo() {
                    return co;
                }

                public void setCo(double co) {
                    this.co = co;
                }

                public AqiBean getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBean aqi) {
                    this.aqi = aqi;
                }

                public DescriptionBean getDescription() {
                    return description;
                }

                public void setDescription(DescriptionBean description) {
                    this.description = description;
                }

                public static class AqiBean {
                    /**
                     * chn : 56
                     * usa : 80
                     */

                    private int chn;
                    private int usa;

                    public int getChn() {
                        return chn;
                    }

                    public void setChn(int chn) {
                        this.chn = chn;
                    }

                    public int getUsa() {
                        return usa;
                    }

                    public void setUsa(int usa) {
                        this.usa = usa;
                    }
                }

                public static class DescriptionBean {
                    /**
                     * chn : 良
                     * usa : 良
                     */

                    private String chn;
                    private String usa;

                    public String getChn() {
                        return chn;
                    }

                    public void setChn(String chn) {
                        this.chn = chn;
                    }

                    public String getUsa() {
                        return usa;
                    }

                    public void setUsa(String usa) {
                        this.usa = usa;
                    }
                }
            }

            public static class LifeIndexBean {
                /**
                 * ultraviolet : {"index":0,"desc":"无"}
                 * comfort : {"index":3,"desc":"热"}
                 */

                private UltravioletBean ultraviolet;
                private ComfortBean comfort;

                public UltravioletBean getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(UltravioletBean ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public ComfortBean getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBean comfort) {
                    this.comfort = comfort;
                }

                public static class UltravioletBean {
                    /**
                     * index : 0.0
                     * desc : 无
                     */

                    private double index;
                    private String desc;

                    public double getIndex() {
                        return index;
                    }

                    public void setIndex(double index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBean {
                    /**
                     * index : 3
                     * desc : 热
                     */

                    private int index;
                    private String desc;

                    public int getIndex() {
                        return index;
                    }

                    public void setIndex(int index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }
        }
    }
}
