package com.alqudri.appmontor.model.ann

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("OSManufacturer")
	val oSManufacturer: String? = null,

	@field:SerializedName("RegisteredOwner")
	val registeredOwner: String? = null,

	@field:SerializedName("DataExecutionPreventionAvailable")
	val dataExecutionPreventionAvailable: String? = null,

	@field:SerializedName("OSConfiguration")
	val oSConfiguration: String? = null,

	@field:SerializedName("SystemLocale")
	val systemLocale: String? = null,

	@field:SerializedName("RegisteredOrganization")
	val registeredOrganization: String? = null,

	@field:SerializedName("AvailablePhysicalMemory")
	val availablePhysicalMemory: String? = null,

	@field:SerializedName("InputLocale")
	val inputLocale: String? = null,

	@field:SerializedName("OSName")
	val oSName: String? = null,

	@field:SerializedName("SystemType")
	val systemType: String? = null,

	@field:SerializedName("PageFileLocation(s)")
	val pageFileLocationS: String? = null,

	@field:SerializedName("ConnectionName")
	val connectionName: String? = null,

	@field:SerializedName("OSBuildType")
	val oSBuildType: String? = null,

	@field:SerializedName("OriginalInstallDate")
	val originalInstallDate: String? = null,

	@field:SerializedName("OSVersion")
	val oSVersion: String? = null,

	@field:SerializedName("BIOSVersion")
	val bIOSVersion: String? = null,

	@field:SerializedName("TotalPhysicalMemory")
	val totalPhysicalMemory: String? = null,

	@field:SerializedName("LogonServer")
	val logonServer: String? = null,

	@field:SerializedName("DHCPServer")
	val dHCPServer: List<String?>? = null,

	@field:SerializedName("VirtualizationEnabledInFirmware")
	val virtualizationEnabledInFirmware: String? = null,

	@field:SerializedName("HostName")
	val hostName: String? = null,

	@field:SerializedName("Status")
	val status: List<String?>? = null,

	@field:SerializedName("DHCPEnabled")
	val dHCPEnabled: String? = null,

	@field:SerializedName("BootDevice")
	val bootDevice: String? = null,

	@field:SerializedName("ProductID")
	val productID: String? = null,

	@field:SerializedName("VirtualMemory")
	val virtualMemory: String? = null,

	@field:SerializedName("TimeZone")
	val timeZone: String? = null,

	@field:SerializedName("SystemModel")
	val systemModel: String? = null,

	@field:SerializedName("Hyper-VRequirements")
	val hyperVRequirements: String? = null,

	@field:SerializedName("Processor(s)")
	val processorS: List<String?>? = null,

	@field:SerializedName("Hotfix(s)")
	val hotfixS: List<String?>? = null,

	@field:SerializedName("SecondLevelAddressTranslation")
	val secondLevelAddressTranslation: String? = null,

	@field:SerializedName("WindowsDirectory")
	val windowsDirectory: String? = null,

	@field:SerializedName("SystemBootTime")
	val systemBootTime: String? = null,

	@field:SerializedName("SystemDirectory")
	val systemDirectory: String? = null,

	@field:SerializedName("SystemManufacturer")
	val systemManufacturer: String? = null,

	@field:SerializedName("Domain")
	val domain: String? = null,

	@field:SerializedName("NetworkCard(s)")
	val networkCardS: List<String?>? = null
)
