import java.util.List;

public class TableLine {
    String delFlag;
    String seedVersionAdded;
    String seedVersionUpdated;
    String preferenceName;
    String description;
    String systemLevelYn;
    String groupLevelYn;
    String userLevelYn;
    String changeableYn;
    String preferenceDomainName;
    String useDefaultValueYn;
    String defaultValue;
    String groupLevelPriorityYn;
    String groupResolutionMethod;
    String preserveOnUpgradeYn;
    String moduleName;
    String orgLevelYn;

    public TableLine(List rawData) {
        delFlag = replace(rawData.get(0).toString());
        seedVersionAdded = replace(rawData.get(1).toString());
        seedVersionUpdated = replace(rawData.get(2).toString());
        preferenceName = replace(rawData.get(3).toString());
        description = replace(rawData.get(4).toString());
        systemLevelYn = replace(rawData.get(5).toString());
        groupLevelYn = replace(rawData.get(6).toString());
        userLevelYn = replace(rawData.get(7).toString());
        changeableYn = replace(rawData.get(8).toString());
        preferenceDomainName = replace(rawData.get(9).toString());
        useDefaultValueYn = replace(rawData.get(10).toString());
        defaultValue = replace(rawData.get(11).toString());
        groupLevelPriorityYn = replace(rawData.get(12).toString());
        groupResolutionMethod = replace(rawData.get(13).toString());
        preserveOnUpgradeYn = replace(rawData.get(14).toString());
        moduleName = replace(rawData.get(15).toString());
        orgLevelYn = replace(rawData.get(16).toString());
    }

    public static String replace (String rawData){
        return rawData.replace("\"", "").replace("\'", "\\'");
    }

    public static String inputValue(TableLine value) {
        return "'" + value.delFlag + "','" +
                value.seedVersionAdded + "','" +
                value.seedVersionUpdated + "','" +
                value.preferenceName + "','" +
                value.description + "','" +
                value.systemLevelYn + "','" +
                value.groupLevelYn + "','" +
                value.userLevelYn + "','" +
                value.changeableYn + "','" +
                value.preferenceDomainName + "','" +
                value.useDefaultValueYn + "','" +
                value.defaultValue + "','" +
                value.groupLevelPriorityYn + "','" +
                value.groupResolutionMethod + "','" +
                value.preserveOnUpgradeYn + "','" +
                value.moduleName + "','" +
                value.orgLevelYn + "'";
    }
}
