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
        delFlag = rawData.get(0).toString().replace("\"", "").replace("\'", "\\'");
        seedVersionAdded = rawData.get(1).toString().replace("\"", "").replace("\'", "\\'");
        seedVersionUpdated = rawData.get(2).toString().replace("\"", "").replace("\'", "\\'");
        preferenceName = rawData.get(3).toString().replace("\"", "").replace("\'", "\\'");
        description = rawData.get(4).toString().replace("\"", "").replace("\'", "\\'");
        systemLevelYn = rawData.get(5).toString().replace("\"", "").replace("\'", "\\'");
        groupLevelYn = rawData.get(6).toString().replace("\"", "").replace("\'", "\\'");
        userLevelYn = rawData.get(7).toString().replace("\"", "").replace("\'", "\\'");
        changeableYn = rawData.get(8).toString().replace("\"", "").replace("\'", "\\'");
        preferenceDomainName = rawData.get(9).toString().replace("\"", "").replace("\'", "\\'");
        useDefaultValueYn = rawData.get(10).toString().replace("\"", "").replace("\'", "\\'");
        defaultValue = rawData.get(11).toString().replace("\"", "").replace("\'", "\\'");
        groupLevelPriorityYn = rawData.get(12).toString().replace("\"", "").replace("\'", "\\'");
        groupResolutionMethod = rawData.get(13).toString().replace("\"", "").replace("\'", "\\'");
        preserveOnUpgradeYn = rawData.get(14).toString().replace("\"", "").replace("\'", "\\'");
        moduleName = rawData.get(15).toString().replace("\"", "").replace("\'", "\\'");
        orgLevelYn = rawData.get(16).toString().replace("\"", "").replace("\'", "\\'");
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
