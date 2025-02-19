/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.sandwich.coroutines

import com.skydoves.sandwich.DataSource
import com.skydoves.sandwich.adapters.internal.DataSourceCallDelegate
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * @author skydoves (Jaewoong Eum)
 *
 * CoroutinesDataSourceCallAdapter is an coroutines call adapter for creating [DataSource] from service method.
 *
 * request API network call asynchronously and returns [DataSource].
 */
@Deprecated(
  message = "CoroutinesDataSourceCallAdapter has been deprecated. Use `DataSourceCallAdapter` instead.",
  replaceWith = ReplaceWith("com.skydoves.sandwich.adapters.internal.DataSourceCallAdapter"),
  level = DeprecationLevel.WARNING
)
internal class CoroutinesDataSourceCallAdapter constructor(
  private val responseType: Type
) : CallAdapter<Type, Call<DataSource<Type>>> {

  override fun responseType(): Type {
    return responseType
  }

  override fun adapt(call: Call<Type>): Call<DataSource<Type>> {
    return DataSourceCallDelegate(call)
  }
}
